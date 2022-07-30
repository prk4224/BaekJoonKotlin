import java.util.*

fun main(){

    val loopCnt = readLine()?.toInt()?: 0
    var priorityQueue = PriorityQueue<Int>()


    for(i in 0 until loopCnt){
        val input = readLine()?.toInt()?: 0

        if(input == 0) {
            if(priorityQueue.size == 0) println(0)
            else println(priorityQueue.remove())
        }
        else priorityQueue.add(input)
    }
}