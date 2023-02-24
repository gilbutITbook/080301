// Abstract/NoMultipleInheritance.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package multipleinheritance1

open class Animal
open class Mammal : Animal()
open class AquaticAnimal : Animal()

// 기반 클래스가 둘 이상이면 컴파일이 되지 않는다
// class Dolphin : Mammal(), AquaticAnimal()
