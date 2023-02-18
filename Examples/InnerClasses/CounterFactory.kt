// InnerClasses/CounterFactory.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package innerclasses
import atomictest.*

fun interface Counter {
  fun next(): Int
}

object CounterFactory {
  private var count = 0
  fun new(name: String): Counter {
    // 지역 내부 클래스
    class Local : Counter {
      init { trace("Local()") }
      override fun next(): Int {
        // 함수의 지역 변수나 외부 객체 프로퍼티에 접근할 수 있다
        trace("$name $count")
        return count++
      }
    }
    return Local()
  }
  fun new2(name: String): Counter {
    // 익명 내부 클래스 인스턴스
    return object: Counter {
      init { trace("Counter()") }
      override fun next(): Int {
        trace("$name $count")
        return count++
      }
    }
  }
  fun new3(name: String): Counter {
    trace("Counter()")
    return Counter { // SAM 변환
      trace("$name $count")
      count++
    }
  }
}

fun main() {
  fun test(counter: Counter) {
    (0..3).forEach { counter.next() }
  }
  test(CounterFactory.new("Local"))
  test(CounterFactory.new2("Anon"))
  test(CounterFactory.new3("SAM"))
  trace eq """
    Local() Local 0 Local 1 Local 2 Local 3
    Counter() Anon 4 Anon 5 Anon 6 Anon 7
    Counter() SAM 8 SAM 9 SAM 10 SAM 11
  """
}
