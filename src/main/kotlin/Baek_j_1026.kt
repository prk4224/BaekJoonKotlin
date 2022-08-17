import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    var firstArr = ArrayList<Int>()
    var secondArr = ArrayList<Int>()

    val firstToken = StringTokenizer(br.readLine())
    val secondToken = StringTokenizer(br.readLine())

    for(i in 0 until N){
        firstArr.add(firstToken.nextToken().toInt())
        secondArr.add(secondToken.nextToken().toInt())
    }

    firstArr.sort()
    secondArr.sortDescending()

    var result = 0
    for(i in 0 until N){
        result += (firstArr[i]*secondArr[i])
    }

    println(result)


}