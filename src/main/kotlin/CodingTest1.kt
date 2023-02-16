import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {

    val capacity = readLine().toDouble()

    if(capacity == 1.0) {
        println("1 1 1")
        return
    }

    var row = capacity.pow(1 / 3.toDouble()).toInt() + 1
    var col = capacity.pow(1 / 3.toDouble()).toInt() + 1
    var hei = capacity.pow(1 / 3.toDouble()).toInt() + 1


    while(true) {
        val total = row * col * hei

        if(total > capacity) {
            if(row < col) {
                col--
            } else {
                row--
            }
        } else if(total < capacity) {
            hei++
            if(row * col * hei < capacity) {
                if(row < col) {
                    row++
                } else {
                    col++
                }
                if(row * col * hei > capacity) {
                    hei--
                }
                break
            }
        } else {
            break
        }
    }

    println("$row $col $hei")
}