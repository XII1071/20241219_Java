package p02method;

import java.util.Date;

public class Ex04constructor {
  public static void main(String[] args) {
    Student s1 = new Student();
    s1.setStdNo(1);
    s1.setName("G1");
    s1.setMobile("010");
    s1.setRegDate(new Date());
  }
}

class Student {
  private int stdNo;
  private String name;
  private String mobile;
  private Date regDate;

  public int getStdNo() {
    return stdNo;
  }

  public void setStdNo(int stdNo) {
    this.stdNo = stdNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }
}