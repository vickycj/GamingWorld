package com.example.gamingworld

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gamingworld.normal.NormalUserActivity
import com.example.gamingworld.premium.PremiumUserActivity
import com.example.gamingworld.ui.theme.GamingWorldTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamingWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WelcomeUser(
                        name = "User",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun launchPage(isPremiumUser: Boolean) {
        if(isPremiumUser) {
            launchPremiumUserPage()
        } else {
            launchNormalUserPage()
        }
    }

    private fun launchPremiumUserPage() {
        startActivity(Intent(this, PremiumUserActivity::class.java))
    }

    private fun launchNormalUserPage() {
        startActivity(Intent(this, NormalUserActivity::class.java))
    }

    @Composable
    fun WelcomeUser(name: String, modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Button(onClick = {
                // For now randomising, consider this being fetched from the API server
                launchPage(Random.nextBoolean())
            }) {
                Text(text = "Launch")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        GamingWorldTheme {
            WelcomeUser("Android")
        }
    }

}






