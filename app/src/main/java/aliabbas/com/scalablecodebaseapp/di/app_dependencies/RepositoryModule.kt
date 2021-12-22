package aliabbas.com.scalablecodebaseapp.di.app_dependencies

import aliabbas.com.scalablecodebaseapp.data.repository.CommitRepositoryRepository
import aliabbas.com.scalablecodebaseapp.domain_user_home.domain.repository.UserRepository
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.repository.RepositoryCommitDetails
import aliabbas.com.scalablecodebaseapp.domain_user_home.data.UserRepositoriesRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created By Ali Abbas
 * This Class is used for
 *
 */
@Module
abstract class RepositoryModule {
    /*@Provides
    @Singleton
    fun getUserRepository(apiCallInterface: Api?): UserRepositories {
        return UserRepositories(apiCallInterface!!)
    }

    @Provides
    @Singleton
    fun getRepositoryCommits(apiCallInterface: Api?): RepositoryCommitsRepository {
        return RepositoryCommitsRepository(apiCallInterface!!)
    }*/
    @Singleton
    @Binds
    abstract fun bindRepository(repositoryImpl: UserRepositoriesRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun bindRepositoryCommits(repositoryCommitDetails: RepositoryCommitDetails): CommitRepositoryRepository
}