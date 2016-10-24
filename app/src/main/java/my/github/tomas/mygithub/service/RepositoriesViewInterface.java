package my.github.tomas.mygithub.service;

import java.util.List;
import my.github.tomas.mygithub.mvp.model.RepositoryResponse;
import rx.Observable;

/**
 * Created by Tomas on 24/10/2016.
 */

public interface RepositoriesViewInterface {

    void onCompleted();

    void onError(String message);

    void onRepos(List<RepositoryResponse> repositoriesResponses);

    Observable<List<RepositoryResponse>> getRepos();

}
