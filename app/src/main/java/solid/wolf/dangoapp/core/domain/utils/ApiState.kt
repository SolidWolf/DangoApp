package solid.wolf.dangoapp.core.domain.utils

import javax.annotation.concurrent.Immutable

@Immutable
sealed class ApiState<T> {
	@Immutable
	data class Success<T>(val data: T) : ApiState<T>()

	@Immutable
	data class Error(
		val throwable: Throwable? = null,
		val httpResponse: Int? = null
	) : ApiState<Nothing>()

	@Immutable
	data object Loading : ApiState<Nothing>()
}