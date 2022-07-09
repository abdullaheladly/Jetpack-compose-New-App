package com.abdullah996.learning.ui.components.detailscard

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdullah996.learning.R
import com.abdullah996.learning.ui.components.content.item.DetailsContentItem

@Composable
fun DetailsCard(
    modifier: Modifier =Modifier,
    editState:Boolean
) {
    Card(modifier = modifier) {
        Column() {
            //details content
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Min)
            ) {
                val itemModifier = Modifier.weight(1f)
                DetailsContentItem(
                    itemModifier,
                    value = "350 L",
                    label = stringResource(id = R.string.details_card_total_label)
                )
                Divider(
                    Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                DetailsContentItem(
                    itemModifier,
                    value = "250 L",
                    label = stringResource(id = R.string.details_card_remaining_label)
                )
                Divider(
                    Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )

                DetailsContentItem(
                    itemModifier,
                    value = "Feb 8",
                    label = stringResource(id = R.string.details_card_installed_on_label)
                )
            }
            //details action

            if (!editState) {
                Box(Modifier.fillMaxWidth()) {
                    TextButton(
                        modifier = Modifier.align(Alignment.Center),
                        onClick = { Log.d("DetailsCard", "on click Edit") },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colors.onSurface
                        )
                    ) {
                        Text(text = (stringResource(id = R.string.details_card_edit).uppercase()))
                    }
                }
            }else {
                Row {
                    TextButton(

                        onClick = { },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colors.onSurface
                        )
                    ) {
                        Text(text = (stringResource(id = R.string.details_card_clear_data).uppercase()))
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        onClick = { },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colors.onSurface
                        )
                    ) {
                        Text(text = (stringResource(id = R.string.details_card_cancel).uppercase()))
                    }



                    TextButton(
                        onClick = { },
                    ) {
                        Text(text = (stringResource(id = R.string.details_card_save).uppercase()))
                    }


                }

            }
        }
    }
}


