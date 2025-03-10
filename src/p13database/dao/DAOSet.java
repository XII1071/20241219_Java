package p13database.dao;

import java.sql.*;

public class DAOSet {
  protected Connection conn;
  protected PreparedStatement pstmt;
  protected Statement stmt;
  protected ResultSet rs;

  public Connection getConn() throws SQLException {
    // maria db settings
//    final String driver = "org.mariadb.jdbc.Driver";
//    final String DB_IP = "localhost";
//    final String DB_PORT = "3306";
//    final String DB_NAME = "db7";
//    final String DB_URL =
//        "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;
//    try {
//      Class.forName(driver);
//      conn = DriverManager.getConnection(DB_URL, "db7", "1234");
//    } catch (ClassNotFoundException e) {
//      throw new RuntimeException(e);
//    }

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
