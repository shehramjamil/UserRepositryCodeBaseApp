package aliabbas.com.scalablecodebaseapp.di.app_dependencies

import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryCommitsRemoteDataSource
import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryDataSource
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.data_source.RepositoryCommitsDataSource
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.data_source.RepositoriesDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created By Ali Abbas on on 21,December,2021
 * This Class is used for
 *
 */
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindRepositoryDataSource(dataSource: RepositoriesDataSource): RepositoryDataSource

    @Singleton
    @Binds
    abstract fun bindRepositoryCommitDataSource(repositoryCommitsDataSource: RepositoryCommitsDataSource): RepositoryCommitsRemoteDataSource

}