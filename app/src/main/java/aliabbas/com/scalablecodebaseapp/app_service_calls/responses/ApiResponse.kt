package aliabbas.com.scalablecodebaseapp.app_service_calls.responses

/**
 * Created By Ali Abbas
 * This Class is used for setting up the success response of failure response
 * based on result we received from the server
 * and work accordingly
 *
 */
sealed class ApiResponse {
    //Means Received Data with any error
    data class ApiResponseSuccess(val responseData: Any) : ApiResponse()

    //Means Error occur while receiving the data
    data class ApiFailure(val response: String) : ApiResponse()

    //Means Error occur while receiving the data
    object ProgressLoadingState : ApiResponse()
}