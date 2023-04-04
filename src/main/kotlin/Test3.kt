import kotlin.math.max
fun solution(s: String): Int {
    var answer = 1

    for (i in 1 until s.length - 1) {
        var cnt = 1
        var leftIdx = i - 1
        var rightIdx = i + 1
        while (leftIdx >= 0 && rightIdx <= s.lastIndex) {
            if (s[leftIdx] == s[rightIdx]) {
                cnt += 2
            } else {
                break
            }
            leftIdx--
            rightIdx++
        }
        answer = max(answer, cnt)
    }

    for (i in 0 until s.length - 1) {
        if (s[i] != s[i + 1]) continue

        val left = i
        val right = i + 1

        var cnt = 2

        var leftIdx = left - 1
        var rightIdx = right + 1

        while (leftIdx >= 0 && rightIdx <= s.lastIndex) {
            if (s[leftIdx] == s[rightIdx]) {
                cnt += 2
            } else {
                break
            }
            leftIdx--
            rightIdx++
        }
        val list = listOf(0,2,3,4,5,6)


        answer = max(answer, cnt)
    }

    return answer
}
