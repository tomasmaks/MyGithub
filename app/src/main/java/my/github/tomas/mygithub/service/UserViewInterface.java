package my.github.tomas.mygithub.service;

import java.util.List;

import my.github.tomas.mygithub.mvp.model.RepositoryResponse;
import my.github.tomas.mygithub.mvp.model.UserResponse;
import rx.Observable;

/**
 * Created by Tomas on 24/10/2016.
 */

public interface UserViewInterface {

    void onCompleted();

    void onError(String message);

    void onRepos(List<UserResponse> userResponses);

    Observable<List<UserResponse>> getUsers();
}
