package repository

import models.invoice.Receipt

object ReceiptRepository {
    private val allReceipts = mutableMapOf<Int, Receipt>()

    fun addReceipt(receipt: Receipt){
        allReceipts[receipt.receiptNo] = receipt
    }

    fun getReceipt(ticketId: Int): Receipt? {
        return allReceipts[ticketId]
    }

    fun receiptExists(ticketId: Int): Boolean {
        return allReceipts[ticketId] != null
    }

    fun resetReceiptsInventory(){
        allReceipts.clear()
    }
}