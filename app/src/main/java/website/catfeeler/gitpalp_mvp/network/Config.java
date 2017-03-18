package website.catfeeler.gitpalp_mvp.network;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public final class Config {
    private Config() {}

    public static final String BASE_URL = "https://api.github.com";

    public static final String GET_AUTORIZATIONS    = "authorizations";
    public static final String DELETE_AUTHORIZATION = "authorizations/{id}";
    public static final String GET_USER             = "user";
    public static final String GET_USER_REPO        = "user/repos";
    public static final String GET_REPO             = "search/repositories";

    public static final String ACCESS_TOKEN         = "access_token";
    public static final String HEADER_AUTORIZATION  = "Authorization";
    public static final String ID                   = "id";
    public static final String SERACH               = "q";
}
