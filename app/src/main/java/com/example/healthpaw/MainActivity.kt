package com.example.healthpaw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.healthpaw.firebase.FirebaseInstance
import com.example.healthpaw.ui.theme.HealthPawTheme

class MainActivity : ComponentActivity() {
    private lateinit var firebaseInstance: FirebaseInstance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            firebaseInstance = FirebaseInstance(this)

            HealthPawTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Button(
                        modifier = Modifier.padding(innerPadding),
                        onClick = { firebaseInstance.writeOnFirebase() }
                    ) {
                        Text(text = "PRUEBA")
                    }
                }
            }
        }
    }
}
