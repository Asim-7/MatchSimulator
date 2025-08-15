package com.miniclip.matchsimulator.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class HeadToHeadConverterTest {

    private val converter = HeadToHeadConverter()

    @Test
    fun fromMap_and_toMap_areInverse() {
        val map = mapOf("TeamA" to 1, "TeamB" to 0, "TeamC" to 2)
        val json = converter.fromMap(map)
        val result = converter.toMap(json)
        assertEquals(map, result)
    }

    @Test
    fun toMap_handlesEmptyString() {
        val result = converter.toMap("{}")
        assertEquals(emptyMap<String, Int?>(), result)
    }
}