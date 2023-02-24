// DownCasting/NarrowingUpcast.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package downcasting

interface Base {
  fun f()
}

class Derived1 : Base {
  override fun f() {}
  fun g() {}
}

class Derived2 : Base {
  override fun f() {}
  fun h() {}
}

fun main() {
  val b1: Base = Derived1() // 업캐스트
  b1.f()    // 기반 클래스의 일부분
  // b1.g() // 기반 클래스에 들어 있지 않음
  val b2: Base = Derived2() // 업캐스트
  b2.f()    // 기반 클래스의 일부분
  // b2.h() // 기반 클래스에 들어 있지 않음
}
