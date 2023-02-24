// ClassDelegation/ExplicitDelegation.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package classdelegation
import atomictest.eq

class ExplicitControls : Controls {
  private val controls = SpaceShipControls()
  // 수동으로 위임 구현하기
  override fun up(velocity: Int) =
    controls.up(velocity)
  override fun back(velocity: Int) =
    controls.back(velocity)
  override fun down(velocity: Int) =
    controls.down(velocity)
  override fun forward(velocity: Int) =
    controls.forward(velocity)
  override fun left(velocity: Int) =
    controls.left(velocity)
  override fun right(velocity: Int) =
    controls.right(velocity)
  // 변형한 구현
  override fun turboBoost(): String =
    controls.turboBoost() + "... boooooost!"
}

fun main() {
  val controls = ExplicitControls()
  controls.forward(100) eq "forward 100"
  controls.turboBoost() eq
    "turbo boost... boooooost!"
}
