package models.vehicleType

open class Vehicle(
    private val vehicleNo: Int,
    private val vehicleType: VehicleT,
    private var vehicleStatus: VehicleStatus = VehicleStatus.UN_PARKED
) {

    fun getVehicleNo(): Int {
        return vehicleNo
    }

    fun getVehicleType(): VehicleT {
        return this.vehicleType
    }

    fun getVehicleStatus(): VehicleStatus {
        return this.vehicleStatus
    }

    fun setVehicleStatusAsParked() {
        this.vehicleStatus = VehicleStatus.PARKED
    }

    fun setVehicleStatusAsUnParked(){
        this.vehicleStatus = VehicleStatus.UN_PARKED
    }
}