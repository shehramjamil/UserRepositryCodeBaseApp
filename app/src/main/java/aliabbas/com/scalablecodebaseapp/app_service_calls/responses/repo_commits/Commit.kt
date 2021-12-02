package aliabbas.com.scalablecodebaseapp.app_service_calls.responses.repo_commits

/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */
data class Commit(
    val commentCount: Int? = null,
    val committer: Committer? = null,
    val author: Author? = null,
    val tree: Tree? = null,
    val message: String? = null,
    val url: String? = null,
    val verification: Verification? = null
)