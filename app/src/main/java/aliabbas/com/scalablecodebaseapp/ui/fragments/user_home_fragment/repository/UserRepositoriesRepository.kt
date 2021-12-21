package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.repository

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.data.UserRepository
import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryDataSource
import javax.inject.Inject

class UserRepositoriesRepository @Inject constructor(private var dataSource: RepositoryDataSource) :
    UserRepository {

    override suspend fun getListUserRepositoriesLiveData(): ApiResponse {
        return dataSource.getListUserRepositories()
    }
}