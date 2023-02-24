// Lists/MultipleListRefs.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val first = mutableListOf(1)
  val second: List<Int> = first
  second eq listOf(1)
  first.add(2)
  // second도 first에 의해 변경된 내용을 보게 된다
  second eq listOf(1, 2)
}
