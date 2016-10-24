package my.github.tomas.mygithub.application;

import android.app.Application;

import my.github.tomas.mygithub.dependencies.ApiComponent;
import my.github.tomas.mygithub.dependencies.DaggerApiComponent;
import my.github.tomas.mygithub.dependencies.DaggerNetworkComponent;
import my.github.tomas.mygithub.dependencies.NetworkComponent;
import my.github.tomas.mygithub.dependencies.NetworkModule;
import my.github.tomas.mygithub.utils.Constants;

/**
 * Created by Tomas on 24/10/2016.
 */

public class GithubApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    private NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constants.BASE_URL))
                .build();
    }

    public ApiComponent getmApiComponent() {
        return mApiComponent;
    }

}
