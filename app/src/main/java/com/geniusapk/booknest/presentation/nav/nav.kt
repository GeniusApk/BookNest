package com.geniusapk.booknest.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.geniusapk.booknest.presentation.BookByCategory.BooksByCategory
import com.geniusapk.booknest.presentation.pdfViewer.PdfViewerScreen
import com.geniusapk.booknest.presentation.MainUi.MainUi

@Composable
fun NavGraph( navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.Home) {
        composable<Routes.Home> {
            MainUi(

                navHostController = navHostController
            )
        }
        composable<Routes.pdf> {backStackEntry ->
            val Deta : Routes.pdf = backStackEntry.toRoute()
            PdfViewerScreen(url = Deta.ImageUrl )

        }
        composable<Routes.BooksByCategory> {backStackEntry ->
            val Deta2 : Routes.BooksByCategory = backStackEntry.toRoute()
            BooksByCategory(category = Deta2.category , navHostController = navHostController)
        }


    }

}
