// CreatingClasses/Hamster.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

class Hamster {
  fun speak() = "Squeak! "
  fun exercise() =
    this.speak() +   // 'this'로 한정함
      speak() +      // 'this' 없이 호출함
      "Running on wheel"
}

fun main() {
  val hamster = Hamster()
  println(hamster.exercise())
}
/* Output:
Squeak! Squeak! Running on wheel
*/
