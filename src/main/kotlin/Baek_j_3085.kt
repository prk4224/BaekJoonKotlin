//import java.util.*
//
//private val map = Array(21) { IntArray(21) }
//val checkedMap =  Array(21) { Array(21) { IntArray(4)} }
//val dx = listOf(1,0,1,-1)
//val dy = listOf(0,1,1,1)
//
//fun main() = with(System.`in`.bufferedReader()) {
//
//
//    val coordiList = mutableListOf<Pair<Int,Int>>()
//    val tmemp = Array(4) {item -> dx[item]}
//    val tmep = tmemp.minOf { it }
//
//    print(tmep)
//
//    for(i in 1 .. 19) {
//        val str = readLine().split(" ").map { it.toInt() }
//        for(j in 1 .. 19) {
//            if(str[j-1] != 0) {
//                coordiList.add(Pair(i,j))
//            }
//            map[i][j] = str[j-1]
//        }
//    }
//
//    coordiList.forEach {
//        for(k in 0 .. 3){
//            val x = it.first
//            val y = it.second
//            if(checkedMap[x][y][k] == 0 && checkedWinner(x,y,k,map[x][y]) == 5) {
//                print("${map[x][y]}\n$x $y")
//                return
//            }
//        }
//    }
//
//    print(0)
//}
//
//fun checkedWinner(x: Int, y:Int, dir: Int, color: Int) : Int {
//    val nx = x + dx[dir]
//    val ny = y + dy[dir]
//
//    return if(map[nx][ny] == color) {
//        checkedWinner(nx,ny,dir,color) + 1.also { checkedMap[nx][ny][dir] = it }
//    } else 1
//}