
var maxdifference = 0
var resultList = IntArray(11) { init -> 0 }
var checkList = BooleanArray(11) { init -> true }
var comparePoint = 0

fun main(){

    val input = intArrayOf(2,1,1,1,0,0,0,0,0,0,0)
    val input1 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3)
    val input2 = intArrayOf(0,0,1,1,0,0,1,0,0,0,0)
    val input3 = intArrayOf(1,0,0,0,0,0,0,0,0,0,0)

    val n = 5
    val n1 = 10
    val n2 = 3
    val n3 = 1

    resultList = resultList(n2,input2,0)
    maxdifference = getDifference(input2,resultList)


        val temp = resultList(n2,input2,comparePoint)
        val difference = getDifference(input2,temp)
        if(maxdifference<difference){
            resultList = temp
        }

    resultList.forEach {
        print("$it ")
    }

}
// 0,0,1,1,0,0,1,0,0,0,0
// 1,1,2,0,1,1,0,1,1,1,1

//2,1,1,1,0,0,0,0,0,0,0
//0,2,2,0,1,1,1,1,1,1,1

//0,0,1,2,0,1,1,1,1,1,1
//1,1,2,0,1,2,2,2,2,2,2   17 -> 15 ->13 -> 11 -> 9

//0,0,0,0,0,0,0,0,3,4,3
//1,1,1,1,1,1,1,1,4,0,4  16 -> 12
fun checkInput(info: IntArray){
    for(i in 0 until checkList.size-1) {
        if(info[i] > info[i+1]){
            checkList[i] = false
        }
    }
}

fun resultList(n: Int, info: IntArray, point: Int): IntArray {
    var size = n-point
    var list = IntArray(11) { init -> 0 }

    if(point != 0){
        list[point] = info[point]+1
    }

    for(i in checkList.indices){
        if(checkList[i]){
            size -= info[i]+1
            if(size < 0){
                comparePoint = i
                size += info[i]+1
            }else if(size == 0){
                list[i] = info[i]+1
                return list
            } else {
                list[i] = info[i]+1
                continue
            }
        }
    }
    return list
}

fun getDifference(input: IntArray,output: IntArray): Int {
    var inputSum = 0
    var outputSum = 0

    for(i in input.indices){
        if(input[i] < output[i]){
            outputSum += (10-i)
        }
        else if(input[i] >= output[i] && input[i] != 0){
            inputSum += (10-i)
        }
    }
    println(outputSum - inputSum)

    return outputSum - inputSum
}
