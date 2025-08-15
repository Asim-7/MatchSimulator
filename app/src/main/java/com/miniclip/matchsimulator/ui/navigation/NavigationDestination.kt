package com.miniclip.matchsimulator.ui.navigation

import androidx.navigation.NavHostController

interface NavigationDestination {
    val route: String
}

object MatchesScreen : NavigationDestination {
    override val route = MATCH_ROUTE_ID
}

object TableScreen : NavigationDestination {
    override val route = TABLE_ROUTE_ID
}

object StatScreen : NavigationDestination {
    override val route = STATS_ROUTE_ID
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    launchSingleTop = true
    restoreState = true
    popUpTo(this@navigateSingleTopTo.graph.startDestinationId) {
        saveState = true
    }
}

const val MATCH_ROUTE_ID = "matches"
const val TABLE_ROUTE_ID = "table"
const val STATS_ROUTE_ID = "stats"