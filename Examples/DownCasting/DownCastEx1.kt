// DownCasting/DownCastEx1.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package downcastingExercise1
import atomictest.*

interface Base {
  fun f()
}

class Derived1 : Base {
  override fun f() = trace("Derived1.f()")
  fun g() = trace("Derived1.g()")
}

class Derived2 : Base {
  override fun f() = trace("Derived2.f()")
  fun h() = trace("Derived2.h()")
}

fun checkAndCall(b: Base) {
  b.f() // 다형적 호출
  when(b) {
    is Derived1 -> b.g()
    is Derived2 -> b.h()
  }
}

fun main() {
  checkAndCall(Derived1()) // 업캐스트
  checkAndCall(Derived2()) // 업캐스트
  trace eq """
    Derived1.f()
    Derived1.g()
    Derived2.f()
    Derived2.h()
  """
}
