package `class`

import utils.Utlis.MINUTES_IN_MILISECONDS
import utils.Utlis.SPACE_PARKABLE
import java.util.*

data class Parking(var vehicles: MutableSet<Vehicle>,var retiredVehicles: Pair<Int, Int> = Pair(0, 0)) : Parkable {



    private fun addVehicle(vehicle: Vehicle): Boolean {
        return if (this.vehicles.size < SPACE_PARKABLE) {
            this.vehicles.add(vehicle)
            true
        } else {
            false
        }
    }

    fun checkIn(vehicle: Vehicle) {
        if (addVehicle(vehicle)) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }

    fun showInfoListRetiredVehicles(){
     println("${retiredVehicles.first} vehicles have checked out and have earnings of ${retiredVehicles.second}")
    }

    fun listVehicles(){
        vehicles.forEach { println(it.plate) }
    }

    private fun updateListRetiredVehicles(amount:Int){
        retiredVehicles=retiredVehicles.copy(first = retiredVehicles.first+1)
        retiredVehicles=retiredVehicles.copy(second = retiredVehicles.second+amount)
    }



    override fun checkOutVehicle(plate: String) {
        val existVehicle = (vehicles.firstOrNull { it.plate == plate })

        if (existVehicle != null) {
            // (Automaticamente se evalua con 135 minutos para tener un tiempo real a modo
            // de ejemplo en la linea 51:58 "(60000 * 135)")
            val existDiscount: Boolean = !existVehicle.discountCard.isNullOrEmpty()
            val parkedTime: Int =
                (((Calendar.getInstance().timeInMillis + (60000 * 135)) - existVehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS).toInt()


            onSuccess(calculateFee(existVehicle.type, parkedTime, existDiscount))

            this.vehicles.remove(existVehicle)
        } else {
            onError()
        }
    }

    override fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        return super.calculateFee(type, parkedTime, hasDiscountCard)
    }

    override fun onSuccess(payout: Int) {
        updateListRetiredVehicles(payout)
        super.onSuccess(payout)
    }

    override fun onError() {
        super.onError()
    }
}
