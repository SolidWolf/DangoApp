package solid.wolf.dangoapp.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import solid.wolf.dangoapp.Greeting
import solid.wolf.dangoapp.splashscreen.SplashScreen
import solid.wolf.dangoapp.ui.theme.MainScreen

/**
 * Used https://youtu.be/4gUeyNkGE3g as a reference for this implementation
 */
@Composable
fun Navigations(isLoading: Boolean) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ){
        composable(
            route = Screens.SplashScreen.route
        ){
            if(!isLoading){
                navController.navigate(Screens.HomeScreen.route)
            }
            AnimatedVisibility(
                visible = isLoading,
                exit = fadeOut(),
                enter = fadeIn()
            ) {
                SplashScreen()
            }
        }
        composable(
            route = Screens.HomeScreen.route
        ){
            MainScreen(navController = navController) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}