package my.github.tomas.mygithub.dependencies;

import dagger.Component;
import my.github.tomas.mygithub.mvp.view.activity.MainActivity;
import my.github.tomas.mygithub.mvp.view.activity.RepositoryActivity;
import my.github.tomas.mygithub.mvp.view.fragment.RepositoriesFragment;

/**
 * Created by Tomas on 24/10/2016.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(RepositoriesFragment fragment);
    void inject(MainActivity mainActivity);
    void inject(RepositoryActivity repositoryActivity);
}
