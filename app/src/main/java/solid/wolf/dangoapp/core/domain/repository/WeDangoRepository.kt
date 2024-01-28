package solid.wolf.dangoapp.core.domain.repository

import solid.wolf.dangoapp.core.data.dto.RefreshTokenDto
import solid.wolf.dangoapp.core.domain.utils.ApiState

interface WeDangoRepository {
    suspend fun getRefreshToken(url: String?): ApiState<RefreshTokenDto>
}
