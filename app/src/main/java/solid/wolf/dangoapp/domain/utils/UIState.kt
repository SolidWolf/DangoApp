package solid.wolf.dangoapp.domain.utils

import javax.annotation.concurrent.Immutable

@Immutable
sealed class UIState<out T> {
	@Immutable
	data class Success<T>(val data: T) : UIState<T>()
	
	@Immutable
	object Error : UIState<Nothing>()
	
	@Immutable
	object Loading : UIState<Nothing>()
	
	@Immutable
	object None : UIState<Nothing>()
}
