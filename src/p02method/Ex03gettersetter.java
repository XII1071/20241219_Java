package p02method;

import java.util.Date;

public class Ex03gettersetter {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.setEname("G1");
    e1.setEmpNo(1);
    e1.setBirthDay(new Date());
  }
}

class Employee {
  private int empNo;
  private String ename;
  private Date birthDay;

  int getEmpNo() {
    return empNo;
  }

  int getEname() {
    return empNo;
  }

  int getDate() {
    return empNo;
  }

  void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }
}
