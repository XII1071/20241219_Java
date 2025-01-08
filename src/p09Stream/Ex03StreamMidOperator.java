package p09Stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Ex03StreamMidOperator {
  public static void main(String[] args) {
    String dir = "C:\\workspace\\spaceJava\\20241219_Java";

    try {
      Stream<Path> fileListStream = Files.list(Paths.get(dir));
      fileListStream.map(new Function<Path, File>() {
            @Override
            public File apply(Path path) {
              return path.toFile();
            }
          })
          // stream에서는 2가지의 반복문 forEach(), peek()
          // forEach()는 return 값이 void라서 최종 메서드로 사용가능
          // peek()는 return 값이 Stream라서 최종 메서드로 사용불가
          // .peek(file -> System.out.println(file.toString()));
          // .forEach(file -> System.out.println(file.toString()));
          .filter(new Predicate<File>() {
            @Override
            public boolean test(File file) {
              return file.isFile();
            }
          })
          .map(new Function<File, String>() {
            @Override
            public String apply(File file) {
              return file.toString();
            }
          })
          .map(new Function<String, String>() {
            @Override
            public String apply(String s) {
              return s.toLowerCase();
            }
          })
          .distinct()
          .forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
              System.out.println(s);
            }
          });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}