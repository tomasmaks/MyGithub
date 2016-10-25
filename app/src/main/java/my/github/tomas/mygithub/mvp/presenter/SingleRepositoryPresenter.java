package my.github.tomas.mygithub.mvp.presenter;

import java.util.List;

import my.github.tomas.mygithub.mvp.model.SingleRepositoryResponse;
import my.github.tomas.mygithub.service.SingleRepositoryInterface;
import rx.Observer;

/**
 * Created by Tomas on 24/10/2016.
 */

public class SingleRepositoryPresenter extends BasePresenter implements Observer<List<SingleRepositoryResponse>> {

    private SingleRepositoryInterface mViewInterface;

    public SingleRepositoryPresenter(SingleRepositoryInterface mViewInterface) {
        this.mViewInterface = mViewInterface;
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
    public void onNext(List<SingleRepositoryResponse> singleRepositoryResponseList) {
        mViewInterface.onSingleRepository(singleRepositoryResponseList);
    }

    public void fetchSingleRepos() {
        unSubscribeAll();
        subscribe(mViewInterface.getSingleRepository(), SingleRepositoryPresenter.this);
    }



}
