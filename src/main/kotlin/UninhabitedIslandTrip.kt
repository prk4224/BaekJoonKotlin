class UninhabitedIslandTrip {
    var result = 0
    var cnt = IntArray(10001) { 0 }
    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        val intMap = Array(maps.size) { col ->
            IntArray(maps[col].length) { row ->
                if(maps[col][row] == 'X') 0
                else maps[col][row] - '0'
            }
        }

        for(i in 0 until intMap.size){
            for(j in 0 until intMap[i].size) {
                if(dfs(i,j,intMap)) {
                    result += 1
                }
            }
        }
        val result = cnt.sliceArray(0 until result)
        result.sort()

        return result
    }

    fun dfs(
        x:Int,
        y:Int,
        map: Array<IntArray>
    ): Boolean {
        if(x < 0 || y < 0 || x >= map.size || y >= map[x].size ) {
            return false
        }

        if(map[x][y] > 0) {
            cnt[result] += map[x][y]
            map[x][y] = 0

            dfs(x+1,y,map)
            dfs(x-1,y,map)
            dfs(x,y+1,map)
            dfs(x,y-1,map)
            return true
        }

        return false
    }
}