package website.catfeeler.gitpalp_mvp.data.providers;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.domain.repository.ProfileRepository;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public class ProfileProvider implements ProfileRepository {

    private RestApiClient restApiClient;

    @Inject
    public ProfileProvider(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public Observable<User> getUser(String token) {
        return restApiClient.repo().getCurrentUser(token);
    }

    @Override
    public Observable<List<UserRepository>> getUserRepositories(String token) {
        return restApiClient.repo().getCurrentUserRepos(token);
    }

    @Override
    public Observable<SearchResponse> getSearch(String query) {
        return restApiClient.repo().search(query);
    }
}
