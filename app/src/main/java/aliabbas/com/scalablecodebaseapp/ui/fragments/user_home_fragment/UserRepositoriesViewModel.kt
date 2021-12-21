package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment

import aliabbas.com.scalablecodebaseapp.R
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.data.UserRepository
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * View Model to care of all the data for Github User Repository
 * 1- Getting this User's repositories : "https://api.github.com/users/mralexgray/repos"
 */
class UserRepositoriesViewModel @Inject constructor(
    private var userRepository: UserRepository
) : ViewModel() {

    private val _listUserRepositories = MutableLiveData<ApiResponse>()
    var listUserRepositories: MutableLiveData<ApiResponse> =
        _listUserRepositories

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _listUserRepositories.value = ApiResponse.ApiFailure(exception.message!!)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            _listUserRepositories.value =
                userRepository.getListUserRepositoriesLiveData()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
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
