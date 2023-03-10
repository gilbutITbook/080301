// ExtensionLambdas/ExtensionPolymorphism.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package extensionlambdas
import atomictest.eq

open class Base {
  open fun f() = 1
}

class Derived : Base() {
  override fun f() = 99
}

fun Base.g() = f()

fun Base.h(xl: Base.() -> Int) = xl()

fun main() {
  val b: Base = Derived() // 업캐스트
  b.g() eq 99
  b.h { f() } eq 99
}
