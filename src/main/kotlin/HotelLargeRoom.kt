class HotelLargeRoom {
    val checkedArray = IntArray(1440) { 0 }

    fun solution(book_time: Array<Array<String>>): Int {

        book_time.forEach { time ->
            val startTemp = time[0].split(":")
            val start = startTemp[0].toInt() * 60 + startTemp[1].toInt() + 1

            val endTemp = time[1].split(":")
            val end = endTemp[0].toInt() * 60 + endTemp[1].toInt() + 10


            for(i in start .. end) {
                if(i < 1440) checkedArray[i] += 1
            }
        }

        val result = checkedArray.maxOrNull()

        return result ?: 0
    }
}