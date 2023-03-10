// CheckInstructions/Postconditions.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package checkinstructions
import atomictest.*

val resultFile = DataFile("Results.txt")

fun createResultFile(create: Boolean) {
  if (create)
    resultFile.writeText("Results\n# ok")
  // ... 다른 실행 경로들
  check(resultFile.exists()) {
    "${resultFile.name} doesn't exist!"
  }
}

fun main() {
  resultFile.erase()
  capture {
    createResultFile(false)
  } eq "IllegalStateException: " +
    "Results.txt doesn't exist!"
  createResultFile(true)
}
