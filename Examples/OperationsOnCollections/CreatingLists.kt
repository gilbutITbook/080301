// OperationsOnCollections/CreatingLists.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  // 람다는 인자로 추가할 원소의 인덱스를 받는다
  val list1 = List(10) { it }
  list1 eq "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"

  // 한 값으로만 이뤄진 리스트
  val list2 = List(10) { 0 }
  list2 eq "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]"

  // 글자로 이뤄진 리스트
  val list3 = List(10) { 'a' + it }
  list3 eq "[a, b, c, d, e, f, g, h, i, j]"

  // 정해진 순서를 반복
  val list4 = List(10) { list3[it % 3] }
  list4 eq "[a, b, c, a, b, c, a, b, c, a]"
}
