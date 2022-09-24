fun main(){
    println(solution(2,7, intArrayOf(1,0,2,0,1,0,2), intArrayOf(0,2,0,1,0,2,0)) )
}

fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
    var answer: Long = 0
    answer = route(deliveries, cap).coerceAtMost(route(pickups, cap))
    return answer
}

fun route(houseList: IntArray, cap: Int) : Long{

    var result = 0L

    while(true){
        var deliveryBoxCnt = 0
        var idx = 0
        var sum = 0

        for(i in houseList.indices){
            deliveryBoxCnt += houseList[i]
            sum += houseList[i]
            if(deliveryBoxCnt == cap) {
                houseList[i] = 0
                result += (i+1)*2
                break
            }
            else if(deliveryBoxCnt < cap) {
                houseList[i] = 0
                idx = i
            }
            else {
                deliveryBoxCnt -= houseList[i]
            }
        }
        if(sum == 0) break
        if(deliveryBoxCnt < cap) result += (idx+1)*2
    }
    return result
}