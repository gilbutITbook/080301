// SecondaryConstructors/WithSecondary.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package secondaryconstructors
import atomictest.*

class WithSecondary(i: Int) {
  init {
    trace("Primary: $i")
  }
  constructor(c: Char) : this(c - 'A') {
    trace("Secondary: '$c'")
  }
  constructor(s: String) :
    this(s.first()) {             // [1]
    trace("Secondary: \"$s\"")
  }
  /* 주생성자를 호출하지 않으면
     컴파일이 되지 않는다
  constructor(f: Float) {         // [2]
    trace("Secondary: $f")
  }
  */
}

fun main() {
  fun sep() = trace("-".repeat(10))
  WithSecondary(1)
  sep()
  WithSecondary('D')
  sep()
  WithSecondary("Last Constructor")
  trace eq """
    Primary: 1
    ----------
    Primary: 3
    Secondary: 'D'
    ----------
    Primary: 11
    Secondary: 'L'
    Secondary: "Last Constructor"
  """
}
