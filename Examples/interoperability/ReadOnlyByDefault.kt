// interoperability/ReadOnlyByDefault.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package interop

data class Animal(val name: String)

interface Zoo {
  fun viewAnimals(): Collection<Animal>
}

fun visitZoo(zoo: Zoo) {
  val animals = zoo.viewAnimals()
  // 컴파일 시점 오류
  // animals.add(Animal("Grumpy Cat"))
}
