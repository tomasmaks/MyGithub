package my.github.tomas.mygithub.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Tomas on 24/10/2016.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {

    Retrofit retrofit();
}