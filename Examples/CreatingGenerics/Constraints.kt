// CreatingGenerics/Constraints.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package creatinggenerics
import kotlin.random.Random

private val rnd = Random(47)

// action()에 접근할 수 있지만 정확한 타입을 반환할 수 없다
fun List<Disposable>.inexact(): Disposable {
  val d: Disposable = this[rnd.nextInt(size)]
  d.action()
  return d
}

// 제약이 없어서 action()에 접근할 수 없다
fun <T> List<T>.noAccess(): T {
  val d: T = this[rnd.nextInt(size)]
  // d.action()
  return d
}

// action()에 접근하고 정확한 타입을 반환한다
fun <T: Disposable> List<T>.both(): T {
  val d: T = this[rnd.nextInt(size)]
  d.action()
  return d
}

fun constraints() {
  val i: Disposable = recyclables.inexact()
  val n: Recyclable = recyclables.noAccess()
  val b: Recyclable = recyclables.both()
}
