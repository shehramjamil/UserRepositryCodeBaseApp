package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment

import aliabbas.com.scalablecodebaseapp.R
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.domain_user_home.data.model.UserRepositoriesModel
import aliabbas.com.scalablecodebaseapp.databinding.UserRepositoriesScreenBinding
import aliabbas.com.scalablecodebaseapp.di.app_scopes.ActivityScoped
import aliabbas.com.scalablecodebaseapp.ui.adapter.UserRepositoriesAdapter
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.view_model_factory.UserRepositoryViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@ActivityScoped
class UserRepositoriesFragment : DaggerFragment() {
    private var userRepositoriesScreenBinding: UserRepositoriesScreenBinding? = null

    private val userRepositoriesViewModel: UserRepositoriesViewModel by viewModels {
        viewModelFactory!!
    }

    @Inject
    @JvmField
    var viewModelFactory: UserRepositoryViewModelFactory? = null

    @Inject
    @JvmField
    var userRepositoriesAdapterAdapter: UserRepositoriesAdapter? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userRepositoriesScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_repositories_screen, container, false)
        userRepositoriesScreenBinding?.viewModel = userRepositoriesViewModel
        userRepositoriesScreenBinding?.lifecycleOwner = this.viewLifecycleOwner

        initializeView()

        userRepositoriesViewModel.listUserRepositories.observe(viewLifecycleOwner, observer)

        return userRepositoriesScreenBinding!!.root
    }

    private val observer = Observer<ApiResponse> { apiResponse ->
        when (apiResponse) {
            is ApiResponse.ApiResponseSuccess -> {
                userRepositoriesScreenBinding?.apiRequestProgressBar?.visibility = View.GONE
                userRepositoriesAdapterAdapter?.setValues(apiResponse.responseData as List<UserRepositoriesModel>)
            }
            is ApiResponse.ApiFailure -> {
                userRepositoriesScreenBinding!!.apiRequestProgressBar.visibility = View.GONE
                userRepositoriesScreenBinding!!.textApiFailure.text = apiResponse.response
            }
            else -> {
            }
        }

    }

    private fun initializeView() {
        setHasOptionsMenu(true)
        userRepositoriesScreenBinding?.recyclerViewRepositories?.run {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            adapter = userRepositoriesAdapterAdapter
            setHasFixedSize(true)
        }
    }
}
