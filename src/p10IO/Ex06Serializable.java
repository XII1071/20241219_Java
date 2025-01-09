package p10IO;

import java.io.*;
import java.util.ArrayList;

public class Ex06Serializable {
  public static void main(String[] args) {
    // User 객체 생성
    User u1 = new User("LGH", 10); // 이름 "LGH", 나이 10인 객체 생성
    User u2 = new User("KGH", 11); // 이름 "KGH", 나이 11인 객체 생성
    ArrayList<User> list = new ArrayList<>(); // User 객체를 저장할 ArrayList 생성
    list.add(u1); // 리스트에 첫 번째 User 추가
    list.add(u2); // 리스트에 두 번째 User 추가

    String exportFile = "UserInfo.ser"; // 데이터를 저장할 파일 이름 설정

    /*Serialization (객체를 파일로 저장)*/
    try (
        FileOutputStream fos = new FileOutputStream(exportFile); // 파일 출력 스트림 생성
        BufferedOutputStream bos = new BufferedOutputStream(fos); // 성능 향상을 위한 버퍼 스트림 추가
        ObjectOutputStream oos = new ObjectOutputStream(bos); // 객체를 직렬화해서 출력할 스트림 생성
    ) {
      oos.writeObject(u1); // 첫 번째 User 객체를 파일에 저장
      oos.writeObject(u2); // 두 번째 User 객체를 파일에 저장
      oos.writeObject(list); // User 객체 리스트를 파일에 저장
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e); // 파일을 찾지 못했을 때 예외 처리
    } catch (IOException e) {
      throw new RuntimeException(e); // 입출력 에러 발생 시 예외 처리
    }

    /*Deserialization (파일에서 객체를 읽어오기)*/
    try (
        FileInputStream fis = new FileInputStream(exportFile); // 파일 입력 스트림 생성
        BufferedInputStream bis = new BufferedInputStream(fis); // 성능 향상을 위한 버퍼 스트림 추가
        ObjectInputStream ois = new ObjectInputStream(bis); // 파일에서 직렬화된 객체를 읽어올 스트림 생성
    ) {
      User get1 = (User) ois.readObject(); // 첫 번째 User 객체 읽어오기
      User get2 = (User) ois.readObject(); // 두 번째 User 객체 읽어오기
      ArrayList<User> get3 = (ArrayList<User>) ois.readObject(); // 리스트 객체 읽어오기

      // 읽어온 객체 출력
      System.out.println(get1); // 첫 번째 User 출력
      System.out.println(get2); // 두 번째 User 출력
      System.out.println(get3); // 리스트 출력
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e); // 파일을 찾지 못했을 때 예외 처리
    } catch (IOException e) {
      throw new RuntimeException(e); // 입출력 에러 발생 시 예외 처리
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e); // 클래스 정보를 찾지 못했을 때 예외 처리
    }
  }
}

/*User 클래스 정의*/
class User implements Serializable { // 직렬화 가능한 클래스
  private String name; // 사용자 이름
  private int age; // 사용자 나이

  // 기본 생성자: 이름은 "Unknown", 나이는 10으로 설정
  public User() {
    this("Unknown", 10);
  }

  // 매개변수가 있는 생성자: 외부에서 이름과 나이를 설정
  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // 객체를 문자열로 표현하는 메서드 (ex: "LGH/10")
  @Override
  public String toString() {
    return name + "/" + age;
  }
}
