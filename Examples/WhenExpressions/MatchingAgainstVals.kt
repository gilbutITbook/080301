// WhenExpressions/MatchingAgainstVals.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.*

fun main() {
  val yes = "A"
  val no = "B"
  for (choice in listOf(yes, no, yes)) {
    when (choice) {
      yes -> trace("Hooray!")
      no -> trace("Too bad!")
    }
    // 'if'로 같은 로직을 표현한다
    if (choice == yes) trace("Hooray!")
    else if (choice == no) trace("Too bad!")
  }
  trace eq """
    Hooray!
    Hooray!
    Too bad!
    Too bad!
    Hooray!
    Hooray!
  """
}
