fun main() {


    val orders = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
    val course = intArrayOf(2, 3, 4)
    val temp = MenuRenewal().solution(orders, course)

    temp.forEach {
        println(it)
    }
}

class MenuRenewal {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val result = ArrayList<String>()
        val map = hashMapOf<String, Int>()

        orders.forEach { order ->
            course.forEach { size ->
                val combinations = mutableListOf<String>()
                getCombination(combinations, BooleanArray(order.length) { false }, order, 0, size)
                combinations.forEach {
                    val temp =it.toCharArray()
                    temp.sort()
                    checkedCombination(String(temp),map)
                }
            }
        }

        course.forEach { size ->
            var maxValue = Int.MIN_VALUE
            val maxString = mutableListOf<String>()
            map.forEach { (key, value) ->
                if(value > 1) {
                    if (key.length == size && value > maxValue) {
                        maxValue = value
                        maxString.clear()
                        maxString.add(key)
                    } else if(key.length == size && value == maxValue) {
                        maxString.add(key)
                    }
                }
            }
            if(maxString.size > 0) result.addAll(maxString)
        }


        result.sort()

        return Array(result.size) {
            result[it]
        }
    }

    fun getCombination(
        result: MutableList<String>,
        check: BooleanArray,
        order: String,
        start: Int,
        size: Int,
    ) {
        if (size == 0) {
            val combination = order.filterIndexed { index, c -> check[index] }
            result.add(combination)
        }
        for (i in start until order.length) {
            check[i] = true
            getCombination(result, check, order, i + 1, size - 1)
            check[i] = false
        }
    }

    fun checkedCombination(combination: String, map: HashMap<String,Int>) {
        var resultKey = ""

        run {
            map.forEach { (key) ->
                var cnt = 0
                combination.forEach {
                    if (key.contains(it)) cnt += 1
                }
                if(cnt == combination.length && cnt == key.length) {
                    resultKey = key
                    return@run
                }
            }
        }

        if(resultKey == "") {
            map[combination] = 1
        } else {
            map[resultKey] = map[resultKey]!! + 1
        }
    }
}