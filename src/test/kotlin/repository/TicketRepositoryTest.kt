package repository

import models.invoice.Ticket
import models.vehicleType.Car
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TicketRepositoryTest{
    @Test
    fun `should add ticket to ticket repository`() {
        val ticket1 = Ticket(ticketNo = 1, slotNo = 1, parkingDateTime = LocalDateTime.now(), Car(100))

        TicketRepository.addTicket(ticket1)

        assertTrue(TicketRepository.ticketExists(1))
        assertEquals(ticket1,TicketRepository.getTicket(1))
    }
}