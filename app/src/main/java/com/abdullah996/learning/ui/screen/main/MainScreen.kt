package com.abdullah996.learning.ui.screen.main

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abdullah996.learning.ui.components.detailscard.DetailsCard
import com.abdullah996.learning.ui.components.ringindicator.Ring
import com.abdullah996.learning.ui.components.ringindicator.RingIndicator
import com.abdullah996.learning.ui.theme.ColorRingBg
import com.abdullah996.learning.ui.theme.ColorRingFg
import com.abdullah996.learning.ui.theme.LearningTheme
import com.abdullah996.learning.ui.utils.debugBorder

@Composable
fun MainScreen(viewModel: MainViewModel){

    LearningTheme {
        // A surface container using the 'background' color from the theme

        Surface(
            modifier=Modifier.fillMaxHeight(),
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
            Column {


                RingIndicator(
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp), fill = 1f, daysInUse = 7
                )
                DetailsCard(modifier = Modifier.padding(top = 96.dp),editState = true)
            }
            
        }
    }
}