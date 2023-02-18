// NumberTypes/LongConstants.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

fun main() {
  val i = 0          // Int 타입을 추론
  val l1 = 0L        // L을 사용해 Long 타입으로
  val l2: Long = 0   // 명시적으로 타입 지정
  println("$l1 $l2")
}
/* Output:
0 0
*/
