package com.abdullah996.learning.ui.screen.main

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdullah996.learning.ui.components.capacityinputdialog.CapacityInputDialog
import com.abdullah996.learning.ui.components.detailscard.DetailsCard
import com.abdullah996.learning.ui.components.ringindicator.RingIndicator
import com.abdullah996.learning.ui.theme.LearningTheme


@ExperimentalAnimationApi
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
            Column(modifier = Modifier.padding(16.dp)) {


                RingIndicator(
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp), fill = viewModel.waterFill, daysInUse = viewModel.daysInUse
                )
                DetailsCard(
                    modifier = Modifier.padding(top = 96.dp),
                    editMode = viewModel.editMode,
                    totalCapacity =viewModel.totalCapacity,
                    remainingCapacity = viewModel.remainingCapacity,
                    installedOnFormatted = viewModel.installedOnFormatted,
                    onEdit = viewModel::onEdit,
                    onCancel = viewModel::onCancel,
                    onClearData = viewModel::onClearData,
                    onSave = viewModel::onSave,
                    onInstalledOnClick = viewModel::onInstalledOnClicked,
                    onTotalCapacityClick = viewModel::onTotalCapacityClicked,
                    onRemainingCapacityClick = viewModel::onRemainingCapacityClicked

                )
            }

                CapacityInputDialog(config = viewModel.capacityInputDialogConfig)

            
        }
    }
}

private fun log(string: String){
    Log.d("MainScreen",string)
}