// interoperability/JavaList.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val list = listOf(1, 2, 3)
  (list is java.util.List<*>) eq true
}
