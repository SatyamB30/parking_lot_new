package models.invoice

import models.vehicleType.Vehicle
import java.time.LocalDateTime

class Ticket(val ticketNo: Int, val slotNo: Int, val parkingDateTime: LocalDateTime, val vehicle: Vehicle)