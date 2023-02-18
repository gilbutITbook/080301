// UsingOperators/Unexpected.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  var list = listOf(1, 2)
  list += 3  // 어쩌면 예상과 다를 수 있음
  list eq "[1, 2, 3]"
}
