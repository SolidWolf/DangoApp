package solid.wolf.dangoapp.navigation

sealed class Screens(val route: String) {
	object SplashScreen : Screens(route = "splash_screen")
	object LoginScreen : Screens(route = "login_screen")
	object HomeScreen : Screens(route = "home_screen")
	object SongQueueScreen : Screens(route = "song_queue_screen")
	object SongListScreen : Screens(route = "song_list_screen")
	object LeaderBoardScreen : Screens(route = "leaderboard_screen")
	object MyCardsScreen : Screens(route = "my_cards_screen")
	object MyAchievementsScreen : Screens(route = "my_achievements_screen")
	object CommandsScreen : Screens(route = "commands_screen")
}
