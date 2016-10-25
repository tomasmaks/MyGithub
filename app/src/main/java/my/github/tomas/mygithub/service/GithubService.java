package my.github.tomas.mygithub.service;

import java.util.List;

import my.github.tomas.mygithub.mvp.model.RepositoryResponse;
import my.github.tomas.mygithub.mvp.model.SingleRepositoryResponse;
import my.github.tomas.mygithub.mvp.model.UserResponse;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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

    @GET("/users/{user}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(@Path("user") String user);



    @GET("/repos/{user}/{repository}/contents{path}")
    Observable<List<SingleRepositoryResponse>> getSingleRepository(@Path("user") String user, @Path("repository") String repository, @Path("path") String path);

//    @GET("/repos/{user}/{repository}")
//    Observable<List<SingleRepositoryResponse>> getSingleRepository(@Path("user") String user, @Path("repository") String repository);


}
