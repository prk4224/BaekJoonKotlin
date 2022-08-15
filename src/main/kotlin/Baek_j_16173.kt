import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Check(var num : Int, var check: Boolean)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    var firstCheck = Check(0,false)
    var secondCheck = firstCheck

    for(i in 0 until N){
        val temp = br.readLine()
        val st = StringTokenizer(temp)

        while(st.hasMoreTokens()){
            val input = st.nextToken().toInt()
            if(st.countTokens() == 0 || i == N-1){

                if(input == st.countTokens()+(N-i-1))
                else {

                }
            }
        }
    }
    print("Hing")
}