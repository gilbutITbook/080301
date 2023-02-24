// Summary2/ReadonlyVsMutableList.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.*

fun main() {
  val ints = listOf(5, 13, 9)
  // ints.add(11) // ints에 add()가 없다
  for (i in ints) {
    if (i > 10) {
      trace(i)
    }
  }
  val chars = mutableListOf('a', 'b', 'c')
  chars.add('d') // chars에 add()가 있다
  chars += 'e'
  trace(chars)
  trace eq """
    13
    [a, b, c, d, e]
  """
}
