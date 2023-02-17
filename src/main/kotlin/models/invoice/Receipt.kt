package models.invoice

import java.time.LocalDateTime

class Receipt(val receiptNo: Int, val entryDateTime: LocalDateTime, val exitDateTime: LocalDateTime, val fee: Int) {
}