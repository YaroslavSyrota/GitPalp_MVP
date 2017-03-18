package website.catfeeler.gitpalp_mvp.data.providers;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import website.catfeeler.gitpalp_mvp.domain.repository.LoginRepository;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;
import website.catfeeler.gitpalp_mvp.network.requests.LoginRequest;
import website.catfeeler.gitpalp_mvp.network.responses.LoginResponse;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public class LoginProvider implements LoginRepository {

    private RestApiClient restApiClient;

    @Inject
    public LoginProvider(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public Observable<List<LoginResponse>> getAuthorizations(String credentials) {
        return restApiClient.auth().getAuthorizations(credentials);
    }

    @Override
    public Observable<ResponseBody> deleteAuth(String basic, String id) {
        return restApiClient.auth().delete(basic, id);
    }

    @Override
    public Observable<LoginResponse> loginUser(String basic, LoginRequest loginRequest) {
        return restApiClient.auth().loginUser(basic, loginRequest);
    }
}
