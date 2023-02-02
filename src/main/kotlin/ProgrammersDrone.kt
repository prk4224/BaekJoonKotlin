import java.util.*
import kotlin.math.abs
import kotlin.math.sqrt

private lateinit var visited : Array<BooleanArray>
private val dx = arrayOf(Pair(1,1),Pair(-1,-1),Pair(0,0),Pair(0,0),Pair(0,-1),Pair(0,1),Pair(0,-1),Pair(0,1),Pair(-1,0),Pair(1,0),Pair(-1,0),Pair(1,0))
private val dy = arrayOf(Pair(0,0),Pair(0,0),Pair(1,1),Pair(-1,-1),Pair(0,-1),Pair(0,1),Pair(0,1),Pair(0,-1),Pair(-1,0),Pair(1,0),Pair(1,0),Pair(-1,0))
private var cnt = Int.MAX_VALUE

fun main() {
    val board = arrayOf(
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 1, 0),
        intArrayOf(0, 1, 0, 1, 1),
        intArrayOf(1, 1, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 0)
    )
    val board2 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 1),
        intArrayOf(1, 1, 1, 1, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 0)
    )

    val board3 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 1),
        intArrayOf(1, 1, 1, 1, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 1, 1, 0),
        intArrayOf(0, 1, 1, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 1, 1),
        intArrayOf(0, 0, 1, 0, 0, 0, 0)
    )

    val board4 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 0),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 1, 1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1),
        intArrayOf(0, 0, 1, 1, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 0)
    )
    val st = StringTokenizer("")
    while(st.hasMoreTokens())

    println(solution(board4))
}

fun solution(board: Array<IntArray>): Int {
    visited = Array(board.size) { BooleanArray(board.size) }
    bfs(board,Drone(Pair(0,0),Pair(1,0),0))
    val answer  = cnt

    return answer
}

fun bfs(board: Array<IntArray>, start: Drone) {
    val N = board.size -1
    val que : Queue<Drone> = LinkedList()
    que.offer(start)

    while(!que.isEmpty()){
        val startDrone = que.poll()
        visited[startDrone.left.second][startDrone.left.first] = true
        visited[startDrone.right.second][startDrone.right.first] = true

        if((startDrone.left.first == N && startDrone.left.second == N) ||
            (startDrone.right.first == N && startDrone.right.second == N)) {
            cnt = cnt.coerceAtMost(startDrone.cnt)
            continue
        }

        for(i in dx.indices) {
            val endLeftX = startDrone.left.first + dx[i].first
            val endRightX = startDrone.right.first + dx[i].second
            val endLeftY =  startDrone.left.second + dy[i].first
            val endRightY =  startDrone.right.second + dy[i].second

            val endDrone = Drone(Pair(endLeftX,endLeftY),Pair(endRightX,endRightY),startDrone.cnt+1)

            if(checkLength(endDrone)){
                continue
            }

            if(endDrone.left.first < 0 || endDrone.left.second < 0 || endDrone.right.first < 0 || endDrone.right.second < 0
                || endDrone.left.first > N || endDrone.left.second > N || endDrone.right.first > N || endDrone.right.second > N) {
                continue
            }

            if(board[endDrone.left.second][endDrone.left.first] == 1 || board[endDrone.right.second][endDrone.right.first] == 1) {
                continue
            }

            if(visited[endDrone.left.second][endDrone.left.first] && visited[endDrone.right.second][endDrone.right.first]) {
                continue
            }

            if(checkPosition(board,startDrone,endDrone)) {
                que.offer(endDrone)
            }
        }
    }
}

fun checkLength(drone: Drone): Boolean {
    val x = abs(drone.left.first - drone.right.first)
    val y = abs(drone.left.second - drone.right.second)

    val leng = sqrt(((x*x) + (y*y)).toFloat())
    return leng != 1.0F

}


fun checkPosition(board: Array<IntArray>,start: Drone, end: Drone): Boolean {
    val maxXList = listOf(start.left.first,start.right.first,end.left.first,end.right.first)
    val maxYList = listOf(start.left.second,start.right.second,end.left.second,end.right.second)

    val maxX = Collections.max(maxXList)
    val minX = Collections.min(maxXList)
    val maxY = Collections.max(maxYList)
    val minY = Collections.min(maxYList)

    when(findSpinType(start,end)) {
        1 -> {
            if(board[maxY][minX] == 1) {
                return false
            }
        }
        2 -> {
            if(board[minY][minX] == 1) {
                return false
            }
        }
        3 -> {
            if(board[maxY][maxX] == 1) {
                return false
            }
        }
        4 -> {
            if(board[minY][maxX] == 1) {
                return false
            }
        }
    }
    return true
}

fun findSpinType(start: Drone, end: Drone): Int {
    val x = (start.left.first+start.right.first) - (end.left.first+end.right.first)
    val y = (start.left.second+start.right.second) - (end.left.second+end.right.second)

    if(x == 0 || y == 0){
        return 0
    }

    return when {
        x+y < 0 -> 1 //x 작은거 y는 큰거
        x+y == 0 -> {
            if(x > 0) 2
            else 3
        }  //x 큰거 y 큰거
        x+y > 0 -> 4  // x 큰거 y 작은거
        else -> 0
    }
}

data class Drone(
    val left: Pair<Int,Int>,
    val right: Pair<Int,Int>,
    val cnt : Int,
)
