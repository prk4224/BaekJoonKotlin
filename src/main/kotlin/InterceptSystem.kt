class InterceptSystem {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 1
        val sortTargets = targets.sortedBy {
            -it[0]
        }

        var started = sortTargets[0][0]

        sortTargets.forEach {
            if(it[1] <= started) {
                answer += 1
                started = it[0]
            }
        }

        return answer
    }
}