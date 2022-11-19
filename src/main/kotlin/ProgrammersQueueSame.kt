import java.util.*
import kotlin.collections.ArrayList

var que1 = LinkedList<Int>()
var que2 = LinkedList<Int>()

fun main() {
    var cnt = 0

    val queue1 = intArrayOf(1, 2, 4)
    val queue2 = intArrayOf(3, 2, 4)
    val maxCnt = (queue1.size + queue2.size).toLong()

    var total1 = getTotal(queue1)
    var total2 = getTotal(queue2)

    que1 = setQueue(queue1)
    que2 = setQueue(queue2)

    if((total1+total2) % 2 == 1){
        println(-1)
        return
    }

    while(total1 != total2){
        cnt++

        if(cnt > maxCnt){
            println(-1)
            return
        }

        if(total1 == 0 || total2 == 0){
            println(-1)
            return
        }

        if(compareToTotal(total1,total2)){
            // total1 이 클때
            val temp = que1.pop()
            total1 -= temp
            que2.push(temp)
            total2 += temp

        } else {
            val temp = que2.pop()
            total2 -= temp
            que1.push(temp)
            total1 += temp
        }
    }
    println(cnt)
}

fun setQueue(queue: IntArray): LinkedList<Int> {
    val que = LinkedList<Int>()
    for(i in queue){
        que.add(i)
    }
    return que
}

fun getTotal(queue: IntArray): Int {
    var result = 0
    for(i in queue){
        result += i
    }
    return result
}

fun compareToTotal(total1: Int, total2: Int): Boolean {
    return total1 > total2
}