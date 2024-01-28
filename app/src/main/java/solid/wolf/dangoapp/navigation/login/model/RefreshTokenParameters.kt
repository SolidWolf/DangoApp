package solid.wolf.dangoapp.navigation.login.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RefreshTokenParameters (
	val clientId: String = "",
	val clientSecret: String? = null,
	val code: String
	
): Parcelable
