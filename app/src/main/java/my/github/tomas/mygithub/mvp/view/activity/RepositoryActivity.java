package my.github.tomas.mygithub.mvp.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import my.github.tomas.mygithub.R;
import my.github.tomas.mygithub.application.GithubApplication;
import my.github.tomas.mygithub.mvp.model.SingleRepositoryResponse;
import my.github.tomas.mygithub.mvp.presenter.SingleRepositoryPresenter;
import my.github.tomas.mygithub.mvp.view.adapter.SingleRepositoryAdapter;
import my.github.tomas.mygithub.service.GithubService;
import my.github.tomas.mygithub.service.SingleRepositoryInterface;
import my.github.tomas.mygithub.utils.RepositoryClickListener;
import rx.Observable;

/**
 * Created by Tomas on 24/10/2016.
 */

public class RepositoryActivity extends AppCompatActivity implements SingleRepositoryInterface, RepositoryClickListener {

    @Inject
    GithubService mService;

    private ProgressDialog mDialog;
    private SingleRepositoryPresenter mPresenter;
    private SingleRepositoryAdapter mAdapter;

    RecyclerView mRecyclerView;
    public static String CODE_URL = "my.github.tomas.mygithub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        resolveDependency();
        configView();
        mPresenter = new SingleRepositoryPresenter(RepositoryActivity.this);
        mPresenter.onCreate();
    }

    private void configView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new SingleRepositoryAdapter(this, getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void resolveDependency() {
        ((GithubApplication) getApplication())
                .getmApiComponent()
                .inject(RepositoryActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchSingleRepos();
        mDialog = new ProgressDialog(RepositoryActivity.this);
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading List");
        mDialog.setMessage("Please wait...");
        mDialog.show();
    }

    @Override
    public void onCompleted() {
        mDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSingleRepository(List<SingleRepositoryResponse> singleRepoResponse) {
        mAdapter.addSingleRepos(singleRepoResponse);
    }

    @Override
    public Observable<List<SingleRepositoryResponse>> getSingleRepository() {
        return mService.getSingleRepository(MainActivity.mCurrentUser, MainActivity.mCurrentRepository, MainActivity.mRepositoryPath);
    }

    @Override
    public void onClick(int position, String name, String type, String download_url) {

        // TODO fix the inner directory
        switch (type) {
            case "dir": {
                MainActivity.mRepositoryPath = MainActivity.mRepositoryPath + "/" + name;
                Toast.makeText(RepositoryActivity.this, "PATH: " + MainActivity.mRepositoryPath + " NAME: " + name , Toast.LENGTH_SHORT).show();
                onResume();
            }
            break;
            case "file": {
                Intent webViewIntent = new Intent(RepositoryActivity.this, RepositoryWebviewActivity.class);
                webViewIntent.putExtra(CODE_URL, download_url);
                startActivity(webViewIntent);

        }
    }

    }

}
