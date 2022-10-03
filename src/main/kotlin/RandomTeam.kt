import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


// 팀원 수, 그룹 수, 멤버 수, 기간 ?
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())

    val teamMember = st.nextToken().toInt()
    val groupCount = st.nextToken().toInt()
    val totalMember = st.nextToken().toInt()
    val totalWeek = st.nextToken().toInt()
    var checkMember = Array(totalMember){BooleanArray(totalMember)}



    var resultMember = ArrayList<ArrayList<Int>>()
    

    print(checkMember[1][2])

}

fun randomFirstMember(groupList: ArrayList<IntArray>, totalMember: Int){
    val member = arrayOf(1..totalMember)
    member.shuffle()

    for(i in 0 until groupList.size){
        groupList[i][0] = (member as Array<Int>)[i]
    }

}

