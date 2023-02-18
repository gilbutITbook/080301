// PropertyAccessors/Data.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package propertyaccessors
import atomictest.eq

class Data(var i: Int)

fun main() {
  val data = Data(10)
  data.i eq 10 // 'i' 프로퍼티를 읽음
  data.i = 20  // 'i' 프로퍼티에 값을 씀
}
