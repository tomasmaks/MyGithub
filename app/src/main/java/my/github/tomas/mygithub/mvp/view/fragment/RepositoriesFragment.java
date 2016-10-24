package my.github.tomas.mygithub.mvp.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import my.github.tomas.mygithub.R;
import my.github.tomas.mygithub.application.GithubApplication;
import my.github.tomas.mygithub.mvp.presenter.RepositoriesPresenter;
import my.github.tomas.mygithub.mvp.view.activity.MainActivity;
import my.github.tomas.mygithub.mvp.view.adapter.RepositoriesAdapter;
import my.github.tomas.mygithub.mvp.model.RepositoryResponse;
import my.github.tomas.mygithub.service.GithubService;
import my.github.tomas.mygithub.service.RepositoriesViewInterface;
import my.github.tomas.mygithub.mvp.view.activity.RepositoriesActivity;
import my.github.tomas.mygithub.utils.GithubClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Observable;
/**
 * Created by Tomas on 24/10/2016.
 */

public class RepositoriesFragment extends Fragment implements RepositoriesViewInterface, GithubClickListener{

    @Inject
    GithubService mService;

    public static final String EXTRA_MESSAGE = "my.github.tomas.mygithub.MESSAGE";

    private ProgressDialog mDialog;
    private RepositoriesPresenter mPresenter;
    private RepositoriesAdapter mAdapter;

    RecyclerView mRecyclerView;

    public RepositoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resolveDependency();
        ButterKnife.bind(getActivity());

        mPresenter = new RepositoriesPresenter(RepositoriesFragment.this);
        mPresenter.onCreate();

    }

    private void resolveDependency() {
        ((GithubApplication) getActivity().getApplication())
                .getmApiComponent()
                .inject(RepositoriesFragment.this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recycler_layout, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RepositoriesAdapter(RepositoriesFragment.this, inflater);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onClick(int position, String name) {
        MainActivity.mRepositoryPath = "";
        Toast.makeText(getActivity(), "You just clicked on " + name, Toast.LENGTH_SHORT).show();
        MainActivity.mCurrentRepository = name;
        Intent repoIntent = new Intent(getActivity(), RepositoriesActivity.class);
        RepositoriesFragment.this.startActivity(repoIntent);
    }

    @Override
    public void onCompleted() { mDialog.dismiss(); }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchResponse();
        mDialog = new ProgressDialog(getActivity());
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading List");
        mDialog.setMessage("Please wait...");
        mDialog.show();
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRepos(List<RepositoryResponse> repositoryResponse) {
        mAdapter.addRepos(repositoryResponse);
    }

    @Override
    public Observable<List<RepositoryResponse>> getRepos() {
        return mService.getUsersRepositories(MainActivity.mCurrentUser);
    }

}

