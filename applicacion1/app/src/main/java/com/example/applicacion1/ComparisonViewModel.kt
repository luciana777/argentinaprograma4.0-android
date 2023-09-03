package com.example.applicacion1

import androidx.lifecycle.ViewModel

class ComparisonViewModel : ViewModel() {
    private val logic = ComparisonLogic()

    fun compareStrings(str1: String, str2: String): Boolean {
        return logic.areStringsEqual(str1, str2)
    }
}
