package com.abdullah996.learning.ui.screen.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var counter :Int  by mutableStateOf(0)
        private set


    fun increment(){
        counter++
    }
}