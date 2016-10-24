package my.github.tomas.mygithub.mvp.presenter;

import java.util.List;

import my.github.tomas.mygithub.mvp.model.RepositoryResponse;
import my.github.tomas.mygithub.service.RepositoriesViewInterface;
import rx.Observer;

/**
 * Created by Tomas on 24/10/2016.
 */

public class RepositoriesPresenter extends BasePresenter implements Observer<List<RepositoryResponse>> {

    private RepositoriesViewInterface mViewInterface;

    public RepositoriesPresenter(RepositoriesViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }

    @Override
    public void onCompleted() {
        mViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<RepositoryResponse> repositoryResponse) {
        mViewInterface.onRepos(repositoryResponse);
    }

    public void fetchResponse() {
        unSubscribeAll();
        subscribe(mViewInterface.getRepos(), RepositoriesPresenter.this);
    }


}
