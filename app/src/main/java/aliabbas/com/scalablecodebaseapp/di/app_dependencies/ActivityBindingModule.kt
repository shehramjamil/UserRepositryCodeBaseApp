package aliabbas.com.scalablecodebaseapp.di.app_dependencies

import aliabbas.com.scalablecodebaseapp.di.app_scopes.ActivityScoped
import aliabbas.com.scalablecodebaseapp.ui.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created By Ali Abbas
 * This Class is used for
 */
@Module
abstract class ActivityBindingModule {
    //This will allow the HomeActivity to inject the dependencies
    //
    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeActivityRefMod::class,
        FragmentBindingModule::class]) //Used to inject the activity object.
    abstract fun mainActivityDependency(): HomeActivity
}