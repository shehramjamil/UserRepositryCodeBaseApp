package aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.repository

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.data.repository.CommitRepositoryRepository
import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryCommitsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repository class for getting all commit related details for user repository.
 *
 */
class RepositoryCommitDetails @Inject constructor(var repository: RepositoryCommitsRemoteDataSource) :
    CommitRepositoryRepository {

    override fun getCommitDetailsRepository(repositoryName: String): Flow<ApiResponse> {
        return repository.getCommitDetailsRepository(repositoryName)
    }

}