package solid.wolf.dangoapp.navigation.login

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import solid.wolf.dangoapp.BuildConfig
import solid.wolf.dangoapp.utils.Constants.ACCESS_TOKEN_URL
import solid.wolf.dangoapp.utils.Constants.CLIENT_ID_QUERY
import solid.wolf.dangoapp.utils.Constants.REDIRECT_QUERY
import solid.wolf.dangoapp.utils.Constants.RESPONSE_TYPE_QUERY
import solid.wolf.dangoapp.utils.Constants.SCOPE_QUERY
import solid.wolf.dangoapp.utils.Constants.SCOPE_TYPE
import solid.wolf.dangoapp.utils.Constants.STATE_QUERY
import solid.wolf.dangoapp.utils.Constants.TOKEN
import java.net.URLEncoder
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
	fun createTwitchIntent() = Intent(
		Intent.ACTION_VIEW,
		Uri.parse(
			getLoginUrl()
		)
	)

	private fun getLoginUrl(): String {
		val clientId = BuildConfig.CLIENT_ID
		val redirectUrl = BuildConfig.TWITCH_REDIRECT
		val state = UUID.randomUUID().toString().replace("-", "")
		val link = ACCESS_TOKEN_URL +
			"$RESPONSE_TYPE_QUERY$TOKEN" +
			"$CLIENT_ID_QUERY$clientId" +
			"$REDIRECT_QUERY$redirectUrl" +
			"${SCOPE_QUERY}${URLEncoder.encode(SCOPE_TYPE, "UTF-8")}" +
			"$STATE_QUERY$state"
		Log.d("getLoginUrl: ", link)
		return link
	}
}
