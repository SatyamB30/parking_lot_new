package models.parking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MallTest {
    @Test
    fun `check if parking slots are available in mall`() {
        val mall = Mall()

        assertTrue(mall.freeSlotsAvailable())
    }

    @Test
    fun `should provide slot id of free slot`() {
        val mall = Mall()
        val expectedSlotId = 1

        assertEquals(expectedSlotId, mall.getFreeParkingSlotId())
    }

    @Test
    fun `should provide slot id as 2 for free slot when added one vehicle`() {
        val mall = Mall()
        val expectedSlotId = 2

        mall.parkVehicleAtSlot(mall.getFreeParkingSlotId()!!)

        assertEquals(expectedSlotId, mall.getFreeParkingSlotId())
    }

    @Test
    fun `should unPark a vehicle which is parked`() {
        val mall = Mall()
        val expectedSlotId = 1

        mall.parkVehicleAtSlot(mall.getFreeParkingSlotId()!!)
        mall.unParkVehicleAtSlot(1)

        assertEquals(expectedSlotId, mall.getFreeParkingSlotId())
    }
}