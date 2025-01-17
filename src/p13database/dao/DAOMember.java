package p13database.dao;

import p13database.vo.MemberVO;

import java.sql.SQLException;
import java.util.ArrayList;

/*
    //Oracle
    create table members(
    mno number, id varchar2(20),
    pass varchar2(20),name varchar2(20),
    mobile varchar2(20));

    //Maria db
    create table members(
    mno number not null auto_increment, id varchar2(20),
    pass varchar2(20),name varchar2(20),
    mobile varchar2(20),
    primary key('mno'));

    create sequence sq_members;

    insert into members(mno, id, pass,name, mobile)
    values(sq_members.nextval, 'admin', '1', '관리자', '010-1111-1111');

*/
public class DAOMember extends DAOSet {

  // 1. login 진행시 회원정보(MemberVO)를 가져오는 메서드
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

  public boolean insertMembers(MemberVO memberVO) {
    boolean result = false;
    try {
      conn = getConn();

      String sql = "insert into members(mno,id, pass, name, mobile) "
          + "VALUES(sq_members.nextval, ?, ?, ?, ?) ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberVO.getId());
      pstmt.setString(2, memberVO.getPass());
      pstmt.setString(3, memberVO.getName());
      pstmt.setString(4, memberVO.getMobile());
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public ArrayList<MemberVO> getList() {
    ArrayList<MemberVO> result = new ArrayList<>();
    try {
      conn = getConn();

      String sql = "select * from members ";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery(); //insert되는 행의 수만큼 리턴
      while (rs.next()) {
        MemberVO memberVO = new MemberVO(
            rs.getLong("mno"), rs.getString("id"), rs.getString("pass"),
            rs.getString("name"), rs.getString("mobile")
        );
        result.add(memberVO);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean deleteMembers(long mno) {
    boolean result = false;

    try {
      conn = getConn();

      String sql = "delete from  ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, mno);
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }

    return result;
  }

  public MemberVO getMember(int mno) {
    MemberVO result = null;

    return result;
  }

  public boolean updateMembers(MemberVO memberVO) {
    boolean result = false;

    return result;
  }
}