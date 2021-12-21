package aliabbas.com.scalablecodebaseapp.data

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created By Ali Abbas on on 20,December,2021
 * This Class is used for
 *
 */
interface CommitRepositoryRepository {
    suspend fun getCommitDetailsRepository(repositoryName: String): Flow<ApiResponse>
}