package service

import models.invoice.Receipt
import models.invoice.Ticket
import models.parking.ParkingFloor
import models.vehicleType.Vehicle
import repository.FeeRepository
import repository.ReceiptRepository
import repository.TicketRepository
import java.time.LocalDateTime

class ParkingService {
    fun parkVehicle(vehicle: Vehicle, parking: ParkingFloor): Ticket? {
        if (parking.freeSlotsAvailable()) {
            val parkingSlot = parking.getFreeParkingSlotId()!!
            parking.parkVehicleAtSlot(parkingSlot)
            vehicle.setVehicleStatusAsParked()

            val parkingTicket = TicketService().getTicket(parkingSlot, vehicle, LocalDateTime.now())

            TicketRepository.addTicket(parkingTicket)
            return parkingTicket
        }
        return null
    }

    fun unParkVehicle(ticketNo: Int, parking: ParkingFloor, vehicle: Vehicle): Receipt? {
        if (TicketRepository.ticketExists(ticketNo)) {
            val ticket = TicketRepository.getTicket(ticketNo)

            parking.unParkVehicleAtSlot(ticket!!.slotNo)
            vehicle.setVehicleStatusAsUnParked()

            val receipt = ReceiptService().getReceipt(ticket, LocalDateTime.now())

            FeeRepository.storeCollectedFees(receipt.fee)
            ReceiptRepository.addReceipt(receipt)

            return receipt
        }
        return null
    }
}