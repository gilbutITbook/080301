// Inheritance/OpenAndFinalClasses.kt
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package inheritance

// 이 클래스는 상속될 수 있다
open class Parent

class Child : Parent()

// Child는 열려 있지 않으므로 다음 상속은 실패한다
// class GrandChild : Child()

// 이 클래스는 상속될 수 없다
final class Single

// 'final'을 쓴 선언과 같은 효과를 낸다
class AnotherSingle
