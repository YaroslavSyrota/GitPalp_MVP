package website.catfeeler.gitpalp_mvp.domain.interactors;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.domain.repository.ProfileRepository;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public class ProfileInteractor {

    private ProfileRepository profileepository;

    @Inject
    public ProfileInteractor(ProfileRepository profileepository) {
        this.profileepository = profileepository;
    }

    public Observable<User> getUser(String token) {
        return profileepository.getUser(token);
    }

    public Observable<List<UserRepository>> getUserRepositories(String token) {
        return profileepository.getUserRepositories(token);
    }

    public Observable<SearchResponse> getSearchResponse(String querry) {
        return profileepository.getSearch(querry);
    }
}
