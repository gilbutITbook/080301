// Properties/AnUnchangingVar.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.

class Sofa {
  val cover: String = "Loveseat cover"
}

fun main() {
  var sofa = Sofa()
  // 다음은 허용되지 않음
  // sofa.cover = "New cover"
  // var에 재대입하기
  sofa = Sofa()
}
