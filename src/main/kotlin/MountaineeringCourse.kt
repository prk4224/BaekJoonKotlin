import java.util.*
import kotlin.collections.ArrayList

// https://tech.kakao.com/2022/07/13/2022-coding-test-summer-internship/

private lateinit var graph: ArrayList<ArrayList<Node>>
fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
    graph = ArrayList()
    for (i in 0 until n + 1) {
        graph.add(ArrayList())
    }
    for (path in paths) {
        val s = path[0]
        val e = path[1]
        val w = path[2]

        // 출입구일 경우 다른 곳으로만 갈 수 있는 단방향
        // 산봉우리일 경우 특정 한 곳에서 산봉우리로 가는 단방향
        if (isGate(s, gates) || isSummit(e, summits)) {
            graph[s].add(Node(e, w))
        } else if (isGate(e, gates) || isSummit(s, summits)) {
            graph[e].add(Node(s, w))
        } else {
            // 일반 등산로일 경우 양방향
            graph[s].add(Node(e, w))
            graph[e].add(Node(s, w))
        }
    }

    // 정상까지 갔을 때 최소이면 돌아올 때도 같은 경로를 선택하면 되므로
    // 정상까지 가는 경우만 고려
    return dijkstra(n, gates, summits)
}

private fun dijkstra(n: Int, gates: IntArray, summits: IntArray): IntArray {
    val qu: Queue<Node> = LinkedList()
    val intensity = IntArray(n + 1)
    Arrays.fill(intensity, Int.MAX_VALUE)

    // 출입구 전부를 큐에 넣음
    for (gate in gates) {
        qu.add(Node(gate, 0))
        intensity[gate] = 0 // 시작 지점은 0
    }
    while (!qu.isEmpty()) {
        val cn = qu.poll()

        // 현재의 가중치가 저장된 가중치보다 커서 최소 갱신이 되지 않을 때 스킵
        if (cn.w > intensity[cn.e]) continue
        for (i in graph[cn.e].indices) {
            val nn = graph[cn.e][i]

            // 최소 갱신
            val dis = Math.max(intensity[cn.e], nn.w)
            if (intensity[nn.e] > dis) {
                intensity[nn.e] = dis
                qu.add(Node(nn.e, dis))
            }
        }
    }
    var mn = Int.MAX_VALUE // 산봉우리 번호
    var mw = Int.MAX_VALUE // 최솟값

    // 정렬하지 않으면 12, 14, 15, 16, 17, 25번 문제 실패
    Arrays.sort(summits)
    for (summit in summits) {
        if (intensity[summit] < mw) {
            mn = summit
            mw = intensity[summit]
        }
    }
    return intArrayOf(mn, mw)
}

// num이 입구인지 확인
private fun isGate(num: Int, gates: IntArray): Boolean {
    for (gate in gates) {
        if (num == gate) return true
    }
    return false
}

// num이 산봉우리인지 확인
private fun isSummit(num: Int, submits: IntArray): Boolean {
    for (submit in submits) {
        if (num == submit) return true
    }
    return false
}

private class Node internal constructor(
    var e: Int, // 노드, 가중치
    var w: Int
)
