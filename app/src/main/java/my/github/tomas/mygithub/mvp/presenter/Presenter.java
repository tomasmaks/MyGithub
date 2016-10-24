package my.github.tomas.mygithub.mvp.presenter;

/**
 * Created by Tomas on 24/10/2016.
 */

public interface Presenter {

    void onCreate();
    void onPause();
    void onResume();
    void onDestroy();
}
