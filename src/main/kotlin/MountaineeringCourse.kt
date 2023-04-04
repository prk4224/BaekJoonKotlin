var intensity = Int.MAX_VALUE
var targetSummits = 0
lateinit var checkedGrape: Array<Array<Boolean>>
lateinit var courseGrape: Array<Array<Int>>

fun main() {
    val n = 6

    val paths = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(2, 3, 5),
        intArrayOf(2, 4, 2),
        intArrayOf(2, 5, 4),
        intArrayOf(3, 4, 4),
        intArrayOf(4, 5, 3),
        intArrayOf(4, 6, 1),
        intArrayOf(5, 6, 1),
    )

    val gates = intArrayOf(1, 3)
    val summits = intArrayOf(5)
    solution(n, paths, gates, summits)
}

fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {

    courseGrape = Array(n + 1) {
        Array(n + 1) { 0 }
    }

    for (i in paths.indices) {
        courseGrape[paths[i][0]][paths[i][1]] = paths[i][2]
        courseGrape[paths[i][1]][paths[i][0]] = paths[i][2]
    }
    gates.forEach {
        initCheckedGrape(n)
        findIntensity(n, it, gates.toList(), false, it, 0, summits.toList(), 0)
    }

    return intArrayOf(targetSummits, intensity)
}

fun findIntensity(
    n: Int,
    gate: Int,
    gates: List<Int>,
    checkedStart: Boolean,
    location: Int,
    currentIntensity: Int,
    summits: List<Int>,
    summit: Int
) {
    if (gate == location && checkedStart) {
        if (currentIntensity < intensity) {
            intensity = currentIntensity
            targetSummits = summit
        }
        if (currentIntensity == intensity) {
            targetSummits = targetSummits.coerceAtMost(summit)
        }
        initCheckedGrape(n)
        return
    } else {
        courseGrape[location].forEachIndexed { idx, value ->
            val temp = if (summits.contains(location)) {
                initCheckedGrape(n)
                location
            } else if(summit != 0) {
                summit
            } else {
              0
            }
            if (value != 0 && checkedGrape[location][idx].not() && gates.contains(idx).not()) {
                checkedGrape[location][idx] = true
                checkedGrape[idx][location] = true
                findIntensity(n, gate, gates, true, idx, currentIntensity.coerceAtLeast(value), summits, temp)
                return
            }
        }
    }
}

fun initCheckedGrape(n: Int) {
    checkedGrape = Array(n + 1) {
        Array(n + 1) { false }
    }
}