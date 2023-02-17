package service

import models.invoice.Ticket
import models.vehicleType.Vehicle
import java.time.LocalDateTime

class TicketService {
    fun getTicket(slotId: Int, vehicle: Vehicle, startDateTime: LocalDateTime = LocalDateTime.now()): Ticket {
        return Ticket(InvoiceGenerator.generateTicketId(), slotId, startDateTime, vehicle)
    }
}