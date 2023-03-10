// OperatorOverloading/MemberOperator.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package operatoroverloading
import atomictest.eq

data class Num2(private val n: Int) {
  operator fun plus(rval: Num2) =
    Num2(n + rval.n)
}

// Cannot access 'n': it is private in 'Num2'라는 오류가 발생한다
// 이 오류는 ''n'에 접근할 수 없음: 'n'은 'Num2'에서 비공개(private)임'이라는 뜻이다
// operator fun Num2.minus(rval: Num2) =
//   Num2(n - rval.n)

fun main() {
  Num2(4) + Num2(5) eq Num2(9)
}
