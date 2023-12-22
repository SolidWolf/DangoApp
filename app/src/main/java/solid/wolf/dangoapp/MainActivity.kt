package solid.wolf.dangoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import solid.wolf.dangoapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.onBootingUp()
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                mainViewModel.isBootingUp.value
            }
        }
        setContent {
            AppTheme {
                /**
                 * using this video to make navigation easier
                 * https://www.youtube.com/watch?v=Q3iZyW2etm4&ab_channel=PhilippLackner
                 */
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

@Destination
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
