// DataTypes/Task2.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package dataTypesExercise2

fun main() {
  val int: Int = 10
  val double: Double = 1.1
  val boolean: Boolean = false
  val string: String = "abc"
  val character: Char = 'a'

  // 조합 가능:
  // String은 다른 모든 타입과 조합이 가능하다
  val si: String = string + int
  val sd: String = string + double
  val sb: String = string + boolean
  val sc: String = string + character

  val d1: Double = int + double
  val d2: Double = double + int
  val s1: String = character + string
  val c1: Char = character + int

  println("The type that can be combined " +
    "with every other type using '+':")
  println("String")

  // 조합 불가능:
  // val bb = boolean + boolean
  // val ic = int + character
  // val ds = double + string
}
