package aliabbas.com.scalablecodebaseapp.data.remote

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created By Ali Abbas on on 21,December,2021
 * This Class is used for
 *
 */
interface RepositoryCommitsRemoteDataSource {

    fun getCommitDetailsRepository(repositoryName: String): Flow<ApiResponse>
}