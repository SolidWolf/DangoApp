package solid.wolf.dangoapp.core.data.repository

import solid.wolf.dangoapp.core.data.network.WeDangoApi
import solid.wolf.dangoapp.core.domain.repository.WeDangoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeDangoRepositoryImpl @Inject constructor(
	private val weDangoApi: WeDangoApi
) : WeDangoRepository {
//    override suspend fun getRefreshToken(url: String?): ApiState<SomeModel> {
//        TODO("Not yet implemented")
//    }
}
