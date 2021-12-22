package aliabbas.com.scalablecodebaseapp.di.app_dependencies

import aliabbas.com.scalablecodebaseapp.data.remote.RepositoryCommitsRemoteDataSource
import aliabbas.com.scalablecodebaseapp.domain_user_home.data.datasources.remote.RepositoryRemoteDataSource
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_detail_fragment.data_source.RepositoryCommitsRemoteDataSourceImpl
import aliabbas.com.scalablecodebaseapp.domain_user_home.userhome.datasource.RepositoriesRemoteDataSourceImpl
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
    abstract fun bindRepositoryDataSource(dataSourceImpl: RepositoriesRemoteDataSourceImpl): RepositoryRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindRepositoryCommitDataSource(repositoryCommitsRemoteDataSourceImpl: RepositoryCommitsRemoteDataSourceImpl): RepositoryCommitsRemoteDataSource

}