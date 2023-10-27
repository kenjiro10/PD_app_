package com.example.pd_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pd_app.ui.theme.PD_AppTheme

class Calorie : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PD_AppTheme {
                // A surface container using the 'background' color from the theme
                MainContent()
            }

        }
    }
}
@Composable
fun BarGraph(dataPoints: List<Float>) {
    // Calculate the maximum value for scaling
    val maxDataPoint = dataPoints.maxOrNull() ?: 1.0f

    // Create a LazyColumn for the bar graph
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(dataPoints) { dataPoint ->
            val heightPercent = dataPoint / maxDataPoint
            Bar(heightPercent)
        }
    }
}

@Composable
fun Bar(heightPercent: Float) {
    val barColor = Color.Blue
    val barWidth = 32.dp
    val maxBarHeight = 200.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxBarHeight)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(barColor)
                .graphicsLayer {
                    translationY = (1f - heightPercent) * maxBarHeight.toPx()
                }
        )
    }
}

@Composable
fun BarGraphApp() {
    val dataPoints = remember { mutableStateListOf(40f, 60f, 80f, 20f, 90f) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BarGraph(dataPoints)
        }
    }
}

@Preview
@Composable
fun PreviewBarGraph() {
    BarGraphApp()
}

@Composable
fun MainContent() {
    BarGraphApp()
}

