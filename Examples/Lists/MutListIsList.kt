// Lists/MutListIsList.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package lists
import atomictest.eq

fun getList(): List<Int> =
  mutableListOf(1, 2, 3)

fun main() {
  // getList()는 읽기 전용 List를 만든다
  val list = getList()
  // list.add(3) // Unresolved reference: add
  list eq listOf(1, 2, 3)
}
