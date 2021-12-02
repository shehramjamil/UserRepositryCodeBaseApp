package aliabbas.com.scalablecodebaseapp.di.app_dependencies

import aliabbas.com.scalablecodebaseapp.app_service_calls.Api
import aliabbas.com.scalablecodebaseapp.commons.Constants
import aliabbas.com.scalablecodebaseapp.commons.Constants.formatDDMMYYYYTHHMMSSZ
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.repository.UserRepositoriesRepository
import aliabbas.com.scalablecodebaseapp.ui.fragments.user_home_fragment.view_model_factory.UserRepositoryViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created By Ali Abbas
 * This Class is used for
 */
@Module
class ApiServiceModule {
    @get:Provides
    @Singleton
    val requestHeader: OkHttpClient
        get() {
            val applicationJsonCharsetUtf8 = "application/json; charset=utf-8"
            val httpClient = OkHttpClient.Builder()
            httpClient.retryOnConnectionFailure(true)
            httpClient.addInterceptor { chain ->
                val response = chain.proceed(chain.request())
                response.header("Content-ReportCopy", applicationJsonCharsetUtf8)
                response.header("Accept", applicationJsonCharsetUtf8)
                response.header("Connection", "close")
                response
            }.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
            return httpClient.build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Api {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setDateFormat(formatDDMMYYYYTHHMMSSZ)
                        .create()
                )
            )
            .client(client)
            .build().create(Api::class.java)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(
        userRepositoriesRepository: UserRepositoriesRepository?
    ): ViewModelProvider.Factory {
        return UserRepositoryViewModelFactory(userRepositoriesRepository)
    }
}