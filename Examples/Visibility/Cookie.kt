// Visibility/Cookie.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

class Cookie(
  private var isReady: Boolean  // [1]
) {
  private fun crumble() =       // [2]
    println("crumble")

  public fun bite() =           // [3]
    println("bite")

  fun eat() {                   // [4]
    isReady = true              // [5]
    crumble()
    bite()
  }
}

fun main() {
  val x = Cookie(false)
  x.bite()
  // private 멤버에 접근할 수 없다
  // x.isReady
  // x.crumble()
  x.eat()
}
/* Output:
bite
crumble
bite
*/
