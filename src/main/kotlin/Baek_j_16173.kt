import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

data class Map(var col : Int, var row : Int)

fun main() {

    val dx = arrayOf(1,0)
    val dy = arrayOf(0,1)

    val br = BufferedReader(InputStreamReader(System.`in`))

    val num = br.readLine().toInt()
    val inputMap = ArrayList<ArrayList<Int>>()


    for(i in 0 until num){
        val str = br.readLine()
        val st = StringTokenizer(str)
        var temp = ArrayList<Int>()

        while(st.hasMoreTokens()){
            val input = st.nextToken().toInt()
            println(input)
            temp.add(input)
        }
        inputMap.add(temp)
    }

    // BFS
    val que : Queue<Map> = LinkedList()
    que.offer(Map(0,0))

    while(!que.isEmpty()){
        val curr = que.poll()

        if(inputMap[curr.col][curr.row] == -1) {
            println("HaruHaru")
            return
        }

        if(inputMap[curr.col][curr.row] == 0) continue

        for(i in 0 .. 1){
            var nx = curr.col + (dx[i]*inputMap[curr.col][curr.row])
            var ny = curr.row + (dy[i]*inputMap[curr.col][curr.row])

            if(nx >= 0 && ny >= 0 && nx < num && ny < num) que.offer(Map(nx,ny))
        }
    }
    print("Hing")
}
