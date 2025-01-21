package p13database.dao;

import p13database.vo.MemberVO;

import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMember extends DAOSet {

  // 1. login 진행시 회원정보(MemberVO)를 가져오는 메서드
  public MemberVO loginCheck(String id, String pass) {
    MemberVO memberVO = null;
    try {
      conn = getConn();
      String sql = "SELECT * FROM members WHERE id=? AND pass=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        memberVO = new MemberVO(
            rs.getLong("mno"),
            rs.getString("id"),
            rs.getString("pass"),
            rs.getString("name"),
            rs.getString("mobile")
        );
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return memberVO;
  }

  // 회원 추가 메서드
  public boolean insertMembers(MemberVO memberVO) {
    boolean result = false;
    try {
      conn = getConn();

      String sql = "INSERT INTO members (mno, id, pass, name, mobile) "
          + "VALUES (sq_members.nextval, ?, ?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberVO.getId());
      pstmt.setString(2, memberVO.getPass());
      pstmt.setString(3, memberVO.getName());
      pstmt.setString(4, memberVO.getMobile());
      int cnt = pstmt.executeUpdate();
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  // 전체 회원 목록 가져오기
  public ArrayList<MemberVO> getList() {
    ArrayList<MemberVO> result = new ArrayList<>();
    try {
      conn = getConn();

      String sql = "SELECT * FROM members";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        MemberVO memberVO = new MemberVO(
            rs.getLong("mno"),
            rs.getString("id"),
            rs.getString("pass"),
            rs.getString("name"),
            rs.getString("mobile")
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

  // 회원 삭제 메서드
  public boolean deleteMembers(long mno) {
    boolean result = false;
    try {
      conn = getConn();

      String sql = "DELETE FROM members WHERE mno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, mno);
      int cnt = pstmt.executeUpdate();
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  // 특정 회원 정보 가져오기
  public MemberVO getMember(int mno) {
    MemberVO result = null;
    try {
      conn = getConn();

      String sql = "SELECT * FROM members WHERE mno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, mno);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = new MemberVO(
            rs.getLong("mno"),
            rs.getString("id"),
            rs.getString("pass"),
            rs.getString("name"),
            rs.getString("mobile")
        );
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  // 회원 정보 업데이트 메서드
  public boolean updateMembers(MemberVO memberVO) {
    boolean result = false;
    try {
      conn = getConn();

      String sql = "UPDATE members SET id = ?, pass = ?, name = ?, mobile = ? WHERE mno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberVO.getId());
      pstmt.setString(2, memberVO.getPass());
      pstmt.setString(3, memberVO.getName());
      pstmt.setString(4, memberVO.getMobile());
      pstmt.setLong(5, memberVO.getMno());

      int cnt = pstmt.executeUpdate();
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }
}