package repository

import models.invoice.Ticket

object TicketRepository {
    private val allTickets = mutableMapOf<Int, Ticket>()

    fun addTicket(ticket: Ticket){
        allTickets[ticket.ticketNo] = ticket
    }

    fun getTicket(ticketId: Int): Ticket? {
        return allTickets[ticketId]
    }

    fun ticketExists(ticketId: Int): Boolean {
        return allTickets[ticketId] != null
    }

    fun resetTicketsInventory(){
        allTickets.clear()
    }
}