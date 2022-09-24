

private lateinit var discountArr : IntArray
fun main(){
    val users = arrayOf(intArrayOf(40,2900),intArrayOf(23,10000),intArrayOf(11,5200),intArrayOf(5,5900),intArrayOf(40,3100),
        intArrayOf(27,9200),intArrayOf(32,6900))

    val emoticons = intArrayOf(1300,1500,1600,4900)

    solution(users,emoticons).forEach { println(it) }
}

fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {

    val member = checkServiceMember(users,emoticons)
    var serviceMember = ArrayList<IntArray>()
    for(i in users.indices){
        if(member[i]) serviceMember.add(users[i])
    }
    fixedDiscount(serviceMember,emoticons)

    return discountArr
}

fun fixedDiscount(serviceMember: ArrayList<IntArray>, emoticons: IntArray){

    var maxDiscount = 0
    var maxValue = 0

    serviceMember.forEach {
        if(it[0] > maxDiscount) maxDiscount = it[0]
        if(it[1] > maxValue)  maxValue = it[1]
    }

    discountArr = IntArray(emoticons.size) {maxDiscount}
    emoticons.sortDescending()

    for(i in emoticons.indices){
        while(!checkStopPoint(maxValue,emoticons)){

            discountArr[i]--
            if(!checkMember(serviceMember,emoticons)){
                discountArr[i]++
                break
            }
        }
    }

}

fun checkStopPoint(maxValue: Int, emoticons: IntArray): Boolean{

    var sum = 0.0
    for(i in emoticons.indices){
        sum += (emoticons[i]*changePercentage(discountArr[i]))
    }

    return sum.toInt() >= maxValue
}

fun checkMember(serviceMember: ArrayList<IntArray>,emoticons: IntArray): Boolean{
    serviceMember.forEach {
        var sum = 0.0

        for(i in emoticons.indices){
            if(it[0] > discountArr[i]) continue
            else {
                sum += emoticons[i]*changePercentage(discountArr[i])
            }
        }
        if(sum < it[1]) return false
    }
    return true
}

fun checkServiceMember(users: Array<IntArray>, emoticons: IntArray) : BooleanArray {

    var total = 0
    emoticons.forEach { total += it }

    var result = BooleanArray(users.size)
    for(i in users.indices){
        val rateDiscount = changePercentage(users[i][0])

        result[i] = users[i][1] <= (total*rateDiscount)
    }
    return result
}

fun changePercentage(value: Int): Float{
    return (100-value).toFloat()/100
}