package website.catfeeler.gitpalp_mvp.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import website.catfeeler.gitpalp_mvp.data.model.Repository;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public class SearchResponse {

    @SerializedName("total_count")
    public int totalCount;
    @SerializedName("incomplete_results")
    public boolean incompleteResults;
    @SerializedName("items")
    public List<Repository> items;
}
