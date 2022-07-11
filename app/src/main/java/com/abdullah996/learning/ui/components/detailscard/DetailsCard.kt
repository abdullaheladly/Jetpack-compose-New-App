package com.abdullah996.learning.ui.components.detailscard

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdullah996.learning.R
import com.abdullah996.learning.ui.components.detailscard.content.DetailsContent


@ExperimentalAnimationApi
@Composable
fun DetailsCard(
    modifier: Modifier =Modifier,
    editMode:Boolean,

    //total capacity
    totalCapacity:Int?,
    onTotalCapacityClick:()->Unit,
    //remaining
    remainingCapacity:Int?,
    onRemainingCapacityClick:()->Unit,
    //installedOn
    installedOnFormatted:String?,
    onInstalledOnClick:()->Unit,
    // callbacks
    onEdit:()->Unit,
    onClearData:()->Unit,
    onCancel:()->Unit,
    onSave:()->Unit
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            //details content
            DetailsContent(
                totalCapacity = totalCapacity,
                remainingCapacity = remainingCapacity,
                installedOnFormatted = installedOnFormatted,
                onTotalCapacityClick = onTotalCapacityClick,
                onRemainingCapacityClick = onRemainingCapacityClick,
                onInstalledOnClick = onInstalledOnClick,
                editMode = editMode
            )
            //details action
            DetailsActions(
                modifier = Modifier.padding(top = 8.dp),
                editMode = editMode,
                onEdit = onEdit,
                onCancel = onCancel,
                onClearData = onClearData,
                onSave = onSave
            )
           
        }
    }
}


@ExperimentalAnimationApi
@Composable
private fun DetailsActions(
    modifier: Modifier = Modifier,
    editMode: Boolean,
    //callbacks
    onEdit: () -> Unit,
    onClearData: () -> Unit,
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    Box(modifier = modifier) {


        AnimatedVisibility(
            visible = !editMode,
            enter = slideInHorizontally(initialOffsetX = {fullWidth ->  
                fullWidth
            }),
            exit = slideOutHorizontally(targetOffsetX = {fullWidth ->
                fullWidth
            })
        ) {
            DetailsPermanentActions(onEdit = onEdit)

        }

        AnimatedVisibility(
            visible = editMode,
            enter = slideInHorizontally(initialOffsetX = {fullWidth ->
                -fullWidth
            }),
            exit = slideOutHorizontally(targetOffsetX = {fullWidth ->
                -fullWidth
            })
        ) {
            DetailsEditModeActions(onCancel = onCancel,onClearData = onClearData,onSave = onSave)

        }
    }


   /* if (!editMode) {
        DetailsPermanentActions(modifier = modifier)
    }else {
        DetailsEditModeActions(modifier = modifier)
    }*/
}

@Composable
private fun DetailsPermanentActions(
    modifier: Modifier = Modifier,
    onEdit: () -> Unit,
) {
    Box(modifier.fillMaxWidth()) {
        TextButton(
            modifier = Modifier.align(Alignment.Center),
            onClick = onEdit,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.onSurface
            )
        ) {
            Text(text = (stringResource(id = R.string.details_card_edit).uppercase()))
        }
    }
}


@Composable
private fun DetailsEditModeActions(
    modifier: Modifier = Modifier,
    onClearData: () -> Unit,
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    Row(modifier = modifier) {
        TextButton(

            onClick = onClearData,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.onSurface
            )
        ) {
            Text(text = (stringResource(id = R.string.details_card_clear_data).uppercase()))
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = onCancel,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.onSurface
            )
        ) {
            Text(text = (stringResource(id = R.string.details_card_cancel).uppercase()))
        }



        TextButton(
            onClick = onSave,
        ) {
            Text(text = (stringResource(id = R.string.details_card_save).uppercase()))
        }


    }
}


