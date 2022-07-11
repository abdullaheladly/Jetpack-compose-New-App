package com.abdullah996.learning.ui.components.detailscard.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdullah996.learning.R
import com.abdullah996.learning.ui.components.detailscard.content.item.DetailsContentItem
import com.abdullah996.learning.ui.utils.stringResourceWithFallback
import com.abdullah996.learning.ui.utils.stringWithFallback

@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
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
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        val itemModifier = Modifier.weight(1f)
        DetailsContentItem(
            itemModifier,
            value = stringResourceWithFallback( R.string.details_card_total_format,totalCapacity),
            label = stringResource(id = R.string.details_card_total_label),
            onClick = onTotalCapacityClick,
            editMode = editMode
        )
        Divider(
            Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        DetailsContentItem(
            itemModifier,
            value = stringResourceWithFallback( R.string.details_card_remaining_format,remainingCapacity),
            label = stringResource(id = R.string.details_card_remaining_label),
            onClick = onRemainingCapacityClick,
            editMode = editMode
        )
        Divider(
            Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        DetailsContentItem(
            itemModifier,
            value = stringWithFallback(string =  installedOnFormatted),
            label = stringResource(id = R.string.details_card_installed_on_label),
            onClick = onInstalledOnClick,
            editMode = editMode
        )
    }
}