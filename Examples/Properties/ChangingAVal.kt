// Properties/ChangingAVal.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

class House {
  var sofa: String = ""
}

fun main() {
  val house = House()
  house.sofa = "Simple sleeper sofa: $89.00"
  println(house.sofa)
  house.sofa = "New leather sofa: $3,099.00"
  println(house.sofa)
  // val에 새 House를 대입할 수 없다
  // house = House()
}
/* Output:
Simple sleeper sofa: $89.00
New leather sofa: $3,099.00
*/
