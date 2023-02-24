// interoperability/ReadOnlyCollections.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val mutable = mutableListOf(1, 2, 3)
  // 가변 리스트에 대한 읽기 전용 참조
  val list: List<Int> = mutable
  mutable += 4
  // list 내부가 달라졌다
  list eq "[1, 2, 3, 4]"
}
