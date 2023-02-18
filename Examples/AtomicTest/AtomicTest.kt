// AtomicTest/AtomicTest.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package atomictest
import kotlin.math.abs
import kotlin.reflect.KClass

const val ERROR_TAG = "[Error]: "

private fun <L, R> test(
  actual: L,
  expected: R,
  checkEquals: Boolean = true,
  predicate: () -> Boolean
) {
  println(actual)
  if (!predicate()) {
    print(ERROR_TAG)
    println("$actual " +
      (if (checkEquals) "!=" else "==") +
      " $expected")
  }
}

/**
 * this 객체의 문자열 표현을
 * `rval` 문자열과 비교한다
 */
infix fun Any.eq(rval: String) {
  test(this, rval) {
    toString().trim() == rval.trimIndent()
  }
}

/**
 * this 객체가 `rval`과 같은지 검증한다
 */
infix fun <T> T.eq(rval: T) {
  test(this, rval) {
    this == rval
  }
}

/**
 * this != `rval` 인지 검증한다
 */
infix fun <T> T.neq(rval: T) {
  test(this, rval, checkEquals = false) {
    this != rval
  }
}

/**
 * 어떤 Double 값이 rval에 지정된 Double 값과 같은지 비교한다
 * 두 값의 차이가 작은 양숫값(0.0000001)보다 작으면 두 Double을 같다고 판정한다
 */
infix fun Double.eq(rval: Double) {
  test(this, rval) {
    abs(this - rval) < 0.0000001
  }
}

/**
 * 포획한 예외 정보를 저장하는 클래스
 */
class CapturedException(
  private val exceptionClass: KClass<*>?,
  private val actualMessage: String
) {
  private val fullMessage: String
    get() {
      val className =
        exceptionClass?.simpleName ?: ""
      return className + actualMessage
    }
  infix fun eq(message: String) {
    fullMessage eq message
  }
  infix fun contains(parts: List<String>) {
    if (parts.any { it !in fullMessage }) {
      print(ERROR_TAG)
      println("Actual message: $fullMessage")
      println("Expected parts: $parts")
    }
  }
  override fun toString() = fullMessage
}

/**
 * 예외를 포획해 CapturedException에 저장한 후 돌려준다
 * 사용법
 * capture {
 * // 실패가 예상되는 코드
 * } eq "예외클래스이름: 메시지"
 */
fun capture(f:() -> Unit): CapturedException =
  try {
    f()
    CapturedException(null,
      "$ERROR_TAG Expected an exception")
  } catch (e: Throwable) {
    CapturedException(e::class,
      (e.message?.let { ": $it" } ?: ""))
  }

/**
 * 다음과 같이 여러 trace() 호출의 출력을 누적시켜준다
 * trace("info")
 * trace(object)
 * 나중에 누적된 출력을 예상값과 비교할 수 있다
 * trace eq "expected output"
 */
object trace {
  private val trc = mutableListOf<String>()
  operator fun invoke(obj: Any?) {
    trc += obj.toString()
  }
  /**
   * trc의 내용을 여러 줄 String과 비교한다
   * 비교할 때 공백은 무시한다
   */
  infix fun eq(multiline: String) {
    val trace = trc.joinToString("\n")
    val expected = multiline.trimIndent()
      .replace("\n", " ")
    test(trace, multiline) {
      trace.replace("\n", " ") == expected
    }
    trc.clear()
  }
}
