// UsingOperators/DestructuringMap.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val map = mapOf("a" to 1)
  for ((key, value) in map) {
    key eq "a"
    value eq 1
  }
  // 앞의 구조 분해 대입은 다음과 같다
  for (entry in map) {
    val key = entry.component1()
    val value = entry.component2()
    key eq "a"
    value eq 1
  }
}
