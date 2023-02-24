// DownCasting/IsKeyword.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import downcasting.*

fun main() {
  val b1: Base = Derived1() // 업캐스트
  if(b1 is Derived1)
    b1.g() // 'is' 검사의 영역 내부
  val b2: Base = Derived2() // 업캐스트
  if(b2 is Derived2)
    b2.h() // 'is' 검사의 영역 내부
}
