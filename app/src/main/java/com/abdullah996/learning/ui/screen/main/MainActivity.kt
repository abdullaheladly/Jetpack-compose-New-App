package com.abdullah996.learning.ui.screen.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel:MainViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(viewModel)
        }

        searchInsert(intArrayOf(1,2,5,6),4)

        makeLog(searchInsert(intArrayOf(1,2,5,6),4))


        // Log.i("leetcode", removeDuplicates(intArray).toString())
    }


    fun searchInsert(nums: IntArray, target: Int): Int {
        if(nums[0]==target||nums[0]>target){
            makeLog("0")

            return 0
        }else if (nums.last()==target){
            makeLog(1)
            return  nums.size-1

        }else if (nums.last()<target){
            makeLog(2)
            return nums.size
        }else{
            for (item in 0 until nums.size){
                if (nums[item]==target){
                    makeLog(3)
                    return item
                }
                else if (nums[item]>target) {
                    makeLog(4)
                    return item
                }
            }

        }
        return 0
    }

    fun makeLog(string: Any){
        Log.d("leetCode",string.toString())
    }



}

