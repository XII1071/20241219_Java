package p10IO;

import java.io.*;

public class Ex02FileInput {
  public static void main(String[] args) {
    FileInputStream fis = null; // 주스트림
    InputStreamReader reader = null;  // byte기반을 char기반으로 변환
    BufferedReader br = null; // 보조스트림

    try {
      fis = new FileInputStream("src//p10IO//Ex02FileInput.java");
      reader = new InputStreamReader(fis);
      br = new BufferedReader(reader);
      int data;
      while ((data = br.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        br.close();
        reader.close();
        fis.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    /*
    try (
        FileInputStream fis1 = new FileInputStream("src//p10IO//Ex02FileInput.java");
        InputStreamReader reader1 = new InputStreamReader(fis1);
        BufferedReader br1 = new BufferedReader(reader1);
    ) {
      int data;
      while ((data = br1.read()) != -1) {
        System.out.println((char) data);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    */
  }
}
