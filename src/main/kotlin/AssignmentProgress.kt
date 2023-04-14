import java.util.Stack


fun main() {
    val plans = arrayOf(
        arrayOf("aaa", "12:00", "20"),
        arrayOf("bbb", "12:10", "30"),
        arrayOf("ccc", "12:40", "10"),
    )
    val temp = listOf(
        Pair(1,4),
        Pair(2,4),
        Pair(1,5),
        Pair(3,6),
        Pair(2,6),
        Pair(1,7),
        Pair(1,6),
    )

    val tmpelist = temp.sortedWith(
        compareBy({it.first},{it.second})
    )

    tmpelist.forEach {
        println("${it.first} / ${it.second}")
    }

    val result = AssignmentProgress().solution(plans)

    result.forEach {
        println(it)
    }
}
class AssignmentProgress {
    fun solution(plans: Array<Array<String>>): Array<String> {

        val waitQueue = Stack<Pair<String,Int>>()
        val result = arrayListOf<String>()

        val list = List(plans.size) {idx ->
            val time = plans[idx][1].split(":")
            val startTime = time[0].toInt() * 60 + time[1].toInt()
            Triple(startTime,plans[idx][0],plans[idx][2].toInt())
        }

        val sortList = list.sortedBy { it.first }

        var currentTime = sortList[0]
        var idx = 1

        while(waitQueue.empty().not() || idx < sortList.size) {
            if(idx < sortList.size && currentTime.first + currentTime.third > sortList[idx].first ) {
                val time = (currentTime.third + currentTime.first) - sortList[idx].first
                waitQueue.add(Pair(currentTime.second,time))
                currentTime = sortList[idx]
                idx += 1
            } else {
                result.add(currentTime.second)
                if(waitQueue.empty().not()) {
                    val wait = waitQueue.pop()
                    currentTime = Triple(currentTime.first+currentTime.third,wait.first,wait.second)
                } else {
                    currentTime = sortList[idx]
                    idx += 1
                }
            }
        }

        result.add(currentTime.second)

        return Array(result.size) {
            result[it]
        }
    }
}