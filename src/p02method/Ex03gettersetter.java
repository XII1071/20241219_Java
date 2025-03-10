package p02method;

import java.util.Date;

public class Ex03gettersetter {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.setEmpNo(1);
    e1.setEname("LGH");
    e1.setBirthDay(new Date());
  }
}

class Employee {
  private int empNo;
  private String ename;
  private Date birthDay;
  int getEmpNo(){
    return empNo;
  }
  void setEmpNo(int empNo){
    this.empNo = empNo;
  }

  public String getEname() {
    return ename;
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
