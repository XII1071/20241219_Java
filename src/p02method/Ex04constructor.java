package p02method;

import java.util.Date;

public class Ex04constructor {
  public static void main(String[] args) {
    Student s1 = new Student();
    s1.setStdNo(1);
    s1.setName("LGH");
    s1.setMobile("010");
    s1.setRegDate(new Date());

    Student s2 = new Student(1, "LGH", "010", new Date());

    System.out.println(s1.getStdNo());
    System.out.println(s1.getName());
    System.out.println(s1.getRegDate());
  }
}

class Student {
  public Student(){}
  public Student(int stdNo, String name, String mobile, Date regDate){
    this.stdNo = stdNo; this.name=name;this.mobile=mobile;this.regDate=regDate;
  }
  private int stdNo =10;
  private String name;
  private String mobile;
  private Date regDate;

  public int getStdNo() {
    return stdNo;
  }

  public String getName() {
    return name;
  }

  public String getMobile() {
    return mobile;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStdNo(int stdNo) {
    this.stdNo = stdNo;
  }

}