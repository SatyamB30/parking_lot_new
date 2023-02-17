package repository

object FeeRepository {
    private var collectedFee = 0

    fun storeCollectedFees(fees: Int) {
        collectedFee += fees
    }

    fun resetFees() {
        collectedFee = 0
    }
}