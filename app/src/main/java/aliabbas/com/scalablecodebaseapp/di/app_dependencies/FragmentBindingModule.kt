package aliabbas.com.scalablecodebaseapp.di.app_dependencies

import aliabbas.com.scalablecodebaseapp.di.app_scopes.FragmentScoped
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.RepositoryCommitsDetailFragment
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.UserRepositoriesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created By Ali Abbas
 * This Class is used for
 */
@Module
abstract class FragmentBindingModule {
    //Use this annotation for any activity or fragment related to view.
    @FragmentScoped
    @ContributesAndroidInjector //Used to inject the fragment object.
    abstract fun userRepositoriesFragment(): UserRepositoriesFragment?

    //Use this annotation for any activity or fragment related to view.
    @FragmentScoped
    @ContributesAndroidInjector //Used to inject the fragment object.
    abstract fun repositoryCommitsDetailFrag(): RepositoryCommitsDetailFragment?
}