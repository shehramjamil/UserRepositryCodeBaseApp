package aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.viewmodel_factory

import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.RepositoryCommitsViewModel
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.repository.RepositoryCommitDetails
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */
public class RepositoryCommitsViewModelFactory @Inject constructor(
    public var repositoryCommitsDataSource: RepositoryCommitDetails?
) : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryCommitsViewModel::class.java)) {
            return RepositoryCommitsViewModel(
                repositoryCommitsDataSource!!
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
