package com.example.mint.mcdone


import com.example.mint.mcdone.util.GlideUtil
import org.junit.Test
import org.junit.Assert.*

/**
 * Glide unit test
 *
 * Check if Glide module working or not
 */

class GlideUtilTest {

    private val glide = GlideUtil()

    @Test
    fun checkGlideNotNull(){

        assertNotNull(glide)

    }



}