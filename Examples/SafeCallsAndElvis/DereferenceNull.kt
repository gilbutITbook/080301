// SafeCallsAndElvis/DereferenceNull.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

fun main() {
  val s: String? = null
  // 컴파일 되지 않는다
  // s.length        // [1]
}
