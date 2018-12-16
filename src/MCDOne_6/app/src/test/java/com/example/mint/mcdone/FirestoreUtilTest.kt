package com.example.mint.mcdone

import com.example.mint.mcdone.util.FirestoreUtil
import org.junit.Test

import org.junit.Assert.*

/**
 * Firebase unit test
 *
 * Check if Firebase module working or not
 */

class FirestoreUtilTest {

    private val fireStore = FirestoreUtil

    @Test
    fun checkFireStoreNotNull(){

        assertNotNull(fireStore)
    }

    @Test
    fun checkHealthNotNull(){

        assertNotNull(fireStore.health)
    }

    @Test
    fun checkMedNotNull(){

        assertNotNull(fireStore.med)
    }




}