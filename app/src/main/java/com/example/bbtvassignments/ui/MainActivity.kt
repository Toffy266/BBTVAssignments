package com.example.bbtvassignments.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bbtvassignments.ui.detail.DramaDetailScreen
import com.example.bbtvassignments.ui.drama.DramaScreen
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BBTVAssignmentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "drama_screen",
                    ) {
                        composable("drama_screen") {
                            DramaScreen(navController = navController)
                        }
                        composable(
                            "drama_detail_screen/{dramaId}",
                            arguments =
                                listOf(
                                    navArgument(
                                        "dramaId",
                                    ) {
                                        type = NavType.LongType
                                    },
                                ),
                        ) {
                            val dramaId =
                                remember {
                                    it.arguments?.getLong("dramaId")
                                }
                            DramaDetailScreen(
                                dramaId = dramaId,
                                navController = navController,
                            )
                        }
                    }
                }
            }
        }
    }
}
