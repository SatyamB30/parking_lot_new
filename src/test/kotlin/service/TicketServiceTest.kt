package service

import models.vehicleType.Car
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import repository.TicketRepository

class TicketServiceTest{
    @AfterEach
    fun tearDown() {
        InvoiceGenerator.resetTicketId()
        TicketRepository.resetTicketsInventory()
    }

    @Test
    fun `generate a ticket with slot id 1 and ticket id 1`() {
        val expectedTicketSlotNo = 1
        val expectedTicketTicketNo = 1

        val actualTicket = TicketService().getTicket(1, Car(100))

        assertEquals(expectedTicketSlotNo, actualTicket.slotNo)
        assertEquals(expectedTicketTicketNo, actualTicket.ticketNo)
    }

    @Test
    fun `should generate a ticket with ticketNo 2 when two tickets are generated`() {
        val expectedTicketSlotNo = 12
        val expectedTicketTicketNo = 2
        TicketService().getTicket(1, Car(100))

        val actualTicket = TicketService().getTicket(12, Car(100))

        assertEquals(expectedTicketSlotNo, actualTicket.slotNo)
        assertEquals(expectedTicketTicketNo, actualTicket.ticketNo)
    }
}