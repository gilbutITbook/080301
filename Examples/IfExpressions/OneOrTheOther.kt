// IfExpressions/OneOrTheOther.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

fun oneOrTheOther(exp: Boolean): String =
  if (exp)
    "True!" // 'return'을 쓰지 않아도 된다
  else
    "False"

fun main() {
  val x = 1
  println(oneOrTheOther(x == 1))
  println(oneOrTheOther(x == 2))
}
/* Output:
True!
False
*/
