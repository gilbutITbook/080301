// NestedClasses/Airport.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package nestedclasses
import atomictest.eq
import nestedclasses.Airport.Plane

class Airport(private val code: String) {
  open class Plane {
    // 자신을 둘러싼 클래스의 private 프로퍼티에 접근할 수 있다
    fun contact(airport: Airport) =
      "Contacting ${airport.code}"
  }
  private class PrivatePlane : Plane()
  fun privatePlane(): Plane = PrivatePlane()
}

fun main() {
  val denver = Airport("DEN")
  var plane = Plane()                   // [1]
  plane.contact(denver) eq "Contacting DEN"
  // 다음과 같이 할 수 없다
  // val privatePlane = Airport.PrivatePlane()
  val frankfurt = Airport("FRA")
  plane = frankfurt.privatePlane()
  // 다음과 같이 할 수 없다
  // val p = plane as PrivatePlane      // [2]
  plane.contact(frankfurt) eq "Contacting FRA"
}
