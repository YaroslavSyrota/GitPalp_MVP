package website.catfeeler.gitpalp_mvp.di;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
