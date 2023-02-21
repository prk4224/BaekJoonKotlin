import kotlin.math.abs
import kotlin.math.max

fun main() {
    val map = mutableMapOf<String,Int>()

    val movie = arrayOf("spy", "ray", "spy", "room", "once", "ray", "spy", "once")

    for(i in 0 until movie.size) {
        if(map.containsKey(movie[i])){
            val temp = map[movie[i]]
            if(temp !== null) {
                map[movie[i]] = temp + 1
            }
        } else {
            map[movie[i]] = 1
        }
    }

    val mapList = map.toList()

    val tempList = mapList.sortedWith( compareBy ({-(it.second)},{it.first}) )

    for(i in 0 until tempList.size) {
        println("${tempList[i].first} / ${tempList[i].second}")
    }

    val result = Array(tempList.size) { idx -> tempList[idx].first }
}