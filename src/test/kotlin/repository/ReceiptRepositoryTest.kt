package repository

import models.invoice.Receipt
import models.invoice.Ticket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ReceiptRepositoryTest{
    @Test
    fun `should add receipt to receipt repository`() {
        val receipt = Receipt(receiptNo = 1, entryDateTime = LocalDateTime.now(), exitDateTime = LocalDateTime.now(), fee = 20)

        ReceiptRepository.addReceipt(receipt)

        assertTrue(ReceiptRepository.receiptExists(1))
        assertEquals(receipt,ReceiptRepository.getReceipt(1))
    }

}