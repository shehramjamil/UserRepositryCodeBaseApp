package aliabbas.com.scalablecodebaseapp.domain_user_home.domain.usecase

class FetchUserHomeUseCaseImpl : FetchUserHomeUseCase {
    override suspend fun execute(): Any {
        TODO("Not yet implemented")
    }

    // here call the specific repo and inject this use-case then into viewModel
    // use case can also talk to multiple repos
    // Sometime, for achieving one behaviour a use-case needs data from two different repos
}