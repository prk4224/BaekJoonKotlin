import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine()

    var oneCnt = 0
    var oneCheck = false
    var zeroCnt = 0
    var zeroCheck = false

    input.forEach {
        if(it == '1' && !oneCheck) {
            oneCheck = true
            zeroCheck = false
            oneCnt++
        }
        if(it == '0' && !zeroCheck){
            oneCheck = false
            zeroCheck = true
            zeroCnt++
        }
    }
    print(Math.min(oneCnt,zeroCnt))
}