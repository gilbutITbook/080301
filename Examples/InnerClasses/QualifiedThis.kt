// InnerClasses/QualifiedThis.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package innerclasses
import atomictest.eq
import typechecking.name

class Fruit { // @Fruit라는 레이블이 암시적으로 붙는다
  fun changeColor(color: String) =
    "Fruit $color"
  fun absorbWater(amount: Int) {}
  inner class Seed {  // @Seed라는 레이블이 암시적으로 붙는다
    fun changeColor(color: String) =
      "Seed $color"
    fun germinate() {}
    fun whichThis() {
      // 디폴트로 (가장 안쪽의) 현재 클래스를 가리킨다
      this.name eq "Seed"
      // 명확히 하기 위해 디폴트 this를
      // 한정시킬 수 있다
      this@Seed.name  eq "Seed"
      // name이 Fruit와 Seed에 다 있기 때문에
      // Fruit를 명시해 접근해야 한다
      this@Fruit.name  eq "Fruit"
      // 현재 클래스의 내부 클래스에 @레이블을 써서 접근할 수는 없다
      // this@DNA.name
    }
    inner class DNA { // @DNA라는 레이블이 암시적으로 붙는다
      fun changeColor(color: String) {
        // changeColor(color) // 재귀 호출
        this@Seed.changeColor(color)
        this@Fruit.changeColor(color)
      }
      fun plant() {
        // 한정을 시키지 않고 외부 클래스의
        // 함수를 호출할 수 있다
        germinate()
        absorbWater(10)
      }
      // 확장 함수
      fun Int.grow() { // @grow라는 암시적 레이블이 붙는다
        // 디폴트는 Int.grow()로, 'Int'를 수신 객체로 받는다
        this.name eq "Int"
        // @grow 한정은 없어도 된다
        this@grow.name  eq "Int"
        // 여기서도 여전히 모든 프로퍼티에 접근할 수 있다
        this@DNA.name  eq "DNA"
        this@Seed.name  eq "Seed"
        this@Fruit.name  eq "Fruit"
      }
      // 외부 클래스에 대한 확장 함수들
      fun Seed.plant() {}
      fun Fruit.plant() {}
      fun whichThis() {
        // 디폴트는 현재 클래스이다
        this.name eq "DNA"
        // @DNA 한정은 없어도 된다
        this@DNA.name  eq "DNA"
        // 다른 클래스 한정은 꼭 명시해야 한다
        this@Seed.name  eq "Seed"
        this@Fruit.name  eq "Fruit"
      }
    }
  }
}

// 확장 함수
fun Fruit.grow(amount: Int) {
  absorbWater(amount)
  // Fruit의 'changeColor()'를 호출한다
  changeColor("Red") eq "Fruit Red"
}

// 내부 클래스의 확장 함수
fun Fruit.Seed.grow(n: Int) {
  germinate()
  // Seed의 `changeColor()`를 호출한다
  changeColor("Green") eq "Seed Green"
}

// 내부 클래스의 확장 함수
fun Fruit.Seed.DNA.grow(n: Int) = n.grow()

fun main() {
  val fruit = Fruit()
  fruit.grow(4)
  val seed = fruit.Seed()
  seed.grow(9)
  seed.whichThis()
  val dna = seed.DNA()
  dna.plant()
  dna.grow(5)
  dna.whichThis()
  dna.changeColor("Purple")
}
