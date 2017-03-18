package website.catfeeler.gitpalp_mvp.network;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import website.catfeeler.gitpalp_mvp.network.requests.LoginRequest;
import website.catfeeler.gitpalp_mvp.network.responses.LoginResponse;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public interface ApiAuthorization {

    @GET(Config.GET_AUTORIZATIONS)
    Observable<List<LoginResponse>> getAuthorizations(@Header(Config.HEADER_AUTORIZATION) String credentials);

    @DELETE(Config.DELETE_AUTHORIZATION)
    Observable<ResponseBody> delete(@Header(Config.HEADER_AUTORIZATION) String credentials,
                                    @Path(Config.ID) String id);

    @POST(Config.GET_AUTORIZATIONS)
    Observable<LoginResponse> loginUser(@Header(Config.HEADER_AUTORIZATION) String credentials,
                                    @Body LoginRequest loginRequest);
}
