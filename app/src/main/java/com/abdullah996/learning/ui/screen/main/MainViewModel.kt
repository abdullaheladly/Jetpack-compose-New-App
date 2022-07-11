package com.abdullah996.learning.ui.screen.main

import androidx.compose.runtime.*
import com.abdullah996.learning.R
import androidx.lifecycle.ViewModel
import com.abdullah996.learning.common.data.DateHelper
import com.abdullah996.learning.ui.components.capacityinputdialog.CapacityInputDialogConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    val dateHelper: DateHelper
) :ViewModel() {
   //Global state
    var editMode by mutableStateOf(false)
    var totalCapacity:Int? by mutableStateOf(null)
    var remainingCapacity:Int? by mutableStateOf(null)
    var installedOn:Long? by mutableStateOf(null)


    //dialog

    var capacityInputDialogConfig:CapacityInputDialogConfig? by mutableStateOf(null)


    //drive state
    val installedOnFormatted by derivedStateOf {
        installedOn?.let { dateHelper.getFormattedDate(it) }
    }

    val daysInUse by derivedStateOf {
        installedOn?.let { dateHelper.getDaysSince(it) }
    }

    //waterFill
    val waterFill:Float by derivedStateOf {
        val tc=totalCapacity
        val rc=remainingCapacity
        if (tc!=null&&rc!=null&&areCapacityValueValid(tc, rc)){
            rc.toFloat()/tc.toFloat()
        }else 0f
    }




    init {
        loadData()
    }

    fun loadData(){
        totalCapacity=400
        remainingCapacity=200
        installedOn=1622494800000L
    }

    fun onEdit(){
        editMode=true
    }
    fun onCancel(){
        editMode=false
    }
    fun onSave(){

    }
    fun onClearData(){

    }

    fun onTotalCapacityClicked(){
        capacityInputDialogConfig=CapacityInputDialogConfig(
            titleStringRes = R.string.capacity_input_dialog_total_title,
            initialInput = totalCapacity.toString(),
            onSubmit = {},
            onDismiss = {
                capacityInputDialogConfig=null
            }
        )
    }


    fun onRemainingCapacityClicked(){
        capacityInputDialogConfig=CapacityInputDialogConfig(
            titleStringRes = R.string.capacity_input_dialog_remaining_title,
            initialInput = remainingCapacity.toString(),
            onSubmit = {},
            onDismiss = {
                capacityInputDialogConfig=null
            }
        )
    }


    fun onInstalledOnClicked(){

    }

    private fun areCapacityValueValid(tc:Int,rc:Int):Boolean{
        return tc > 0 && rc > 0 && tc >= rc
    }
}