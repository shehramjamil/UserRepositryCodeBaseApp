package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.view_model_factory

import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.UserRepositoriesViewModel
import aliabbas.com.scalablecodebaseapp.domain_user_home.data.UserRepositoriesRepositoryImpl
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */

// Try to use hilt for upcoming assignments and reduce the boilerplate

class UserRepositoryViewModelFactory @Inject constructor(
    private var userRepositoriesRepositoryImpl: UserRepositoriesRepositoryImpl?
) : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserRepositoriesViewModel::class.java)) {
            return UserRepositoriesViewModel(
                userRepositoriesRepositoryImpl!!
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
