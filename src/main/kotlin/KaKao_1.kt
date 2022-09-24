import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val str = solution("22.05.19", arrayOf("A 6", "B 12", "C 3"), arrayOf("21.05.02 A","21.07.01 B","22.02.19 C","22.02.20 C"))
    println("${str[0]} ${str[1]}")
}

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    var answer = ArrayList<Int>()
    var idx = 1

    privacies.forEach {
        val st = StringTokenizer(it)
        val collectedDate = st.nextToken()
        val termType = st.nextToken()

        val expiryDate = checkTerms(terms,termType) * 28
        val dateDifference = changeDate(today,collectedDate)

        if(expiryDate <= dateDifference) {
            answer.add(idx)
        }
        idx++
    }
    return answer.toIntArray()
}

fun changeDate(today: String, collectedDay: String): Int {

    var result = 0
    val todayToken = StringTokenizer(today,".")
    val collectedToken = StringTokenizer(collectedDay,".")
    result += (todayToken.nextToken().toInt() - collectedToken.nextToken().toInt()) * 12 * 28
    result += (todayToken.nextToken().toInt() - collectedToken.nextToken().toInt()) * 28
    result += (todayToken.nextToken().toInt() - collectedToken.nextToken().toInt())

    return result
}

fun checkTerms(terms: Array<String>, termType: String): Int {
    terms.forEach {
        val st = StringTokenizer(it)
        val type = st.nextToken()
        val expiryDate = st.nextToken().toInt()
        if(termType == type) return expiryDate
    }
    return 0
}