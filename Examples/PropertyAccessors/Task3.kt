// PropertyAccessors/Task3.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package propertyAccessorsExercise3
import atomictest.eq

class MessageStorage {
  private val _messages = mutableListOf<String>()

  val messages: List<String>
    get() = _messages

  fun addMessage(message: String) {
    _messages += message
  }
}

fun main() {
/*
  val messageStorage = MessageStorage()
  messageStorage.addMessage("first")
  messageStorage.addMessage("second")
  messageStorage.messages eq listOf("first", "second")
  // 컴파일되지 않는다
//  messageStorage.messages.remove("first")
*/
}
