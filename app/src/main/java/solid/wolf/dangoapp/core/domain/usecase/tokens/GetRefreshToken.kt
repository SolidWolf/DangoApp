package solid.wolf.dangoapp.core.domain.usecase.tokens

import solid.wolf.dangoapp.core.data.dto.RefreshTokenDto
import solid.wolf.dangoapp.core.domain.repository.WeDangoRepository
import solid.wolf.dangoapp.navigation.login.model.RefreshTokenParameters
import solid.wolf.dangoapp.utils.UIState
import javax.inject.Inject

class GetRefreshToken @Inject constructor(
	val repository: WeDangoRepository
) {
	suspend operator fun invoke(
		url: String?,
		refreshTokenParameters: RefreshTokenParameters
	): UIState<RefreshTokenDto> {
		return when(
			val apiResponse = repository.getRefreshToken(
				url = url,
				refreshTokenParameters = refreshTokenParameters
			)
		)
	}
}
