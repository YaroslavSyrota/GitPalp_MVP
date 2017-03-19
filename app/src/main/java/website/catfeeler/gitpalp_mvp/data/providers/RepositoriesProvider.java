package website.catfeeler.gitpalp_mvp.data.providers;

import javax.inject.Inject;

import rx.Observable;
import website.catfeeler.gitpalp_mvp.domain.repository.RepositoriesRepository;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class RepositoriesProvider implements RepositoriesRepository {

    private RestApiClient restApiClient;

    @Inject
    public RepositoriesProvider(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public Observable<SearchResponse> getSearchRepo(String query) {
        return restApiClient.repo().search(query);
    }
}
