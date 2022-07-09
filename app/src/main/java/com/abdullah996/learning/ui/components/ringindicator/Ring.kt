package com.abdullah996.learning.ui.components.ringindicator

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max


private val backgroundStrokeWidthDp:Dp=8.dp
private val foregroundStrokeWidthDp:Dp=12.dp


private enum class TransitionState{INIT_START,INIT_END,FILLED}

@Composable
fun Ring(
    modifier: Modifier = Modifier,
    bgColor: Color,
    fgColor: Color,
    fill: Float,
    fgFillCb:((Float)->Unit)?=null
){

    var bgStroke:Stroke
    var fgStroke:Stroke
    with(LocalDensity.current){
        bgStroke = remember {
            Stroke(width = backgroundStrokeWidthDp.toPx())
        }
        fgStroke = remember {
            Stroke(width = foregroundStrokeWidthDp.toPx(),cap = StrokeCap.Round)
        }
    }

    val maxStroke= remember {
        max(bgStroke.width,fgStroke.width)
    }


    val transitionState= remember {
        MutableTransitionState(TransitionState.INIT_START)
    }
    val transition= updateTransition(transitionState = transitionState, label = "ring_anim_transition")

    val bgRingAngle by transition.animateFloat(
        transitionSpec = {
            tween(
                durationMillis = 400,
                delayMillis = 400
            )
        },label = "bgRingAngleEdge"
    ){ currentState->
        if (currentState==TransitionState.INIT_START) 0f else 180f
    }
    val fgRingAngle by transition.animateFloat(
        transitionSpec = {
            tween(
                durationMillis = 400,

            )
        },label = "fgRingAngleEdge"
    ){ currentState->
        if (currentState==TransitionState.FILLED) 180f * fill else 0f
    }
    val fgFill by transition.animateFloat(
        transitionSpec = {
            tween(
                durationMillis = 400,

                )
        },label = "fgFill"
    ){ currentState->
        if (currentState==TransitionState.FILLED)  fill else 0f
    }
    LaunchedEffect(key1 = fgFill){
        fgFillCb?.invoke(fgFill)
    }
    LaunchedEffect(transitionState.currentState) {
        transitionState.targetState=when(transitionState.currentState){
            TransitionState.INIT_START->TransitionState.INIT_END
            else->TransitionState.FILLED
        }
    }

    Canvas(modifier) {
        val innerRadius=(size.minDimension-maxStroke)/2
        val halfSize=size/2f
        val topLeft= Offset(
            x=halfSize.width-innerRadius,
            y = halfSize.height-innerRadius
        )
        val arcSize= Size(width = innerRadius*2,height = innerRadius*2)
//        drawArc(
//            color = bgColor,
//            startAngle = 0.0f,
//            sweepAngle = 360.0f,
//            useCenter = false,
//            style = bgStroke,
//            topLeft=topLeft,
//            size = arcSize
//        )

        //bgRing
        drawRing(
            color = bgColor,
            startAngle = -bgRingAngle,
            endAngle = bgRingAngle,
            topLeft=topLeft,
            style = bgStroke,
            size = arcSize
        )
        //fgRing
        drawRing(
            color =fgColor ,
            startAngle = 180.0f-fgRingAngle,
            endAngle = 180.0f+fgRingAngle,
            topLeft=topLeft,
            style = fgStroke,
            size = arcSize
        )
    }
}



private fun DrawScope.drawRing(
    color: Color,
    startAngle:Float,
    endAngle:Float,
    topLeft:Offset,
    size: Size,
    style: DrawStyle
){
    drawArc(
        color = color,
        startAngle = startAngle-90f,
        sweepAngle = endAngle-startAngle,
        useCenter = false,
        topLeft=topLeft,
        size = size,
        style = style
        )
}