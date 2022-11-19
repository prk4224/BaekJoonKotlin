
val total = 0

fun main(){

}

fun sumPoint(start: Int, n: Int, info: IntArray): Int{
    var result = 0
    var size = n
    for(i in start .. info.size){

        if(size == 0){
            break
        }

        if(size < 0){
            size += (info[i]+1)
            continue
        }
        result += (10+i)
    }
}