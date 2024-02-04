package solid.wolf.dangoapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.utils.findDestination
import dagger.hilt.android.AndroidEntryPoint
import solid.wolf.dangoapp.core.theme.AppTheme

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AppTheme {
				/**
				 * using this video to make navigation easier
				 * https://www.youtube.com/watch?v=Q3iZyW2etm4&ab_channel=PhilippLackner
				 */
				/**
				 * using this video to make navigation easier
				 * https://www.youtube.com/watch?v=Q3iZyW2etm4&ab_channel=PhilippLackner
				 */
				/**
				 * using this video to make navigation easier
				 * https://www.youtube.com/watch?v=Q3iZyW2etm4&ab_channel=PhilippLackner
				 */
				
				/**
				 * using this video to make navigation easier
				 * https://www.youtube.com/watch?v=Q3iZyW2etm4&ab_channel=PhilippLackner
				 */
				NavGraphs.root.findDestination("greetings")?.let {
					DestinationsNavHost(
						navGraph = NavGraphs.root,
						startDestination = it
					)
				}
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
// 	route = "greetings"
// )
// @Composable
// fun Greeting() {
// 	Box(
// 		modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.tertiary)
// 	) {
// 		Text(
// 			text = "Hello World!"
// 		)
// 	}
// }
