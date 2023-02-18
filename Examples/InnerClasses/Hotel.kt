// InnerClasses/Hotel.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package innerclasses
import atomictest.eq

class Hotel(private val reception: String) {
  open inner class Room(val id: Int = 0) {
    // Room을 둘러싼 클래스의 'reception'을 사용한다
    fun callReception() =
      "Room $id Calling $reception"
  }
  private inner class Closet : Room()
  fun closet(): Room = Closet()
}

fun main() {
  val nycHotel = Hotel("311")
  // 내부 클래스의 인스턴스를 생성하려면
  // 그 내부 클래스를 둘러싼 클래스의 인스턴스가 필요하다
  val room = nycHotel.Room(319)
  room.callReception() eq
    "Room 319 Calling 311"
  val sfHotel = Hotel("0")
  val closet = sfHotel.closet()
  closet.callReception() eq "Room 0 Calling 0"
}
