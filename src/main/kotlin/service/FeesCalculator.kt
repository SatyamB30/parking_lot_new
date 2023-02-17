package service

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.ceil

const val FEE_RATE_PER_HOUR = 10

class FeesCalculator {
    fun calculate(parkingDateTime: LocalDateTime, exitDateTime: LocalDateTime?): Int {
        val noOfHours = ceil(parkingDateTime.until(exitDateTime, ChronoUnit.HOURS).toDouble()).toInt()
        return noOfHours * FEE_RATE_PER_HOUR
    }
}

