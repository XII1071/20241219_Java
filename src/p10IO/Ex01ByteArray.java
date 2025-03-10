package p10IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ex01ByteArray {
  public static void main(String[] args) {
    byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    byte[] outSrc = null;

    // InputStream(추상 클래스)은 프로세스 안으로 들어오는 것
    ByteArrayInputStream input = new ByteArrayInputStream(inSrc);

    // OutputStream(추상 클래스)은 프로세스 밖으로 나가는 것
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.out.println(Arrays.toString(inSrc));

    int data;
    while ((data = input.read()) != -1) {
      output.write(data);
    }
    outSrc = output.toByteArray();
    System.out.println(Arrays.toString(outSrc));

    byte[] tmp = new byte[4];
    input = new ByteArrayInputStream(inSrc);
    output = new ByteArrayOutputStream();

    while (input.available() > 0) {
      try {
        //input.read(tmp);
        //output.write(tmp);
        int len = input.read(tmp);
        output.write(tmp, 0, len);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    outSrc = output.toByteArray();
    System.out.println("tmp: " + Arrays.toString(tmp));
    System.out.println("outSrc: " + Arrays.toString(outSrc));

  }
}
