package my.github.tomas.mygithub.dependencies;

import dagger.Module;
import dagger.Provides;
import my.github.tomas.mygithub.service.GithubService;
import retrofit2.Retrofit;

/**
 * Created by Tomas on 24/10/2016.
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    GithubService provideRepoService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

}
