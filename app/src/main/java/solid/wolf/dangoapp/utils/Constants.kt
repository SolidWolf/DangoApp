package solid.wolf.dangoapp.utils

object Constants {
	const val ACCESS_TOKEN_URL = "https://id.twitch.tv/oauth2/authorize"
	const val REFRESH_TOKEN_URL = "https://id.twitch.tv/oauth2/token"
	const val RESPONSE_TYPE_QUERY = "?response_type="
	const val TOKEN = "token"
	const val CLIENT_ID_QUERY = "&client_id="
	const val REDIRECT_QUERY = "&redirect_uri="
	const val SCOPE_QUERY = "&scope="
	const val SCOPE_TYPE = "user:read:follows"
	const val STATE_QUERY = "&state="
}
