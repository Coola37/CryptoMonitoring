package com.example.cryptomonitoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptomonitoring.ui.theme.CryptoMonitoringTheme
import com.example.cryptomonitoring.view.CryptoDetailScreen
import com.example.cryptomonitoring.view.CryptoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMonitoringTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "crypto_list_screen"){
                    composable("crypto_list_screen"){
                        CryptoListScreen(navController = navController)
                    }

                    composable("crypto_detail_screen/{cyrptoId}/{cryptoPrice}", arguments = listOf(
                        navArgument("cryptoId") {
                            type = NavType.StringType
                        },
                        navArgument("cryptoPrice"){
                            type = NavType.StringType
                        }

                    )){
                        val crytoId = remember {
                            it.arguments?.getString("cryptoId")
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString("cryptoPrice")
                        }
                        
                        CryptoDetailScreen(
                            id = crytoId ?: "",
                            price = cryptoPrice ?: "" ,
                            navController = navController )
                    }
                }
            }
        }
    }
}

