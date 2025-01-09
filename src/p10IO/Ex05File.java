package p10IO;

import java.io.File;
import java.io.IOException;

public class Ex05File {
  public static void main(String[] args) {
    // 1. File객체는 폴더를 다룰 수 있다.
    File file = new File(".");
    if (file.exists() && file.isDirectory()) {
      String[] fileList = file.list();
      for (int i = 0; i < fileList.length; i++) {
        System.out.println(fileList[i]);
      }
    } else {
      System.out.println("해당 경로는 폴더가 아닙니다.");
    }

    // 2. File객체는 파일을 다룰 수 있다.
    file = new File("C:\\workspace\\spaceJava\\20241219_Java\\test.txt");
    if (file.exists()) {
      try {
        System.out.println("file.getName():" + file.getName());
        System.out.println("file.getPath():" + file.getPath());
        System.out.println("file.getAbsolutePath():" + file.getAbsolutePath());
        // getCanonicalFile()은 ./, ../를 정리하여 절대경로로 표시
        System.out.println("file.getCanonicalFile():" + file.getCanonicalFile());
        System.out.println("file.getCanonicalPath():" + file.getCanonicalPath());
        System.out.println("file.getParent():" + file.getParent());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    // 3. File객체는 Drive의 정보를 알 수 있다.
    String drive;
    double totalSpace, usedSpace, freeSpace, usableSpace;
    File[] roots = File.listRoots();
    for (File root : roots) {
      drive = root.getAbsolutePath();
      totalSpace = root.getTotalSpace() / Math.pow(1024, 3);
      usableSpace = root.getUsableSpace() / Math.pow(1024, 3);
      freeSpace = root.getFreeSpace() / Math.pow(1024, 3);
      usedSpace = totalSpace - usableSpace;
      System.out.println("Drive: " + drive);
      System.out.printf("Total Space: %5.2f GB %n", totalSpace);
      System.out.printf("Usable Space: %5.2f GB %n", usableSpace);
      System.out.printf("Free Space: %5.2f GB %n", freeSpace);
      System.out.printf("Used Sapce: %5.2f GB %n", usedSpace);
    }
  }
}