// interoperability/JavaChecked.java
// (c)2021 Mindview LLC. See Copyright.txt for permissions.
package interoperability;
import java.io.*;
import java.nio.file.*;
import static atomictest.AtomicTestKt.eq;

public class JavaChecked {
  // 그레이들이 호출된 현재 디렉터리를 기준으로
  // 대상 파일에 대한 경로를 만든다
  static Path thisFile = Paths.get(
    "DataFiles", "file_wubba.txt");
  public static void main(String[] args) {
    BufferedReader source = null;
    try {
      source = new BufferedReader(
        new FileReader(thisFile.toFile()));
    } catch(FileNotFoundException e) {
      // 파일을 열 때 발생한 오류를 복구한다
    }
    try {
      String first = source.readLine();
      eq(first, "wubba lubba dub dub");
    } catch(IOException e) {
      // read()에서 발생한 오류를 복구한다
    }
    try {
      source.close();
    } catch(IOException e) {
      // close()에서 발생한 오류를 복구한다
    }
  }
}
