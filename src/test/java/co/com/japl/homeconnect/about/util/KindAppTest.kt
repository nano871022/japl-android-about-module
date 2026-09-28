package co.com.japl.homeconnect.about.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KindAppTest {

    @Test
    fun testGetFinances() {
        val kindApp = KindApp.get("co.japl.android.myapplication")
        assertNotNull(kindApp)
        assertEquals(KindApp.FINANCES, kindApp)
    }

    @Test
    fun testGetTorresSanSebastian() {
        val kindApp = KindApp.get("torressansebastian")
        assertNotNull(kindApp)
        assertEquals(KindApp.TORRES_SAN_SEBASTIAN, kindApp)
    }

    @Test
    fun testGetUnknown() {
        val kindApp = KindApp.get("unknown_app_id")
        assertNull(kindApp)
    }

    @Test
    fun testGetDifferent() {
        val different = KindApp.getDifferent("torressansebastian")
        assertTrue(different.none { it == KindApp.TORRES_SAN_SEBASTIAN })
        assertTrue(different.contains(KindApp.FINANCES))
    }
}
