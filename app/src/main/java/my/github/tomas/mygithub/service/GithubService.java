package my.github.tomas.mygithub.service;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tomas on 24/10/2016.
 */

public class GithubService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );
}
