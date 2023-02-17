import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    if (N == 1) {
        print(0)
        return
    }
    val primeList = mutableListOf<Int>()
    var primeNum = 2
    var result = 0

    while(true) {
        if(primeNum > N) {
            break
        }
        if(checkPrime(primeNum.toDouble())) {
            primeList.add(primeNum)
        }
        primeNum++
    }

    var start = 0
    var end = 0
    var currentNum = primeList[0]
    // 2 3 5 7 11 13 17 19
    while(start <= end) {
        if(N == currentNum) {
            result++
            currentNum -= primeList[start]
            start++
        } else if (N < currentNum){
            currentNum -= primeList[start]
            start++
        } else {
            end++
            if(end > primeList.size -1) break
            currentNum += primeList[end]
        }
    }

    print(result)
}

fun checkPrime(num: Double): Boolean {
    for(i in 2 ..  sqrt(num).toInt()) {
        if(num.toInt()%i == 0) return false
    }
    return true
}