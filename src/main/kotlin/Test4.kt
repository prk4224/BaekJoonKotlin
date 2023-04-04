fun main() {

    val list = List(10) {
        it
    }

    run {
        list.forEach {
            if(it == 6) return@run
            println(it)
        }
    }

    println(factorial(5))
}

fun sum(a:Int, b:Int): Int {
    return a+b
}

fun sum(a:Double,b:Double): Double {
    return a+b
}

fun factorial(n: Int, result: Int = 1, depth: Int = 1): Int {

    if(n == depth) {
        return result
    }

    return factorial(n,result*(depth+1), depth+1)
}