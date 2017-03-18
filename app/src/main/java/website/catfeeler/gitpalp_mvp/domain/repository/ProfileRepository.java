package website.catfeeler.gitpalp_mvp.domain.repository;

import java.util.List;

import rx.Observable;
import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public interface ProfileRepository {
    Observable<User> getUser(String token);
    Observable<List<UserRepository>> getUserRepositories(String token);
    Observable<SearchResponse> getSearch(String query);
}
