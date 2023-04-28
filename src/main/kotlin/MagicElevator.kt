class MagicElevator {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var temp = storey

        while(temp > 0) {
            val remainder = temp%10
            temp /= 10
            if(remainder > 5) {
                answer += (10 - remainder)
                temp += 1
            }else if(remainder == 5 && temp%10 >= 5) {
                answer += (10 - remainder)
                temp += 1
            } else answer += remainder
        }

        return answer
    }
}