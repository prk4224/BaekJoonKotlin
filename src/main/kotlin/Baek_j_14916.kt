import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()
    var cnt = 0

    if(N == 1 || N == 3) {
        println(-1)
        return
    }

    cnt += N/5
    N %= 5

    if(N == 1 || N == 3) {
        N += 5
        cnt--
    }

    cnt += N/2

    println(cnt)
}