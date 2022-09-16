import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private val dx = listOf(1,0,1)
private val dy = listOf(0,1,1)

private var N  = 0
private var result = 0
private val inputMap = ArrayList<ArrayList<Int>>()

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()
    result = 0

    for(i in 0 until N){
        val temp = br.readLine()
        val st = StringTokenizer(temp)
        var tempList = ArrayList<Int>()
        for(j in 0 until N){
            tempList.add(st.nextToken().toInt())
        }
        inputMap.add(tempList)
    }
    bfs()

    println(result)

}

fun bfs() {

    var que = LinkedList<PipeInfo>()
    que.offer(PipeInfo(1,0,PipeState.HORIZONTAL))

    while(!que.isEmpty()) {
        val pipeInfo = que.pop()
        for (i in 0..2) {
            when(pipeInfo.state){
                PipeState.HORIZONTAL -> if(i == 1) continue
                PipeState.VERTICAL -> if(i == 0) continue
            }
            val nx = pipeInfo.col + dx[i]
            val ny = pipeInfo.row + dy[i]

            if (nx == N - 1 && ny == N - 1) result++

            when(i){
                0 -> {
                    if (nx >= N || ny >= N || inputMap[nx][ny] != 0) continue
                    que.offer(PipeInfo(nx, ny,PipeState.HORIZONTAL))
                }
                1 -> {
                    if (nx >= N || ny >= N || inputMap[nx][ny] != 0) continue
                    que.offer(PipeInfo(nx, ny,PipeState.VERTICAL))
                }
                2 -> {
                    if (nx >= N || ny >= N || inputMap[nx][ny] != 0 || inputMap[nx - 1][ny] != 0 || inputMap[nx][ny - 1] != 0) continue
                    que.offer(PipeInfo(nx, ny, PipeState.DIAGONAL))
                }
            }
        }
    }

}

data class PipeInfo(var col : Int, var row : Int, var state: PipeState)
enum class PipeState {HORIZONTAL, VERTICAL, DIAGONAL}