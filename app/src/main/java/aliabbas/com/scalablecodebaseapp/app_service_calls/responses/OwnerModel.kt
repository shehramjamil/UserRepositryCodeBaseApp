package aliabbas.com.scalablecodebaseapp.app_service_calls.responses

import com.google.gson.annotations.SerializedName

/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */
data class OwnerModel (
    val gistsUrl: String? = null,
    val reposUrl: String? = null,
    val followingUrl: String? = null,
    val starredUrl: String? = null,
    val login: String? = null,
    val followersUrl: String? = null,
    val type: String? = null,
    val url: String? = null,
    val subscriptionsUrl: String? = null,
    val receivedEventsUrl: String? = null,
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    val eventsUrl: String? = null,
    val htmlUrl: String? = null,
    val siteAdmin: Boolean? = null,
    val id: Int? = null,
    val gravatarId: String? = null,
    val nodeId: String? = null,
    val organizationsUrl: String? = null
)