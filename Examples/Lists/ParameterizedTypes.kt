// Lists/ParameterizedTypes.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  // 타입을 추론한다
  val numbers = listOf(1, 2, 3)
  val strings =
    listOf("one", "two", "three")
  // 똑같은 코드지만 타입을 명시했다
  val numbers2: List<Int> = listOf(1, 2, 3)
  val strings2: List<String> =
    listOf("one", "two", "three")
  numbers eq numbers2
  strings eq strings2
}
