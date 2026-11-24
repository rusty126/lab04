package com.example.navigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.navigation.navigation.NavGraph

/** Главная Activity и точка входа в приложение. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityLifecycle", "onCreate")
        setContent {
            MaterialTheme {
                Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavGraph()
                }
            }
        }
    }

    override fun onStart() { super.onStart(); Log.d("ActivityLifecycle", "onStart") }
    override fun onResume() { super.onResume(); Log.d("ActivityLifecycle", "onResume") }
    override fun onPause() { Log.d("ActivityLifecycle", "onPause"); super.onPause() }
    override fun onStop() { Log.d("ActivityLifecycle", "onStop"); super.onStop() }
    override fun onDestroy() { Log.d("ActivityLifecycle", "onDestroy"); super.onDestroy() }
}
