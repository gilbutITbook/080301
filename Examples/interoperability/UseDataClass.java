// interoperability/UseDataClass.java
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package interoperability;
import java.util.HashMap;
import static atomictest.AtomicTestKt.eq;

public class UseDataClass {
  public static void main(String[] args) {
    Staff e = new Staff(
      "Fluffy", "Office Manager");
    eq(e.getRole(), "Office Manager");
    e.setName("Uranus");
    e.setRole("Assistant");
    eq(e,
      "Staff(name=Uranus, role=Assistant)");

    // 데이터 클래스의 copy()를 호출한다
    Staff cf = e.copy("Cornfed", "Sidekick");
    eq(cf,
      "Staff(name=Cornfed, role=Sidekick)");

    HashMap<Staff, String> hm =
      new HashMap<>();
    // Staff 객체를 해시 키로 사용한다
    hm.put(e, "Cheerful");
    eq(hm.get(e), "Cheerful");
  }
}
