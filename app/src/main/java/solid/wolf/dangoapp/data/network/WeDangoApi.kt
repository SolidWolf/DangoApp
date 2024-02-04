package solid.wolf.dangoapp.data.network

import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url
import solid.wolf.dangoapp.data.dto.RefreshTokenDto

interface WeDangoApi {
	@Headers()
	@POST
	suspend fun getRefreshToken(
		@Url url: String?
	): Response<RefreshTokenDto>
}
