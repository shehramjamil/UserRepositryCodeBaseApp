package aliabbas.com.scalablecodebaseapp.app_service_calls.responses.repo_commits

import kotlinx.parcelize.RawValue

data class RepositoryCommitsDetailModel(
    val committer: @RawValue Committer? = null,
    val author: @RawValue Author? = null,
    val htmlUrl: @RawValue String? = null,
    val commit: @RawValue Commit? = null,
    val commentsUrl: String? = null,
    val sha: String? = null,
    val url: String? = null,
    val nodeId: String? = null,
    val parents: @RawValue List<ParentsItem?>? = null
)






