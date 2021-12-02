package aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment

import aliabbas.com.scalablecodebaseapp.R
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.custom_views.model.BarData
import aliabbas.com.scalablecodebaseapp.databinding.UserRepositoryDetailScreenBinding
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.viewmodel_factory.RepositoryCommitsViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * This fragment is responsible for displaying user repository and commit details
 *
 */
class RepositoryCommitsDetailFragment @Inject constructor() : DaggerFragment() {
    //Databinding object
    private var userRepositoryDetailScreenBinding: UserRepositoryDetailScreenBinding? = null
    private val arguments: RepositoryCommitsDetailFragmentArgs by navArgs()

    @Inject
    @JvmField
    var viewModelFactory: RepositoryCommitsViewModelFactory? = null

    //ViewModel for the specific screen
    //private var viewModel: RepositoryCommitsViewModel? = null
    private val viewModel: RepositoryCommitsViewModel by viewModels {
        viewModelFactory!!
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Setting up the screen title
        requireActivity().setTitle(R.string.app_name)
        //Binding the view to relevant DataBinding Object
        userRepositoryDetailScreenBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.user_repository_detail_screen,
                container,
                false
            )
        viewModel.setUserRepositoryDetails(arguments.userRepository)
        userRepositoryDetailScreenBinding!!.viewModel = viewModel

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listRepositoryCommitDetailsFlow
                    .collect {
                        when (it) {
                            is ApiResponse.ApiResponseSuccess -> {
                                userRepositoryDetailScreenBinding!!.apiRequestProgressBar.visibility =
                                    View.GONE
                                val listOfCommitsByMonths = it.responseData as ArrayList<*>
                                val arrayBarData: Array<BarData> =
                                    listOfCommitsByMonths.toArray(arrayOfNulls(listOfCommitsByMonths.size))
                                userRepositoryDetailScreenBinding!!.barChart.setBarDataToDisplay(
                                    arrayBarData
                                )
                            }
                            is ApiResponse.ApiFailure -> {
                                userRepositoryDetailScreenBinding!!.apiRequestProgressBar.visibility =
                                    View.GONE
                                userRepositoryDetailScreenBinding!!.textApiFailure.text =
                                    it.response
                            }
                            is ApiResponse.ProgressLoadingState -> {
                                userRepositoryDetailScreenBinding!!.apiRequestProgressBar.visibility =
                                    View.GONE
                                userRepositoryDetailScreenBinding!!.apiRequestProgressBar.visibility =
                                    View.VISIBLE
                            }

                        }
                    }
            }
        }
        //Binding the lifecycle with the view
        userRepositoryDetailScreenBinding!!.lifecycleOwner = this
        return userRepositoryDetailScreenBinding!!.root
    }

    /*fun <T> Flow<T>.handleErrors(): Flow<T> =
        catch { exception ->
            Log.i(
                "commitsResults",
                "commitsResults: ${exception.message} "
            )
     }*/
}
