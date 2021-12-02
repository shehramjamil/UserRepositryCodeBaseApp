package aliabbas.com.scalablecodebaseapp.di

import aliabbas.com.scalablecodebaseapp.di.app_dependencies.ActivityBindingModule
import aliabbas.com.scalablecodebaseapp.di.app_dependencies.ApiServiceModule
import aliabbas.com.scalablecodebaseapp.AndroidApplication
import aliabbas.com.scalablecodebaseapp.di.app_dependencies.RepositoryModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * This is a Dagger component. Refer to [AndroidApplication] for the list of Dagger components
 * used in this application.
 *
 *
 * Even though Dagger allows annotating a [Component] as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in [ ].
 *
 *
 * //[AndroidSupportInjectionModule]
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ApiServiceModule::class, ActivityBindingModule::class,RepositoryModule::class]
)
interface AppComponent : AndroidInjector<AndroidApplication> {
    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
// never having to instantiate any modules or say which module we are passing the application to.
// Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder

        fun build(): AppComponent
    }
}