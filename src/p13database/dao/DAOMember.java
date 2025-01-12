package p13database.dao;

import p13database.vo.MemberVO;

import java.sql.SQLException;

/*
    create table members(
    mno number, id varchar2(20),
    pass varchar2(20),name varchar2(20),
    mobile varchar2(20));

    create sequence sq_members;
*/
public class DAOMember extends DAOSet {
  public MemberVO loginCheck(String id, String pass) {
    MemberVO memberVO = null;
    try {
      conn = getConn();
      String sql = "select * from members where id=? and pass=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        memberVO = new MemberVO(rs.getLong("mno"), rs.getString("id"),
            rs.getString("pass"), rs.getString("name"), rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return memberVO;
  }
}