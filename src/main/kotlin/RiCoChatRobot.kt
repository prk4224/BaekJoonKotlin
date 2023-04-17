import java.util.*


fun main() {

    val arr = arrayOf(
        "...D..R",
        ".D.G...",
        "....D.D",
        "D....D.",
        "..D...."
    )
    println(RiCoChatRobot().solution(arr))
}
class RiCoChatRobot {
    //아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽

    val vector = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    var result = Int.MAX_VALUE

    fun solution(board: Array<String>): Int {
        var strat = Node(-1,-1,0,vector)

        val map = Array(board.size) { items ->
            CharArray(board[items].length) { item ->
                val char = board[items][item]
                if(char == 'R') strat = Node(items, item,0,vector)
                char
            }
        }

        val cntMap = Array(board.size) {
            IntArray(board[it].length) { -1 }
        }

        bfs(strat,map,cntMap)

        return if(result == Int.MAX_VALUE) -1 else result
    }

    fun bfs(
        start: Node,
        map: Array<CharArray>,
        cntMap: Array<IntArray>,
    ) {
        val queue = LinkedList<Node>()
        queue.offer(start)

        while(queue.isNotEmpty()) {
            val item = queue.pop()


            for(i in 0 until item.vector.size) {
                val nx = item.x + item.vector[i].first
                val ny = item.y + item.vector[i].second

                if(nx < 0 || ny < 0 || nx >= map.size || ny >= map[nx].size || map[nx][ny] == 'D') {

                    if(cntMap[item.x][item.y] == -1) {
                        cntMap[item.x][item.y] = item.cnt + 1
                        queue.offer(Node(item.x,item.y,item.cnt + 1,vector))
                    } else if(cntMap[item.x][item.y] > item.cnt) {
                        cntMap[item.x][item.y] = item.cnt
                    }

                    if(map[item.x][item.y] == 'G') {
                        result = item.cnt + 1
                        return
                    }
                    continue

                }

                if(map[nx][ny] == '.' || map[nx][ny] == 'G' ){
                    queue.offer(Node(nx,ny,item.cnt, arrayOf(item.vector[i])))
                }
            }
        }
    }
    data class Node(
        val x: Int,
        val y: Int,
        var cnt: Int,
        val vector: Array<Pair<Int, Int>>,
    )
}

