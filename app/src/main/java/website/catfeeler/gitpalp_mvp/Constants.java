package website.catfeeler.gitpalp_mvp;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public class Constants {
    private Constants() {}

    public interface Activity {
        String BUNDLE_KEY = "bundle_key";
    }

    public interface Api {
        long TIMEOUT = 40L;
    }

    public interface Preference {
        String TOKEN = "token";
    }
}
