fun main() {

    val fees = intArrayOf(1, 461, 1, 10)
    val records = arrayOf(
        "00:00 1234 IN"
    )

    val result = solution(fees,records)
    result.forEach {
        println("$it")
    }
}

// fees: 0/기본시간, 1/기본요금, 2/단위시간, 3/단위 요금
fun solution(fees: IntArray, records: Array<String>): IntArray {
    val result = ArrayList<Int>()
    val inCar = hashMapOf<String,Int>()
    val carList = mutableListOf<Int>()
    val minute = MutableList(10000) { 0 }

    records.forEach {
        val record = it.split(" ")
        if(record[2] == "IN") {
            inCar[record[1]] = convertHourFromMinute(record[0])
            if(carList.contains(record[1].toInt()).not()) {
                carList.add(record[1].toInt())
            }
        } else {
            val inTime = inCar.remove(record[1])
            val parkingTime = convertHourFromMinute(record[0])- inTime!!
            minute[record[1].toInt()] += parkingTime
        }
    }

    inCar.forEach { (key, value) ->
        val parkingTime = 1439 - value
        minute[key.toInt()] += parkingTime
    }

    carList.sorted().forEach {
        result.add(calculateFee(fees, minute[it]))
    }

    return result.toIntArray()
}

fun calculateFee(fees: IntArray, time: Int): Int {

    return if(fees[0] >= time) {
        fees[1]
    } else {
        val addTime = time - fees[0]
        val addFee = if((addTime%fees[2]) == 0) addTime/fees[2] else (addTime/fees[2]) + 1
        fees[1] + (addFee * fees[3])
    }
}

fun convertHourFromMinute(time: String): Int {
    val temp = time.split(":")
    return (temp[0].toInt() * 60) + temp[1].toInt()
}