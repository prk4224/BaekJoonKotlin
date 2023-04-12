import java.lang.IllegalArgumentException

fun main() {

    val picks = intArrayOf(0,0,3)
    val minerals = arrayOf(
        "diamond"
    )
    println(MineralMining().solution(picks,minerals))
}
class MineralMining {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var result = 0
        var tempMinerals = minerals.toList()
        val arrayList = ArrayList<List<String>>()

        while (true) {
            if(tempMinerals.size > 5) {
                arrayList.add(tempMinerals.subList(0,5))
                tempMinerals = tempMinerals.subList(5,tempMinerals.lastIndex+1)
            } else {
                arrayList.add(tempMinerals)
                break
            }
        }
        val realPicks = IntArray(3)
        var size = arrayList.size

        for(idx in 0 .. 2) {
            if(picks[idx] >= size) {
                realPicks[idx] = size
                size = 0
                break
            } else {
                realPicks[idx] = picks[idx]
                size -= picks[idx]
            }
        }
        repeat(size) {
            arrayList.removeAt(arrayList.lastIndex)
        }

        var index = 2

        while(index >= 0) {
            if(realPicks[index] > 0) {
                result += getMinFatigue(arrayList,index)
                realPicks[index]--
            } else {
                index--
            }
        }
        return result
    }

    fun getMinFatigue(arrayList: ArrayList<List<String>>, pick: Int): Int {

        var minValue = Int.MAX_VALUE
        var minIndex = -1

        arrayList.forEachIndexed { idx, value ->
            val temp = getFatigue(value,pick)
            if(minValue > temp) {
                minValue = temp
                minIndex = idx
            }
        }

        arrayList.removeAt(minIndex)
        return minValue
    }

    fun getFatigue(minerals: List<String>, pick: Int): Int {
        var sum = 0
        minerals.forEach {
            sum += getTypeValue(it,pick)
        }
        return sum
    }

    fun getTypeValue(mineral: String, pick: Int): Int {
        return when {
            mineral == "diamond" && pick == 1 -> 5
            mineral == "diamond" && pick == 2 -> 25
            mineral == "iron" && pick == 2 -> 5
            else -> 1
        }
    }
}
