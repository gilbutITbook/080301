// Exceptions/Task4.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package exceptionsExercise4

fun foo() {
  throw IllegalStateException("something is wrong")
}

fun bar() {
  foo()
}

fun main() {
  // bar() // 예외 발생을 보려면 이 줄의 주석을 해제할것
}
