package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.view_model_factory

import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.UserRepositoriesViewModel
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.repository.UserRepositoriesRepository
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */
class UserRepositoryViewModelFactory @Inject constructor(
    private var userRepositoriesRepository: UserRepositoriesRepository?
) : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserRepositoriesViewModel::class.java)) {
            return UserRepositoriesViewModel(
                userRepositoriesRepository!!
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
