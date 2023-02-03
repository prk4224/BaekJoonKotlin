import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    // 3 1 15 34 5 2 1 7 13
    val st = StringTokenizer(readLine())
    val N = st.nextToken()?.toInt() ?: 0
    val target = st.nextToken()?.toInt() ?: 0

    val input = readLine().split(" ").map { it.toInt() }
    var currentValue = input[0]
    var end = 0
    var minLength = Int.MAX_VALUE

    for(start in 0 until N) {

        while(currentValue < target && end < N) {
            end++
            if(end < N) currentValue += input[end]
        }

        if(minLength > (end - start) && currentValue >= target) {
            minLength = (end - start)
        }

        currentValue -= input[start]
    }

    if(minLength == Int.MAX_VALUE) {
        print(0)
    } else {
        print(minLength+1)
    }

}