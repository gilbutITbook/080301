// Lists/PlusAssignPuzzle.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import atomictest.eq

fun main() {
    // 'val'/'var'에 가변 리스트를 대입하는 경우:
    val list1 = mutableListOf('A') // or 'var'
    list1 += 'A' // 다음 줄과 같다:
    list1.plusAssign('A')               // [1]

    // 'val'에 불변 리스트를 대입하는 경우:
    val list2 = listOf('B')
    // list2 += 'B' // 다음 줄과 같다:
    // list2 = list2 + 'B'              // [2]

    // 'var'에 불변 리스트를 대입하는 경우:
    var list3 = listOf('C')
    list3 += 'C' // 다음 줄과 같다:
    val newList = list3 + 'C'           // [3]
    list3 = newList                     // [4]

    list1 eq "[A, A, A]"
    list2 eq "[B]"
    list3 eq "[C, C, C]"
}
