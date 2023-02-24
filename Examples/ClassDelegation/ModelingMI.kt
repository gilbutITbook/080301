// ClassDelegation/ModelingMI.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package classdelegation
import atomictest.eq

interface Rectangle {
  fun paint(): String
}

class ButtonImage(
  val width: Int,
  val height: Int
): Rectangle {
  override fun paint() =
    "painting ButtonImage($width, $height)"
}

interface MouseManager {
  fun clicked(): Boolean
  fun hovering(): Boolean
}

class UserInput : MouseManager {
  override fun clicked() = true
  override fun hovering() = true
}

// 앞의 두 클래스를 open으로 정의한다고 해도 하위 타입을
// 정의할 때는 상위 타입 목록에 클래스를 하나만 넣을 수 있기
// 때문에 다음과 같이 쓸 수는 없다.
// class Button : ButtonImage(), UserInput()

class Button(
  val width: Int,
  val height: Int,
  var image: Rectangle =
    ButtonImage(width, height),
  private var input: MouseManager = UserInput()
): Rectangle by image, MouseManager by input

fun main() {
  val button = Button(10, 5)
  button.paint() eq
    "painting ButtonImage(10, 5)"
  button.clicked() eq true
  button.hovering() eq true
  // 위임한 두 타입으로 업캐스트가 모두 가능하다
  val rectangle: Rectangle = button
  val mouseManager: MouseManager = button
}
