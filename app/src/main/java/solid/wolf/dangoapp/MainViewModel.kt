package solid.wolf.dangoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import solid.wolf.dangoapp.domain.usecase.tokens.TokenUseCase
import solid.wolf.dangoapp.domain.utils.UIState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val tokenUseCase: TokenUseCase
) : ViewModel() {
	var isLoading by mutableStateOf(true)
		private set

	var isBootingUp by mutableStateOf(true)
		private set
	
	var loginState: UIState<String> by mutableStateOf(UIState.None)
		private set

	fun onBootingUp() {
		viewModelScope.launch {
			delay(1000)
			isBootingUp = false
		}
	}

	fun onStartingApplication() {
		viewModelScope.launch {
			delay(5000)
			isLoading = false
		}
	}
	
	fun getRefreshToken() {
	}
}
