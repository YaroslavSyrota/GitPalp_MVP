package website.catfeeler.gitpalp_mvp.domain.repository;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;
import website.catfeeler.gitpalp_mvp.network.requests.LoginRequest;
import website.catfeeler.gitpalp_mvp.network.responses.LoginResponse;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public interface LoginRepository {
    Observable<List<LoginResponse>> getAuthorizations(String credentials);
    Observable<ResponseBody> deleteAuth(String basic, String id);
    Observable<LoginResponse> loginUser(String basic, LoginRequest loginRequest);
}
