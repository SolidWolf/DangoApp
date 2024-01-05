package solid.wolf.dangoapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import solid.wolf.dangoapp.ui.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val mainViewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mainViewModel.onBootingUp()
		installSplashScreen().apply {
			setKeepOnScreenCondition {
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

	override fun onResume() {
		super.onResume()
		val uri: Uri? = intent.data
		Log.d("getLoginUrl: ", uri.toString())
	}
}

// @Destination(
//    route = "greetings",
//    deepLinks = [
//        DeepLink(
//            uriPattern = "https://solid.wolf.dangoapp/#access_token={token}&scope={scope}&state={state}&token_type=bearer"
//        )
//    ]
// )
// @Composable
// fun Greeting() {
//    Text(
//        text = "Hello World!",
//    )
// }
