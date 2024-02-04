package solid.wolf.dangoapp.data.repository

import solid.wolf.dangoapp.data.dto.RefreshTokenDto
import solid.wolf.dangoapp.data.network.WeDangoApi
import solid.wolf.dangoapp.domain.model.tokens.RefreshTokenParameters
import solid.wolf.dangoapp.domain.repository.WeDangoRepository
import solid.wolf.dangoapp.domain.utils.ApiState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeDangoRepositoryImpl @Inject constructor(
	private val weDangoApi: WeDangoApi
) : WeDangoRepository {
	override suspend fun getRefreshToken(
		url: String?,
		refreshTokenParameters: RefreshTokenParameters
	): ApiState<RefreshTokenDto> {
		TODO("Not yet implemented")
	}
}
