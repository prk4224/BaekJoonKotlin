import java.util.Stack

class FindMaxNumber {
    fun solution(numbers: IntArray): IntArray {
        val stack = Stack<Int>()
        var idx = 0

        while (idx < numbers.size) {
            if(stack.empty().not()) {
                val temp = stack.pop()
                if(numbers[temp] < numbers[idx]) {
                    numbers[temp] = numbers[idx]
                } else {
                    stack.add(temp)
                    stack.add(idx)
                    idx += 1
                }
            } else {
                stack.add(idx)
                idx += 1
            }
        }

        while (stack.empty().not()) {
            numbers[stack.pop()] = -1
        }


        return numbers
    }
}