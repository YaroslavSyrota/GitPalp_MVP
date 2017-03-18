package website.catfeeler.gitpalp_mvp.network;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public interface ApiRepository {

    @GET(Config.GET_USER)
    Observable<User> getCurrentUser(@Query(Config.ACCESS_TOKEN) String token);

    @GET(Config.GET_USER_REPO)
    Observable<List<UserRepository>> getCurrentUserRepos(@Query(Config.ACCESS_TOKEN) String token);

    @GET(Config.GET_REPO)
    Observable<SearchResponse> search(@Query(Config.SERACH) String searchQuery);
}
