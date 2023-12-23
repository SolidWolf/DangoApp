package solid.wolf.dangoapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var isLoading = mutableStateOf(true)
        private set

    var isBootingUp = mutableStateOf(true)
        private set

    fun onBootingUp() {
        viewModelScope.launch {
            delay(1000)
            isBootingUp.value = false
        }
    }

    fun onStartingApplication() {
        viewModelScope.launch {
            delay(5000)
            isLoading.value = false
        }
    }

}