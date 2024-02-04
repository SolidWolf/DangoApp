package solid.wolf.dangoapp.domain.usecase.tokens

import solid.wolf.dangoapp.data.dto.RefreshTokenDto
import solid.wolf.dangoapp.domain.model.tokens.RefreshTokenParameters
import solid.wolf.dangoapp.domain.repository.WeDangoRepository
import solid.wolf.dangoapp.domain.utils.ApiState
import solid.wolf.dangoapp.domain.utils.UIState
import javax.inject.Inject

class GetRefreshTokenUseCase @Inject constructor(
	private val repository: WeDangoRepository
) {
	suspend operator fun invoke(
		url: String?,
		refreshTokenParameters: RefreshTokenParameters
	): UIState<RefreshTokenDto> {
		val apiResponse = repository.getRefreshToken(
			url = url,
			refreshTokenParameters = refreshTokenParameters
		)
		when (apiResponse) {
			is ApiState.Error -> TODO()
			ApiState.Loading -> TODO()
			is ApiState.Success -> TODO()
		}
	}
}
