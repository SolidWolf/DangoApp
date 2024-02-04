package solid.wolf.dangoapp.presentation.splashscreen

import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import solid.wolf.dangoapp.MainViewModel
import solid.wolf.dangoapp.R
import solid.wolf.dangoapp.core.theme.Spacing
import solid.wolf.dangoapp.destinations.GreetingDestination
import solid.wolf.dangoapp.destinations.LoginScreenDestination
import solid.wolf.dangoapp.domain.utils.UIState
import solid.wolf.dangoapp.domain.utils.getActivity

@Destination(start = true)
@Composable
fun SplashScreen(
	navigator: DestinationsNavigator
) {
	val lifecycleOwner = LocalLifecycleOwner.current
	val lifecycleState by lifecycleOwner.lifecycle.currentStateFlow.collectAsState()
	val activity = LocalContext.current.getActivity()
	val mainViewModel = activity?.let {
		viewModel<MainViewModel>(viewModelStoreOwner = activity)
	}

	if (mainViewModel != null) {
		val getRefreshToken by rememberUpdatedState(mainViewModel::getRefreshToken)
		LaunchedEffect(true) {
			getRefreshToken()
		}
	}
	LaunchedEffect(lifecycleState) {
		// Do something with your state
		// You may want to use DisposableEffect or other alternatives
		// instead of LaunchedEffect
		when (lifecycleState) {
			Lifecycle.State.RESUMED -> {
				mainViewModel?.onStartingApplication()
			}
			else -> {}
		}
	}

	mainViewModel?.isLoading?.toString()?.let { Log.d("SplashScreen: ", it) }
	if (mainViewModel?.isLoading == false) {
		when (mainViewModel.loginState) {
			is UIState.None -> navigator.navigate(LoginScreenDestination())
			is UIState.Success -> { navigator.navigate(GreetingDestination()) }
			else -> {}
		}
	}
	val infiniteTransition = rememberInfiniteTransition(label = "")
	val angle by infiniteTransition.animateFloat(
		initialValue = 0F,
		targetValue = 360F,
		animationSpec = infiniteRepeatable(
			animation = tween(2000, easing = LinearEasing)
		),
		label = ""
	)

	Box(
		contentAlignment = Alignment.Center,
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.mainactivity_background))
	) {
		Image(
			painter = painterResource(id = R.drawable.chewie_logo),
			contentDescription = stringResource(id = R.string.cont_desc_chewie_logo),
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.size(Spacing.spacing128)
				.clip(RoundedCornerShape(Spacing.spacing64))
				.graphicsLayer {
					this.rotationZ = angle
				}
		)
	}
}
