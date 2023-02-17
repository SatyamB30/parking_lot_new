package models.parking

open class ParkingFloor(private val floorSize: Int, val floorType: ParkingType) {
    private val slots = MutableList<Boolean>(floorSize) { true }

    fun freeSlotsAvailable(): Boolean {
        return true in slots
    }

    fun getFreeParkingSlotId(): Int? {
        for (slotId in 0 until slots.size) {
            if (slots[slotId]) {
                return slotId + 1
            }
        }
        return null
    }

    fun parkVehicleAtSlot(slotId: Int) {
        slots[slotId - 1] = false
    }

    fun unParkVehicleAtSlot(slotId: Int) {
        slots[slotId - 1] = true
    }
}