package aliabbas.com.scalablecodebaseapp.domain_user_home.data.datasources.remote

import aliabbas.com.scalablecodebaseapp.app_service_calls.Api
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.commons.Constants
import javax.inject.Inject

class RepositoriesRemoteDataSourceImpl @Inject constructor(
    var api: Api
) : RepositoryRemoteDataSource {

    override suspend fun getListUserRepositories(): ApiResponse {
        val listUserRepositories = api.getUserGithubRepositories(Constants.USER_REPO_LINK)
        return ApiResponse.ApiResponseSuccess(listUserRepositories)
    }
}