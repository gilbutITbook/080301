// Abstract/NoStateInInterfaces.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package abstractclasses

interface IntList {
  val name: String
  // 컴파일 되지 않는다
  // val list = listOf(0)
}
