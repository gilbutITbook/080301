// Summary2/MultipleListReferences.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val first = mutableListOf(1)
  val second: List<Int> = first
  second eq listOf(1)
  first += 2
  // second에서도 변경된 내용을 볼 수 있다
  second eq listOf(1, 2)
}
