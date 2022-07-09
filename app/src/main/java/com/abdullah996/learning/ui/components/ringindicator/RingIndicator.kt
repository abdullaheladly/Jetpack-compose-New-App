package com.abdullah996.learning.ui.components.ringindicator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.abdullah996.learning.R
import com.abdullah996.learning.ui.theme.ColorRingBg
import com.abdullah996.learning.ui.theme.ColorRingFg
import com.abdullah996.learning.ui.utils.quantityStringResource
import com.abdullah996.learning.ui.utils.quantityStringResourceWithFallback
import kotlin.math.roundToInt


@Composable
fun RingIndicator(modifier: Modifier =Modifier,fill:Float,daysInUse:Int?) {

    var percentage by remember {
        mutableStateOf(0)
    }
   ConstraintLayout(modifier = modifier) {
       val (percentRef,daysInUseRef,labelRef)=createRefs()

       Ring(
           modifier = Modifier.fillMaxSize(),
           bgColor = MaterialTheme.colors.ColorRingBg,
           fgColor = MaterialTheme.colors.ColorRingFg,
           fill = fill
       ){
           percentage= (it*100).roundToInt()
       }
        Text(
            modifier = Modifier.constrainAs(percentRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(id = R.string.ring_indicator_remaining_capacity_percent, percentage),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )
       Text(modifier=Modifier.constrainAs(daysInUseRef) {
           bottom.linkTo(percentRef.top)
           start.linkTo(parent.start)
           end.linkTo(parent.end)
       },
           text = quantityStringResourceWithFallback(
           R.plurals.ring_indicator_days_in_use_format,
           daysInUse
       ).uppercase(),
       style = MaterialTheme.typography.subtitle1)
       Text(
           modifier = Modifier.constrainAs(labelRef) {
               top.linkTo(percentRef.bottom)
               start.linkTo(parent.start)
               end.linkTo(parent.end)

           },
           text = stringResource(id = R.string.ring_indicator_remaining_capacity_label).uppercase(),
           style = MaterialTheme.typography.overline,
           fontSize = 12.sp
       )
   }
}