import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    var aCnt = 1
    var bCnt = 0

    for( i in 0 until N){
        val temp = aCnt
        aCnt = bCnt
        bCnt += temp
    }

    println("$aCnt $bCnt")

}