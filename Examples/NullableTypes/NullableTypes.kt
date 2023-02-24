// NullableTypes/NullableTypes.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
  val s1 = "abc"             // [1]

  // 컴파일 오류
  // val s2: String = null   // [2]

  // 널이 될 수 있는 정의들
  val s3: String? = null     // [3]
  val s4: String? = s1       // [4]

  // 컴파일 오류
  // val s5: String = s4     // [5]
  val s6 = s4                // [6]

  s1 eq "abc"
  s3 eq null
  s4 eq "abc"
  s6 eq "abc"
}
