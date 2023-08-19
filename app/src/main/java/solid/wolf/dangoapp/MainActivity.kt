package solid.wolf.dangoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import solid.wolf.dangoapp.navigation.Navigations

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.onStartingApplication()
        mainViewModel.onBootingUp()
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                mainViewModel.isBootingUp.value
            }
        }
        setContent {
            Navigations(mainViewModel.isLoading.value)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
