// BuildingMaps/GroupByVsFilter.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import buildingmaps.*
import atomictest.eq

fun main() {
  val groups =
    people().groupBy { it.name.first() }
  // groupBy()는 빠르게 맵을 만든다
  groups['A'] eq listOf(Person("Alice", 21),
    Person("Arthricia", 15))
  groups['Z'] eq null

  // filter()를 사용하면 각 문자에 대해 filter()를 반복 실행해야 한다
  people().filter {
    it.name.first() == 'A'
  } eq listOf(Person("Alice", 21),
    Person("Arthricia", 15))
  people().filter {
    it.name.first() == 'F'
  } eq listOf(Person("Franz", 21))

  people().partition {
    it.name.first() == 'A'
  } eq Pair(
    listOf(Person("Alice", 21),
      Person("Arthricia", 15)),
    listOf(Person("Bob", 25),
      Person("Bill", 25),
      Person("Birdperson", 42),
      Person("Charlie", 21),
      Person("Crocubot", 42),
      Person("Franz", 21),
      Person("Revolio", 33)))
}
