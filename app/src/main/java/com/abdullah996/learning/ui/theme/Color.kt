package com.abdullah996.learning.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val Colors.ColorRingBg:Color
    get() = if (isLight) Color.LightGray else Color.DarkGray



val Colors.ColorRingFg:Color
    get() = if (isLight) Color(0xFF00CEE6) else Color(0xFF005FF)