// CreatingClasses/Animals.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

// class들을 정의한다
class Giraffe
class Bear
class Hippo

fun main() {
  // 객체를 만든다
  val g1 = Giraffe()
  val g2 = Giraffe()
  val b = Bear()
  val h = Hippo()

  // Giraffe(), Bear()처럼 클래스이름()을 호출해 만든 객체는 각각 고유한 정체성을 가진다
  println(g1)
  println(g2)
  println(h)
  println(b)
}
/* Sample output:
Giraffe@28d93b30
Giraffe@1b6d3586
Hippo@4554617c
Bear@74a14482
*/
