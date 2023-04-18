import kotlin.math.abs

class BilliardsGame {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer = IntArray(balls.size) { 0 }

        balls.forEachIndexed { idx, ball ->
            var result = Int.MAX_VALUE

            for(i in 0 .. 3) {
                val distance = getDistance(m to n, startX to startY, ball[0] to ball[1], i)
                if(result > distance) result = distance
            }

            answer[idx] = result
        }

        return answer
    }

    fun getDistance(
        range: Pair<Int,Int>,
        start: Pair<Int,Int>,
        target: Pair<Int,Int>,
        type: Int
    ): Int {

        var height = -1
        var width = -1

        when(type) {
            0 -> {
                height = (range.second - start.second) + (range.second - target.second)
                width = abs(start.first - target.first)
            }

            1 -> {
                height = start.second + target.second
                width = abs(start.first - target.first)
            }
            2 -> {
                height = abs(start.second - target.second)
                width = start.first + target.first
            }
            3 -> {
                height = abs(start.second - target.second)
                width = (range.first - start.first) + (range.first - target.first)
            }
        }

        val result =
            if(width == 0 && type == 0 && start.second < target.second) {
                Int.MAX_VALUE
            } else if(width == 0 && type == 1 && start.second > target.second) {
                Int.MAX_VALUE
            } else if(height == 0 && type == 2 && start.first > target.first) {
                Int.MAX_VALUE
            } else if(height == 0 && type == 3 && start.first < target.first) {
                Int.MAX_VALUE
            } else {
                (height*height) + (width*width)
            }

        return result
    }
}