package com.abdullah996.learning.ui.components.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdullah996.learning.R
import com.abdullah996.learning.ui.components.content.item.DetailsContentItem
import com.abdullah996.learning.ui.utils.stringResourceWithFallback
import com.abdullah996.learning.ui.utils.stringWithFallback

@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    totalCapacity: Int?,
    remainingCapacity: Int?,
    installedOnFormatted: String?
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
            label = stringResource(id = R.string.details_card_total_label)
        )
        Divider(
            Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        DetailsContentItem(
            itemModifier,
            value = stringResourceWithFallback( R.string.details_card_remaining_format,remainingCapacity),

            label = stringResource(id = R.string.details_card_remaining_label)
        )
        Divider(
            Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        DetailsContentItem(
            itemModifier,
            value = stringWithFallback(string =  installedOnFormatted),
            label = stringResource(id = R.string.details_card_installed_on_label)
        )
    }
}