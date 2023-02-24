// Recursion/Task4.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package recursionExercise4
import atomictest.eq

class City(val name: String) {
  val connections = mutableListOf<City>()

  override fun toString() = "($name, " +
    "connections: ${connections.map { it.name }})"
}

fun addConnection(first: City, second: City) {
  first.connections += second
  second.connections += first
}

fun City.allReachableRecursive(): Set<City> {
  // 주어진 도시에서 도착할 수 있는 모든 도시를 저장한다
  val connections = mutableSetOf<City>()

  // `current` 도시에서 도달할 수 있는
  // 모든 연결을 `connections` 집합에 추가한다
  fun addConnectionsFrom(current: City) {
    if (current in connections) return
    connections += current

    current.connections.forEach {
      addConnectionsFrom(it)
    }
  }

  addConnectionsFrom(this)
  return connections
}

fun City.allReachableIterative(): Set<City> {
  // 주어진 도시에서 도착할 수 있는 모든 도시를 저장한다
  val connections = mutableSetOf<City>()
  // 직접 연결이 되어있는 모든 도시를 분석할 것이다
  val toBeAnalyzed = mutableSetOf(this)

  // 'toBeAnalyzed' 집합에 있는 모든 `current` 도시에 대해:
  // - 도시 마크를 해제한다('toBeAnalyzed' 집합에서 제외)
  // - 현재 도시가 이미 'connections'에 있다면 아무 일도 하지 않는다
  // - 현재 도시를 'connections'에 추가한다
  // - 현재 도시에 연결된 모든 도시를 'toBeAnalyzed'에 추가한다
  while (toBeAnalyzed.isNotEmpty()) {
    val current = toBeAnalyzed.first()

    toBeAnalyzed.remove(current)

    if (current in connections) continue

    connections += current

    current.connections.forEach {
      toBeAnalyzed += it
    }
  }
  return connections
}

fun main() {
  val dublin = City("Dublin")
  val liverpool = City("Liverpool")
  val manchester = City("Manchester")
  val leeds = City("Leeds")

  addConnection(liverpool, manchester)
  addConnection(manchester, leeds)

  liverpool.allReachableRecursive() eq
    setOf(liverpool, manchester, leeds)
  dublin.allReachableRecursive() eq
    setOf(dublin)

  liverpool.allReachableIterative() eq
    setOf(liverpool, manchester, leeds)
  dublin.allReachableIterative() eq
    setOf(dublin)
}
