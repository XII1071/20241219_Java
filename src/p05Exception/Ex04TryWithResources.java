package p05Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04TryWithResources {
  public static void main(String[] args) {
    FileInputStream fis = null;
    String filePath = ".\\src\\p05Exception\\Ex02Throws.java";

    try {
      fis = new FileInputStream(filePath);
      int data = 0;
      while ((data = fis.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        if (fis != null) fis.close();  // 자원을 반납하는 코드
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    // try with resources는 java7버전 사용 // 자원 반납 코드 필요 없음
    try (
        FileInputStream fis2 = new FileInputStream(filePath);
        // 복수 문장 가능
    ) {
      int data = 0;
      while ((data = fis.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (FileNotFoundException e) {

    } catch (IOException e) {

    }
  }
}
