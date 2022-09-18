import java.util.*
import kotlin.math.sqrt

fun main(){

    println(solution(437674,3))
    println(solution(110011,10))
}

fun solution(n: Int, k: Int): Int {
    var answer = 0
    var current = n

    var sb = StringBuilder()

    while(current > 0 && k != 10) {
        sb.append(current % k)
        current /= k
    }

    if( k != 10) sb.reverse()
    else sb.append(current)

    val st = StringTokenizer(sb.toString(),"0")

    while(st.hasMoreTokens()){
        val num = st.nextToken().toLong()
        if(checkedPrime(num) && num != 1L) answer++
    }

    return answer
}

fun checkedPrime(x: Long): Boolean {
    var i = 2
    while (i <= sqrt(x.toDouble())) {
        if (x % i == 0L) return false
        i++
    }
    return true
}