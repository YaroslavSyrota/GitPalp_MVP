package website.catfeeler.gitpalp_mvp.utils;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public class ValidationUtils {

    public boolean isValidLogin(String login) {
        return login.length() >=3;
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 3;
    }
}
