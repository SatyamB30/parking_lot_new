package service

import models.parking.Mall
import models.vehicleType.Car
import models.vehicleType.VehicleStatus
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import repository.FeeRepository
import repository.ReceiptRepository
import repository.TicketRepository

class ParkingServiceTest {
    private val mall = Mall()

    @AfterEach
    fun tearDown() {
        InvoiceGenerator.resetTicketId()
        TicketRepository.resetTicketsInventory()
        ReceiptRepository.resetReceiptsInventory()
        FeeRepository.resetFees()
    }

    @Test
    fun `should park a car to slot 1 and ticketno1`() {
        val car = Car(7226)

        val ticket = ParkingService().parkVehicle(car, mall)

        assertEquals(1, ticket!!.slotNo)
        assertEquals(1, ticket.ticketNo)
    }

    @Test
    fun `should park two car to slot 1 and 2 and ticketNo 1 and 2`() {
        val car1 = Car(7226)
        val car2 = Car(725)

        ParkingService().parkVehicle(car1, mall)
        val ticket = ParkingService().parkVehicle(car2, mall)

        assertEquals(2, ticket!!.slotNo)
        assertEquals(2, ticket.ticketNo)
        assertEquals(VehicleStatus.PARKED, car2.getVehicleStatus())
    }

    @Test
    fun `should park and un park a car to get the receipt`() {
        val car1 = Car(7226)

        val ticket = ParkingService().parkVehicle(car1, mall)

        val receipt = ParkingService().unParkVehicle(ticket!!.ticketNo, mall, car1)

        assertEquals(1, receipt!!.receiptNo)
        assertEquals(VehicleStatus.UN_PARKED, car1.getVehicleStatus())


    }

    @Test
    fun `should return null receipt if ticket doesn't exist`() {
        val receipt = ParkingService().unParkVehicle(124, mall, Car(123))

        assertNull(receipt)
    }

    @Test
    fun `should return null if parking doesn't exist at time of parking`() {
        val mall = Mall()
        for (index in 0..99) {
            ParkingService().parkVehicle(Car(vehicleNo = index), mall)
        }
        val ticket101 = ParkingService().parkVehicle(Car(vehicleNo = 101), mall)

        assertNull(ticket101)
    }
}