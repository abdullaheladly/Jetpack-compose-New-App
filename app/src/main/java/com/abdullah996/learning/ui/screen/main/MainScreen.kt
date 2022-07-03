package com.abdullah996.learning.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.abdullah996.learning.ui.components.ringindicator.Ring
import com.abdullah996.learning.ui.theme.ColorRingBg
import com.abdullah996.learning.ui.theme.ColorRingFg
import com.abdullah996.learning.ui.theme.LearningTheme

@Composable
fun MainScreen(viewModel: MainViewModel){

    LearningTheme {
        // A surface container using the 'background' color from the theme

        Surface(
            color = MaterialTheme.colors.background
        ) {
//            Column {
//
//                Text(text = "Current Count : ${viewModel.counter}")
//                Button(onClick = viewModel::increment) {
//                        Text(text = "Increment")
//                }
//
//            }
            Ring(bgColor = MaterialTheme.colors.ColorRingBg, fgColor = MaterialTheme.colors.ColorRingFg,fill = 0.3f)
        }
    }
}