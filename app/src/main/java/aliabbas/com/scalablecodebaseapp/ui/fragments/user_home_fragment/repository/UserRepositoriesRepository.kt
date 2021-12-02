package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.repository

import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.data_source.UserRepositoriesDataSource
import javax.inject.Inject

class UserRepositoriesRepository @Inject constructor(var userRepositoriesDataSource: UserRepositoriesDataSource) {

    var listUserRepositories = userRepositoriesDataSource.listUserRepositoriesLiveData

    suspend fun getListUserRepositoriesLiveData() {
        userRepositoriesDataSource.getListUserRepositories()
    }


}