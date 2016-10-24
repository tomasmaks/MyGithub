package my.github.tomas.mygithub.service;

import java.util.List;

import my.github.tomas.mygithub.mvp.model.RepositoryResponse;
import my.github.tomas.mygithub.mvp.model.UserResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tomas on 24/10/2016.
 */

public interface GithubService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );
}
