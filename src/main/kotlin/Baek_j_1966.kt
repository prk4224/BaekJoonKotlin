import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    for(i in 0 until N){

        var str = br.readLine()
        var st = StringTokenizer(str)

        val printSize = st.nextToken().toInt()
        var targetIndex = st.nextToken().toInt()

        str = br.readLine()
        st = StringTokenizer(str)

        var printList = LinkedList<Int>()

        for(i in 0 until printSize){
            printList.add(st.nextToken().toInt())
        }

        var cnt = 0
        while(printList.size > 0){
            var value = printList.pop()

            if(listCheck(printList,value)){
                printList.add(value)
                if(targetIndex > 0) targetIndex--
                else targetIndex = printList.size - 1
            }
            else {
                cnt++
                if(targetIndex == 0) {
                    println(cnt)
                    break
                }
                else targetIndex--
            }
        }
    }
}

fun listCheck(printList : LinkedList<Int>, value : Int) : Boolean {
    printList.forEach {
        if(it > value) return true
    }
    return false
}