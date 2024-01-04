package solid.wolf.dangoapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.utils.findDestination
import solid.wolf.dangoapp.ui.theme.AppTheme

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

@Destination(
    route = "greetings"
)
@Composable
fun Greeting() {
    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.tertiary)
    ){
        Text(
            text = "Hello World!",
        )
    }
}