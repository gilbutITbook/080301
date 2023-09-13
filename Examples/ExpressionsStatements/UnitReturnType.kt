// ExpressionsStatements/UnitReturnType.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

fun unitFun() = Unit

fun main() {
  println(unitFun())
  val u1: Unit = println(42)
  println(u1)
  val u2 = println(0) // 타입 추론
  println(u2)
}
/* Output:
kotlin.Unit
42
kotlin.Unit
0
kotlin.Unit
*/
