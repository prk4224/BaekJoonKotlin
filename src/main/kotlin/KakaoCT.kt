
import java.util.*
import kotlin.collections.HashMap

var map = HashMap<String,Int>()
fun main() {

    val customer = arrayOf("A B C D", "A D", "A B D", "B D")
    val start = "2020:12:30:23:59:59"
    val times = arrayOf("00:01:12:00")
    val result = solution(start, times)
    println("${result[0]}/${result[1]}")
}

fun solution(s: String, times: Array<String>): IntArray {

    var checkEveryday = 1
    var sumDay = 1
    var currentDate = changeStringToDate(s)


    times.forEach {
        val plusTime = changeStringToDate(it)
        val nextDate = plusDate(plusTime,currentDate)
        val diffDay = nextDate.day - currentDate.day
        sumDay += diffDay
        if(diffDay > 1) {
            checkEveryday = 0
        }
        currentDate = nextDate
    }

    return intArrayOf(checkEveryday,sumDay)
}

fun changeStringToDate(stringDate: String): MyDate {
    val st = StringTokenizer(stringDate,":")

    if(st.countTokens() == 6) {
        st.nextToken()
        st.nextToken()
    }

    var resultDate = MyDate()

    for(i in 0 .. 3){
        when(i) {
            0 -> resultDate.day = st.nextToken().toInt()
            1 -> resultDate.hour = st.nextToken().toInt()
            2 -> resultDate.minute = st.nextToken().toInt()
            3 -> resultDate.second = st.nextToken().toInt()
        }
    }
    return resultDate
}

fun plusDate(plusTime: MyDate, currentDate: MyDate): MyDate {

    var resultDate = currentDate.copy()
    for(i in 0 .. 3){
        when(i) {
            0 -> {
                resultDate.second += plusTime.second
                if(resultDate.second > 59) {
                    resultDate.minute++
                    resultDate.second -= 60
                }
            }
            1 -> {
                resultDate.minute += plusTime.minute
                if(resultDate.minute > 59) {
                    resultDate.hour++
                    resultDate.minute -= 60
                }

            }
            2 -> {
                resultDate.hour += plusTime.hour
                if(resultDate.hour > 23) {
                    resultDate.day++
                    resultDate.hour -= 24
                }

            }
            3 -> {
                resultDate.day += plusTime.day
            }
        }
    }
    return resultDate
}

data class MyDate(
    var day: Int = 0,
    var hour: Int = 0,
    var minute: Int = 0,
    var second: Int= 0
)

fun solution1(id_list: Array<String>, k: Int): Int {
    var answer = 0

    id_list.forEach {
        val st = StringTokenizer(it)
        var checkToday = ArrayList<String>()
        while(st.hasMoreTokens()){
            val customer = st.nextToken()
            if(checkToday.contains(customer)){
                continue
            } else {
                checkToday.add(customer)
            }

            if(map.containsKey(customer)){
                var cnt = map[customer]
                if(cnt!= null && cnt < k){
                    cnt++
                    answer++
                    map.replace(customer,cnt)
                }
            } else {
                map[customer] = 1
                answer++
            }
        }
    }
    return answer
}