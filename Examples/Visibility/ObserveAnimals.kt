// Visibility/ObserveAnimals.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

fun main() {
  // 다른 파일에 정의한 private 멤버에
  // 접근할 수 없다
  // 클래스가 private인 경우:
  // val rabbit = Animal("Rabbit")
  // 함수가 private인 경우:
  // recordAnimal(rabbit)
  // 프로퍼티가 private인 경우:
  // index++

  recordAnimals()
  recordAnimalsCount()
}
/* Output:
Animal #0: Tiger
Animal #1: Antelope
2 animals are here!
*/
