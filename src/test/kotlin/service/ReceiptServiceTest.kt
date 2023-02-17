package service

import models.vehicleType.Car
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import repository.FeeRepository
import repository.ReceiptRepository
import repository.TicketRepository
import java.time.LocalDateTime

class ReceiptServiceTest {
    @BeforeEach
    fun tearDown() {
        InvoiceGenerator.resetTicketId()
        InvoiceGenerator.resetReceiptId()

        FeeRepository.resetFees()

        TicketRepository.resetTicketsInventory()
        ReceiptRepository.resetReceiptsInventory()
    }

    @Test
    fun `should generate a receipt for valid ticket`() {
        val ticket = TicketService().getTicket(1, Car(111), LocalDateTime.of(2022, 1, 5, 9, 0, 0, 0))
        val receipt = ReceiptService().getReceipt(ticket, LocalDateTime.of(2022, 1, 5, 10, 0, 0, 0))

        assertEquals(10, receipt.fee)
        assertEquals(1, receipt.receiptNo)
    }

    @Test
    fun `should generate receipt for two valid ticket`() {
        val ticket1 = TicketService().getTicket(1, Car(111), LocalDateTime.of(2022, 1, 5, 9, 0, 0, 0))
        val ticket2 = TicketService().getTicket(1, Car(111), LocalDateTime.of(2022, 1, 5, 10, 0, 0, 0))
        ReceiptService().getReceipt(ticket1, LocalDateTime.of(2022, 1, 5, 10, 0, 0, 0))
        val receipt2 = ReceiptService().getReceipt(ticket2, LocalDateTime.of(2022, 1, 5, 12, 0, 0, 0))

        assertEquals(20, receipt2.fee)
        assertEquals(2, receipt2.receiptNo)
    }
}