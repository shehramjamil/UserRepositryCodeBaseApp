package aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.UserRepositoriesModel
import aliabbas.com.scalablecodebaseapp.data.CommitRepositoryRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */
class RepositoryCommitsViewModel @Inject
constructor(private val repositoryCommitDetails: CommitRepositoryRepository) : ViewModel() {

    var repositoryDetailModel = MutableLiveData<UserRepositoriesModel>()

    private var _listRepositoryCommitDetailsFlow = MutableSharedFlow<ApiResponse>()
    val listRepositoryCommitDetailsFlow = _listRepositoryCommitDetailsFlow

    fun setUserRepositoryDetails(repositoryDetailScope: UserRepositoriesModel) {
        if (repositoryDetailModel.value == repositoryDetailScope) {
            return
        }
        viewModelScope.launch {
            repositoryDetailModel.value = repositoryDetailScope
            repositoryCommitDetails.getCommitDetailsRepository(repositoryDetailScope.name!!)
                .collect {
                    listRepositoryCommitDetailsFlow.emit(it)
                }
        }
    }
}