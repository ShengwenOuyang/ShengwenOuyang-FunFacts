package com.example.shengwenouyang_funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shengwenouyang_funfacts.ui.theme.ShengwenOuyangFunFactsTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShengwenOuyangFunFactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FunFactApp(modifier: Modifier = Modifier) {
    // List of fun facts
    val funFacts = listOf(
        "Did you know? Corgis were originally bred to herd cattle!",
        "Fun fact: Octopuses have three hearts and blue blood!",
        "Trivia: Honey never spoils. Archaeologists have found pots of honey in ancient tombs!",
        "Did you know? Bananas are berries, but strawberries aren't!",
        "Fun fact: A group of flamingos is called a 'flamboyance'.",
        "Trivia: The Eiffel Tower can grow up to 6 inches taller in summer due to heat expansion!"
    )


    var currentFactIndex by remember { mutableStateOf(Random.nextInt(funFacts.size)) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display current fact with fun styling
        Text(
            text = funFacts[currentFactIndex],
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EA),
            modifier = Modifier
                .padding(16.dp)
                .background(Color(0xFFEDE7F6), shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Next Fact button
        Button(
            onClick = {
                currentFactIndex = (currentFactIndex + 1) % funFacts.size
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Next Fact!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactAppPreview() {
    ShengwenOuyangFunFactsTheme {
        FunFactApp()
    }
}
