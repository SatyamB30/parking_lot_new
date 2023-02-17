package service

import models.invoice.Receipt
import models.invoice.Ticket
import java.time.LocalDateTime

class ReceiptService {
    fun getReceipt(ticket: Ticket, exitDateTime: LocalDateTime): Receipt {
        val fees = FeesCalculator().calculate(ticket.parkingDateTime, exitDateTime)
        return Receipt(InvoiceGenerator.generateReceiptId(), ticket.parkingDateTime, exitDateTime, fees)
    }

}
