import java.util.*

class TwoCircleCoordinate {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        val big = getCoordinateCount(r2)
        val small = getCoordinateCount(r1)

        return big - small + 4
    }

    fun getCoordinateCount(radius: Int): Long {
        val temp = mutableListOf<Int>()
        val intArray = IntArray(100)

        if(radius == 1) return 5L
        if(radius == 2) return 13L
        //.  24.36
        // 5 13 29 49
        //  8 16 20

        return 0L
    }
}