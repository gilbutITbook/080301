// UsingOperators/OperatorPlus.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val mutableList = mutableListOf(1, 2, 3)
  mutableList += 4  // operator plusAssign()
  mutableList.plusAssign(5) // 명시적 호출
  mutableList eq "[1, 2, 3, 4, 5]"
  mutableList + 99 eq "[1, 2, 3, 4, 5, 99]"
  mutableList eq "[1, 2, 3, 4, 5]"
  val list = listOf(1)  // 읽기 전용 컬렉션
  val newList = list + 2  // operator plus()
  list eq "[1]"
  newList eq "[1, 2]"
  val another = list.plus(3)  // 명시적 호출
  another eq "[1, 3]"
}
