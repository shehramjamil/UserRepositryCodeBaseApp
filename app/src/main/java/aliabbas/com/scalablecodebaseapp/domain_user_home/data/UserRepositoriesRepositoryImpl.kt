package aliabbas.com.scalablecodebaseapp.domain_user_home.data

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.domain_user_home.data.datasources.remote.RepositoryRemoteDataSource
import aliabbas.com.scalablecodebaseapp.domain_user_home.domain.repository.UserRepository
import javax.inject.Inject


// Repository can talk to two types of sources
// 1. local or 2. Remote
// here you have to define which data source repository is talking to
class UserRepositoriesRepositoryImpl @Inject constructor(
    private var remoteDataSource: RepositoryRemoteDataSource
) : UserRepository {

    override suspend fun getListUserRepositoriesLiveData(): ApiResponse {
        return remoteDataSource.getListUserRepositories()
    }
}