package com.miniclip.matchsimulator.ui.navigation

import androidx.navigation.NavHostController

interface NavigationDestination {
    val route: String
}

object MatchesScreen : NavigationDestination {
    override val route = "matches"
}

object TableScreen : NavigationDestination {
    override val route = "table"
}

object StatScreen : NavigationDestination {
    override val route = "stats"
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    launchSingleTop = true
    restoreState = true
    popUpTo(this@navigateSingleTopTo.graph.startDestinationId) {
        saveState = true
    }
}