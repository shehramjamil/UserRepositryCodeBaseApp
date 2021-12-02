package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment

import aliabbas.com.scalablecodebaseapp.R
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.UserRepositoriesModel
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.repository.UserRepositoriesRepository
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * View Model to care of all the data for Github User Repository
 * 1- Getting this User's repositories : "https://api.github.com/users/mralexgray/repos"
 */
class UserRepositoriesViewModel @Inject constructor(
    var userRepositoriesRepository: UserRepositoriesRepository
) : ViewModel() {

    private var _listUserRepositories: MutableLiveData<ApiResponse> =
        userRepositoriesRepository.listUserRepositories
    var listUserRepositories: MutableLiveData<ApiResponse> =
        _listUserRepositories


    private val _sharedViewEffects = MutableSharedFlow<UserRepositoriesModel>() // 1

    val sharedViewEffects = _sharedViewEffects.asSharedFlow() // 2

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _listUserRepositories.value = ApiResponse.ApiFailure(exception.message!!)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            userRepositoriesRepository.getListUserRepositoriesLiveData()

            /*for (i in 1..100) { // 2
                delay(5000) // 3
                _sharedViewEffects.emit(UserRepositoriesModel()) // 4
                Log.i("viewModelScope", "viewModelScope: start")
            }*/
        }
    }

    companion object {
        /**
         * This function is used to display the image of User repository
         * that I am displaying in RecyclerView with the help of Databinding
         */
        @JvmStatic
        @BindingAdapter("imageUrl", "errorImage")
        fun loadImage(view: ImageView, url: String, errorImage: Drawable) {
            Glide
                .with(view.context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(errorImage)
                .into(view)

        }
    }
}
