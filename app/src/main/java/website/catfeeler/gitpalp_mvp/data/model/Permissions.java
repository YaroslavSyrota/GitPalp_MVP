package website.catfeeler.gitpalp_mvp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public class Permissions implements Model {

    @SerializedName("admin")
    public boolean admin;
    @SerializedName("push")
    public boolean push;
    @SerializedName("pull")
    public boolean pull;
}
