// ExceptionHandling/LibraryException.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package exceptionhandling
import atomictest.*

fun testCode(code: Int) {
  if (code <= 1000) {
    throw IllegalArgumentException(
      "'code' must be > 1000: $code")
  }
}

fun main() {
  try {
    // A1은 16진수 표기로 161이다
    testCode("A1".toInt(16))
  } catch (e: IllegalArgumentException) {
    e.message eq
      "'code' must be > 1000: 161"
  }
  try {
    testCode("0".toInt(1))
  } catch (e: IllegalArgumentException) {
    e.message eq
      "radix 1 was not in valid range 2..36"
  }
}
