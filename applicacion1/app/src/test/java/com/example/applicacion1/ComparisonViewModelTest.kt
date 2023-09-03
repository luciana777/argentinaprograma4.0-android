package com.example.applicacion1

import org.junit.Assert
import org.junit.Test

class ComparisonViewModelTest {

    private val viewModel = ComparisonViewModel()

    @Test
    fun compareStrings_sameStrings_returnsTrue() {
        val result = viewModel.compareStrings("test iguales", "test iguales")
        Assert.assertTrue(result)
    }

    @Test
    fun compareStrings_differentStrings_returnsFalse() {
        val result = viewModel.compareStrings("probando probando", "probando el programa")
        Assert.assertFalse(result)
    }
}
