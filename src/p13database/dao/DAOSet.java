package p13database.dao;

import java.sql.*;

public class DAOSet {
  protected Connection conn;
  protected PreparedStatement pstmt;
  protected Statement stmt;
  protected ResultSet rs;

  public Connection getConn() throws SQLException {
    String driver = "jdbc:oracle:thin:@localhost:1521:xe"; //oracle
    String user = "db7", pass = "1234";
    conn = DriverManager.getConnection(driver, user, pass);
    return conn;
  }

  public void closeDB() {
    try {
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      if (pstmt != null) pstmt.close();
      if (conn != null) conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}