// CreatingGenerics/CovariantList.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package variance

fun main() {
  val catList: List<Cat> = listOf(Cat())
  val petList: List<Pet> = catList
  var mutablePetList: MutableList<Pet> =
    mutableListOf(Cat())
  mutablePetList.add(Dog())
  // 타입 불일치(type mismatch)
  // mutablePetList =
  //    mutableListOf<Cat>(Cat())  // [1]
}
