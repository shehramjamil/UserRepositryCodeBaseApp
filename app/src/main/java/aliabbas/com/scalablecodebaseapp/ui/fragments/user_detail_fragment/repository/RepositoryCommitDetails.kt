package aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.repository

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.data_source.RepositoryCommitsDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repository class for getting all commit related details for user repository.
 *
 */
class RepositoryCommitDetails @Inject constructor(var repository: RepositoryCommitsDataSource) {

    fun getCommitDetailsRepository(repositoryName: String): Flow<ApiResponse> {
        return repository.getCommitDetailsRepository(repositoryName)
    }

}