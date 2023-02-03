fun main() = with(System.`in`.bufferedReader()) {

    val N = readLine()?.toInt() ?: 0
    val input = readLine().split(" ").map { it.toInt() }.sorted()
    val target = readLine()?.toInt() ?: 0
    var result = 0
    var start = 0
    var end = N-1

    while(start < end) {
        when {
            input[start]+input[end] > target -> end--
            input[start]+input[end] < target -> start++
            else -> {
                result++
                end--
                start++
            }
        }
    }

    print(result)
}