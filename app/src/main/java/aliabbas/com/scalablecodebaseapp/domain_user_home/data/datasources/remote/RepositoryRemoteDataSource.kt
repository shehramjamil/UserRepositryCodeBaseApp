package aliabbas.com.scalablecodebaseapp.domain_user_home.data.datasources.remote

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse

/**
 * Created By Ali Abbas on on 21,December,2021
 * This Class is used for
 *
 */
interface RepositoryRemoteDataSource {

    suspend fun getListUserRepositories(): ApiResponse
}