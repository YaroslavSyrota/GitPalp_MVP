package website.catfeeler.gitpalp_mvp.domain.interactors;

import javax.inject.Inject;

import rx.Observable;
import website.catfeeler.gitpalp_mvp.domain.repository.RepositoriesRepository;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class RepositoriesInteractor {

    private RepositoriesRepository repositoriesRepository;

    @Inject
    public RepositoriesInteractor(RepositoriesRepository repositoriesRepository) {
        this.repositoriesRepository = repositoriesRepository;
    }

    public Observable<SearchResponse> getSearchRepo(String query) {
        return repositoriesRepository.getSearchRepo(query);
    }
}
