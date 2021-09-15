package `class`

import kotlin.math.roundToInt

interface Parkable {

    fun checkOutVehicle(plate: String)

    fun onSuccess(payout: Int) {
        println("Payment made correctly for $$payout")
    }

    fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        var finalAmount: Int = 0
        when (type) {
            VehicleType.CAR -> when (parkedTime) {
                in 0..120 -> finalAmount = type.tarifa
                else -> finalAmount = calculatePayAfterTwoHour(type.tarifa, parkedTime)
            }
            VehicleType.MOTO_BIKE -> when (parkedTime) {
                in 0..120 -> finalAmount = type.tarifa
                else -> finalAmount = calculatePayAfterTwoHour(type.tarifa, parkedTime)
            }
            VehicleType.MINI_BUS -> when (parkedTime) {
                in 0..120 -> finalAmount = type.tarifa
                else -> finalAmount = calculatePayAfterTwoHour(type.tarifa, parkedTime)
            }
            VehicleType.BUS -> when (parkedTime) {
                in 0..120 -> finalAmount = type.tarifa
                else -> finalAmount = calculatePayAfterTwoHour(type.tarifa, parkedTime)
            }
        }

        if (hasDiscountCard) return (finalAmount * 0.85).toInt() else return finalAmount
    }

    fun onError() {
        println("Vehicle license not found in parking lot")
    }

    private fun calculatePayAfterTwoHour(amount: Int, parkedTime: Int): Int {
        when {
            (parkedTime - 120) % 15 == 0 -> return (amount + (((parkedTime - 120) / 15).toDouble()
                .roundToInt() * 5))
            else -> return (amount + ((((parkedTime - 120) / 15).toDouble()
                .roundToInt() + 1) * 5))
        }
    }
}