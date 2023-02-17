package vehicleType

import models.vehicleType.Car
import models.vehicleType.VehicleStatus
import models.vehicleType.VehicleT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VehicleTest {

    @Test
    fun `create a car object`() {
        val expectedCarNo = 7226
        val expectedCarType = VehicleT.CAR
        val expectedCarStatus = VehicleStatus.UN_PARKED

        val car1 = Car(7226)
        val actualCarNo = car1.getVehicleNo()
        val actualCarType = car1.getVehicleType()
        val actualCarStatus = car1.getVehicleStatus()

        assertEquals(expectedCarNo, actualCarNo)
        assertEquals(expectedCarType, actualCarType)
        assertEquals(expectedCarStatus, actualCarStatus)
    }
}