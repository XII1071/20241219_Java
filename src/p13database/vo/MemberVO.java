package p13database.vo;

public class MemberVO {
  private long mno;
  private String id, pass, name, mobile;

  public MemberVO(long mno, String id, String pass, String name, String mobile) {
    this.mno = mno;
    this.id = id;
    this.pass = pass;
    this.name = name;
    this.mobile = mobile;
  }

  public long getMno() {
    return mno;
  }

  public void setMno(long mno) {
    this.mno = mno;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
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

  @Override
  public String toString() {
    return "MemberVO{" +
        "mno=" + mno +
        ", id='" + id + '\'' +
        ", pass='" + pass + '\'' +
        ", name='" + name + '\'' +
        ", mobile='" + mobile + '\'' +
        '}';
  }
}