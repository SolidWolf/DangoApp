package solid.wolf.dangoapp.domain.model.tokens

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RefreshTokenParameters(
	val clientId: String = "",
	val clientSecret: String? = null,
	val code: String
	
) : Parcelable
