package com.example.mint.mcdone

import com.example.mint.mcdone.util.StorageUtil
import org.junit.Test

import org.junit.Assert.*

/**
 * Storage unit test
 *
 * Check the existence of the storage
 */

class StorageUtilTest {

   val storage = StorageUtil

    @Test
    fun storageExists(){
        assertNotNull(storage)
    }
}