// LocalFunctions/InterestingSessions.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import localfunctions.*
import atomictest.eq

fun main() {
  sessions.any(
    fun(session: Session): Boolean {    // [1]
      if (session.title.contains("Kotlin") &&
        session.speaker in favoriteSpeakers) {
        return true
      }
      // ... 추가 검사
      return false
    }) eq true
}
