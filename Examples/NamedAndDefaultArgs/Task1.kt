// NamedAndDefaultArgs/Task1.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package namedAndDefaultArgumentsExercise1

class Rectangle(
  val side1: Double = 1.0,
  val side2: Double = 2.0,
  val color: String = "yellow"
) {
  override fun toString() =
    "$color rectangle $side1 x $side2"
}

fun main() {
  println(Rectangle())

  // 인자 이름 없이 호출
  println(Rectangle(1.1))
  println(Rectangle(1.1, 2.2, "blue"))

  // 위치 기반 인자와 이름 붙인 인자를 혼용
  println(Rectangle(1.1, 2.2, color = "blue"))
  println(Rectangle(side1 = 1.1, side2 = 2.2, "blue"))

  // 모든 인자의 이름을 붙임
  println(Rectangle(color = "blue"))
  println(Rectangle(side1 = 1.1, side2 = 2.2, color = "blue"))
}
