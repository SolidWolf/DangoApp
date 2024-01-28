package solid.wolf.dangoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import solid.wolf.dangoapp.core.domain.repository.WeDangoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Singleton
	@Provides
	fun provideRetrofit(baseUrl: String): Retrofit {
		return Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(baseUrl)
			.build()
	}

    @Singleton
    @Provides
    fun provideRefreshTokenUseCase(
		 repository: WeDangoRepository,
		 retrofit: Retrofit
    ): TokenUseCases{
        return TokenUseCases(
            getRefreshTokenUseCase = GetRefreshTokenUseCase(repository = repository, retrofit = retrofit)
        )
    }
}
