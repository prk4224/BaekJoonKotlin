
private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() {

    val N = readLine()?.toInt() ?: throw IllegalArgumentException("Input Size Error")

    val map = Array(N) { CharArray(N) }
    val checked = Array(N) { BooleanArray(N) { false } }

    for (i in 0 until N) {
        val temp = readLine().toString()
        for (j in 0 until N) {
            map[i][j] = temp[j]
        }
    }
    var result = 0

    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until 4) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue
                if (!checked[nx][ny] && map[i][j] != map[nx][ny]) {
                    val tempMap = Array(N) { item ->
                        map[item].clone()
                    }
                    val swapMap = swapMap(Pair(i, j), Pair(nx, ny), tempMap)
                    result = result.coerceAtLeast(resultCandy(swapMap, N))
                }
                checked[i][j] = true
            }
        }
    }

    print(result)
}

fun swapMap(
    current: Pair<Int, Int>,
    target: Pair<Int, Int>,
    map: Array<CharArray>
): Array<CharArray> {
    val temp = map[current.first][current.second]
    map[current.first][current.second] = map[target.first][target.second]
    map[target.first][target.second] = temp

    return map
}

fun resultCandy(map: Array<CharArray>, size: Int): Int {
    var result = 0

    for (i in 0 until size) {
        result = result.coerceAtLeast(countingCandy(map[i], size))
        result = result.coerceAtLeast(countingCandy(getColumnArray(map, i, size), size))
    }

    return result
}

fun getColumnArray(map: Array<CharArray>, index: Int, size: Int): CharArray {
    return CharArray(size) { i ->
        map[i][index]
    }
}

fun countingCandy(map: CharArray, size: Int): Int {
    var total = 1
    var result = 0
    for (i in 0 until size - 1) {
        if (map[i] == map[i + 1]) {
            total++
        } else {
            result = result.coerceAtLeast(total)
            total = 1
        }
    }

    result = result.coerceAtLeast(total)
    return result
}