//import java.util.*
//
//fun main(){
//
//    val str = "...!@BaT#*..y.abcdefghijklm"
//    val str1 = "z-+.^."
//    val str2 = "=.="
//    val str3 = "123_.def"
//    val str4 = "abcdefghijklmn.p"
//
//    println(solution(str))
//    println(solution(str1))
//    println(solution(str2))
//    println(solution(str3))
//    println(solution(str4))
//}
//
//// 예외상황 ?
//fun solution(new_id: String): String {
//
//    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//    var answer: String = new_id.lowercase()
//
//    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//    val reg = "[0-9a-z._-]+".toRegex()
//    var tamp = ""
//
//    reg.findAll(answer).forEach { tamp += it.value }
//    answer = tamp
//
//    //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//    var i = 0
//    while(i < answer.length-2) {
//        if(answer[i] == '.' && answer[i+1] == '.') {
//            answer = answer.substring(0,i) + answer.substring(i+1)
//            i == 0
//        }
//        else i++
//    }
//
//    //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//    if(answer[0] == '.') answer = answer.substring(1)
//    if(answer.length > 0 && answer[answer.length-1] == '.') answer = answer.substring(0,answer.length-2)
//
//
//    //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//    if(answer.isEmpty()) answer = "a"
//
//    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//    if(answer.length > 15) answer = answer.substring(0,15)
//    if(answer[answer.length-1] == '.') answer = answer.substring(0,answer.length-1)
//
//    //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
//    if(answer.length <= 2) {
//        while(answer.length <= 2) {
//            answer += answer[answer.length-1]
//        }
//    }
//
//    return answer
//}
//
//
//
//
//
//
//
