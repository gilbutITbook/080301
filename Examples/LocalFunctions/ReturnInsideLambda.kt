// LocalFunctions/ReturnInsideLambda.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
import localfunctions.*
import atomictest.eq

fun main() {
  sessions.any { session ->
    if (session.title.contains("Kotlin") &&
      session.speaker in favoriteSpeakers) {
      return@any true
    }
    // ... 추가 검사
    false
  } eq true
}
