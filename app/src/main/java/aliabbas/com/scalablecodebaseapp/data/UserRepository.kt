package aliabbas.com.scalablecodebaseapp.data

import aliabbas.com.scalablecodebaseapp.app_service_calls.responses.ApiResponse

/**
 * Created By Ali Abbas on on 20,December,2021
 * This Class is used for
 *
 */
interface UserRepository {
    suspend fun getListUserRepositoriesLiveData(): ApiResponse
}