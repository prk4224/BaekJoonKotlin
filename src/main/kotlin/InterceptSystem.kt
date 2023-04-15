import java.util.LinkedList
import java.util.Queue
import kotlin.math.pow

class InterceptSystem {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 1
        val sortTargets = targets.sortedBy {
            -it[0]
        }

        val list = Array(5 + 1) { 0L }
        list[1] = 5L
        list[2] = 13L


        var started = sortTargets[0][0]
        val ttt = LinkedList<Queue<Pair<Int,Int>>>()
        sortTargets.forEach {
            if(it[1] <= started) {
                answer += 1
                started = it[0]
            }
        }
        val temp = 2.0
        val tmpe1 = temp.pow(2.0)

        return answer
    }
}