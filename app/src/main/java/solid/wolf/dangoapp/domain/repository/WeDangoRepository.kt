package solid.wolf.dangoapp.domain.repository

import solid.wolf.dangoapp.data.dto.RefreshTokenDto
import solid.wolf.dangoapp.domain.model.tokens.RefreshTokenParameters
import solid.wolf.dangoapp.domain.utils.ApiState

interface WeDangoRepository {
	suspend fun getRefreshToken(url: String?, refreshTokenParameters: RefreshTokenParameters): ApiState<RefreshTokenDto>
}
