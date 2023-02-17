package service

object InvoiceGenerator {
    private var ticketId = 1
    private var receiptId = 1

    fun generateTicketId(): Int {
        return ticketId++
    }

    fun generateReceiptId(): Int {
        return receiptId++
    }

    fun resetTicketId(){
        ticketId = 1
    }

    fun resetReceiptId(){
        receiptId = 1
    }
}