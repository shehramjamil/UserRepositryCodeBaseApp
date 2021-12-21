package aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.data_source

import aliabbas.com.scalablecodebaseapp.app_service_calls.Api
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.repo_commits.RepositoryCommitsDetailModel
import aliabbas.com.scalablecodebaseapp.commons.Constants.COMMITS
import aliabbas.com.scalablecodebaseapp.commons.Constants.REPO_COMMITS_URL
import aliabbas.com.scalablecodebaseapp.custom_views.model.BarData
import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryCommitsRemoteDataSource
import android.annotation.SuppressLint
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * DataSource class for getting all commit related details for user repository.
 *
 */
class RepositoryCommitsDataSource @Inject constructor(var api: Api) :
    RepositoryCommitsRemoteDataSource {

    override suspend fun getCommitDetailsRepository(repositoryName: String) =
        repositoryCommitDetailsByMonths(repositoryName)


    /**
     * This function gets all commit related details for user repository and sort it by month.
     *
     */
    private fun repositoryCommitDetailsByMonths(
        repositoryName: String?
    ): Flow<ApiResponse> = flow {
        try {
            val repositoryCommitDetailUrl = REPO_COMMITS_URL + repositoryName + COMMITS
            emit(ApiResponse.ProgressLoadingState)
            val repositoryCommitData =
                api.getRepositoryCommitDetailsCall(repositoryCommitDetailUrl)
            val sortDatesForCommits: ArrayList<BarData> =
                sortDatesForCommits(repositoryCommitData)
            emit(ApiResponse.ApiResponseSuccess(sortDatesForCommits))
            Log.i("commit respo", "commit respo: start")
        } catch (ex: Exception) {
            emit(ApiResponse.ApiFailure("Exception occur: ${ex.message}"))
        }
    }

    /**
     * This function is responsible for segregating user's repository commits by month's
     */
    @SuppressLint("SimpleDateFormat")
    fun sortDatesForCommits(listRepositoryCommitsDetailModel: List<RepositoryCommitsDetailModel>): ArrayList<BarData> {
        //Assigning months to repository by getting the details from commit dates
        for (repositoryCommitsDetailModel in listRepositoryCommitsDetailModel) {
            val commitDate: Date = repositoryCommitsDetailModel.commit!!.committer!!.date!!
            val c: Calendar = Calendar.getInstance()
            c.timeInMillis = commitDate.time
            val month: String =
                c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())!!
            repositoryCommitsDetailModel.commit.committer!!.months = month
        }

        //Applied group by based on the months, as I have assign in above code.
        val groupCommitByMonths =
            listRepositoryCommitsDetailModel.groupBy { it.commit!!.committer!!.months }
        val arrayList = ArrayList<BarData>()
        for (groupKeyValue in groupCommitByMonths) {
            val barData =
                BarData(groupKeyValue.key?.substring(0, 3)!!, groupKeyValue.value.size)
            arrayList.add(barData)
        }
        return arrayList
    }

}