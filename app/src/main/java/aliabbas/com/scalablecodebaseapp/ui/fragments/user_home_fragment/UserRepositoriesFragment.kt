package aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment

import aliabbas.com.scalablecodebaseapp.R
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse
import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.UserRepositoriesModel
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
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScoped
class UserRepositoriesFragment @Inject constructor() : DaggerFragment() {
    private var userRepositoriesScreenBinding: UserRepositoriesScreenBinding? = null

    private val userRepositoriesViewModel: UserRepositoriesViewModel by viewModels {
        viewModelFactory!!
    }

    @Inject
    @JvmField
    var viewModelFactory: UserRepositoryViewModelFactory? = null

    //Injecting an object for Adapter associated with the recyclerview
    //to display the item
    @Inject
    @JvmField
    var userRepositoriesAdapterAdapter: UserRepositoriesAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting up the specific ViewModel to this Fragment
        /*userRepositoriesViewModel =
            ViewModelProvider(this, viewModelFactory!!).get(
                UserRepositoriesViewModel::class.java
            )*/
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Binding the view to the specific DataBinding Object
        userRepositoriesScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_repositories_screen, container, false)
        //Binding the view to the lifecycle
        userRepositoriesScreenBinding!!.lifecycleOwner = this
        initializeView()
        userRepositoriesViewModel.listUserRepositories.observe(viewLifecycleOwner, { apiResponse ->
            when (apiResponse) {
                is ApiResponse.ApiResponseSuccess -> {
                    userRepositoriesScreenBinding!!.apiRequestProgressBar.visibility = View.GONE
                    userRepositoriesAdapterAdapter!!.setValues(apiResponse.responseData as List<UserRepositoriesModel>)
                }
                is ApiResponse.ApiFailure -> {
                    userRepositoriesScreenBinding!!.apiRequestProgressBar.visibility = View.GONE
                    userRepositoriesScreenBinding!!.textApiFailure.text = apiResponse.response
                }
                else -> {
                }
            }
        })
        return userRepositoriesScreenBinding!!.root
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
