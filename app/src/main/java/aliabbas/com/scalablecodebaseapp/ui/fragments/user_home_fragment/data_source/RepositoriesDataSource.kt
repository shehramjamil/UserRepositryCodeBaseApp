package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.data_source

import aliabbas.com.scalablecodebaseapp.app_service_calls.Api
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.commons.Constants
import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryDataSource
import javax.inject.Inject

class RepositoriesDataSource @Inject constructor(var api: Api) :
    RepositoryDataSource {

    override suspend fun getListUserRepositories(): ApiResponse {
        val listUserRepositories =
            api.getUserGithunRepositories(Constants.USER_REPO_LINK)
        return ApiResponse.ApiResponseSuccess(listUserRepositories)
    }

}