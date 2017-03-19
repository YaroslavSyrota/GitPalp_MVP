package website.catfeeler.gitpalp_mvp.domain.repository;

import rx.Observable;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public interface RepositoriesRepository {
    Observable<SearchResponse> getSearchRepo(String query);
}
