package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.data_source

import aliabbas.com.scalablecodebaseapp.app_service_calls.Api
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.commons.Constants
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class UserRepositoriesDataSource @Inject constructor(var api: Api) {

    val listUserRepositoriesLiveData: MutableLiveData<ApiResponse> = MutableLiveData()

    suspend fun getListUserRepositories() {
        val listUserRepositories =
            api.getUserGithunRepositories(Constants.USER_REPO_LINK)
        listUserRepositoriesLiveData.value =
            ApiResponse.ApiResponseSuccess(listUserRepositories)
    }

}