package solid.wolf.dangoapp.data.di

import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import solid.wolf.dangoapp.data.network.WeDangoApi
import solid.wolf.dangoapp.data.repository.WeDangoRepositoryImpl
import solid.wolf.dangoapp.domain.repository.WeDangoRepository
import solid.wolf.dangoapp.domain.usecase.tokens.GetRefreshTokenUseCase
import solid.wolf.dangoapp.domain.usecase.tokens.TokenUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

// 	@Singleton
// 	@Provides
// 	fun provideRetrofit(): Retrofit {
// 		return Retrofit.Builder()
// 			.addConverterFactory(GsonConverterFactory.create())
// 			.build()
// 	}
	
	@Singleton
	@Provides
	fun provideWeDangoApi(
		retrofitFactory: RetrofitFactory
	): WeDangoApi = retrofitFactory.create(
		"https://www.google.com"
	).build()
	
	@Singleton
	@Provides
	fun provideWeDangoRepository(
		weDangoApi: WeDangoApi
	): WeDangoRepository = WeDangoRepositoryImpl(weDangoApi)
	
	@Singleton
	@Provides
	fun provideRefreshTokenUseCase(
		repository: WeDangoRepository
	): TokenUseCase {
		return TokenUseCase(
			getRefreshTokenUseCase = GetRefreshTokenUseCase(
				repository = repository
			)
		)
	}
}

@AssistedFactory
interface RetrofitFactory {
	fun create(baseUrl: String): RetrofitBuilder
}

class RetrofitBuilder @AssistedInject constructor(
	@Assisted val baseUrl: String
) {
	inline fun <reified T> build(): T {
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create()
	}
}
