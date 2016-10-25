package my.github.tomas.mygithub.service;

import java.util.List;

import my.github.tomas.mygithub.mvp.model.SingleRepositoryResponse;
import rx.Observable;

/**
 * Created by Tomas on 24/10/2016.
 */

public interface SingleRepositoryInterface {
    void onCompleted();

    void onError(String message);

    void onSingleRepository(List<SingleRepositoryResponse> singleRepoResponse);

    Observable<List<SingleRepositoryResponse>> getSingleRepository();
}
