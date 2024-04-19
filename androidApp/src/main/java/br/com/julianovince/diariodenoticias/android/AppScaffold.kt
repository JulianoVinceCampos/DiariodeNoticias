package br.com.julianovince.diariodenoticias.android

import AboutScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.julianovince.diariodenoticias.android.screens.ArticleScreen
import br.com.julianovince.diariodenoticias.android.screens.Screens

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route){
            ArticleScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route)},
            )
        }
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen (
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}