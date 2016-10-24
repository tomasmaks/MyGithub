package my.github.tomas.mygithub.mvp.presenter;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tomas on 24/10/2016.
 */

public class BasePresenter implements Presenter {

    private CompositeSubscription mCompositeSubscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        configureSubscribtion();
    }

    private CompositeSubscription configureSubscribtion() {
        if(mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()){
            mCompositeSubscription = new CompositeSubscription();
        }
        return mCompositeSubscription;
    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if(mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription.clear();
        }
    }

    protected <F> void subscribe(Observable<F> observable, Observer<F> observer) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        configureSubscribtion().add(subscription);
    }
}
