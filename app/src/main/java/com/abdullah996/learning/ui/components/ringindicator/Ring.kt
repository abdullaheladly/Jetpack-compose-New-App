package com.abdullah996.learning.ui.components.ringindicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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

@Composable
fun Ring(
    modifier: Modifier = Modifier,
    bgColor: Color,
    fgColor: Color,
    fill: Float
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
    val fgRingAngleEdge = remember(fill) {
        180f*fill
    }
    Canvas(
        modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(width = 1.dp, color = Color.Red)) {
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
            startAngle = 0.0f,
            endAngle = 360.0f,
            topLeft=topLeft,
            style = bgStroke,
            size = arcSize
        )
        //fgRing
        drawRing(
            color =fgColor ,
            startAngle = 180.0f-fgRingAngleEdge,
            endAngle = 180.0f+fgRingAngleEdge,
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