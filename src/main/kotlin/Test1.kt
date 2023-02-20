import kotlin.math.abs

var answerList = mutableListOf<Int>()

fun solution(k: Int, numbers: IntArray): Int {
    permutation(numbers, 0, 0, k, numbers.size)
    val answer = answerList.minOrNull() ?: -1

    return answer
}

fun permutation(numbers: IntArray, depth: Int, cnt: Int, k: Int, N: Int) {
    if (depth == N) {
        var flag = true
        for (i in 1 until numbers.size) {
            if (abs(numbers[i - 1] - numbers[i]) > k) {
                flag = false
                break
            }
        }
        if (flag) answerList.add(cnt)
    }
    for (i in depth until N) {
        swap(numbers, depth, i)
        if (depth != i) {
            permutation(numbers, depth + 1, cnt + 1, k, N)
        }
        else {
            permutation(numbers, depth + 1, cnt, k, N)
        }
        swap(numbers, depth, i)
    }
}

fun swap(numbers: IntArray, depth: Int, i: Int) {
    val tmp = numbers[depth]
    numbers[depth] = numbers[i]
    numbers[i] = tmp
}

