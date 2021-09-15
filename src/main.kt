import `class`.Parking
import `class`.Vehicle
import `class`.VehicleType
import java.util.*


fun main() {

    val vehiclesList = listOf<Vehicle>(
        Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("BB111BB", VehicleType.MOTO_BIKE, Calendar.getInstance()),
        Vehicle("CC111CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("DD111DD", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("AA222AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("BB222BB", VehicleType.MOTO_BIKE, Calendar.getInstance()),
        Vehicle("CC222CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("DD222DD", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("AA333AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("BB333BB", VehicleType.MOTO_BIKE, Calendar.getInstance()),
        Vehicle("CC333CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("DD333DD", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("AA444AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("BB444BB", VehicleType.MOTO_BIKE, Calendar.getInstance()),
        Vehicle("CC444CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("AA555AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("BB555BB", VehicleType.MOTO_BIKE, Calendar.getInstance()),
        Vehicle("CC555CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("DD555DD", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("AA666AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("BB666BB", VehicleType.MOTO_BIKE, Calendar.getInstance()),
        Vehicle("CC666CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("DD666DD", VehicleType.BUS, Calendar.getInstance()),
    )

    val parking = Parking(mutableSetOf())

    vehiclesList.forEach { parking.checkIn(it) }

    println()

    println("Click the Enter key for take the car AA111AA out of parking")
    readLine()

    parking.checkOutVehicle("AA111AA")
    parking.showInfoListRetiredVehicles()

    println()
    println("Click the Enter key for try take the car AA111AAA out of parking ")
    readLine()

    parking.checkOutVehicle("AA111AA")

    println()
    println("Click the Enter key for take the car CC333CC out of parking")
    readLine()

    parking.checkOutVehicle("CC333CC")
    parking.showInfoListRetiredVehicles()

    println()
    println("Click the Enter key to continue")
    readLine()

    parking.listVehicles()
}
