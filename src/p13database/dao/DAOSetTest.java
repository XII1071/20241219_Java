package p13database.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOSetTest {
  public static void main(String[] args) {
    DAOSet daoSet = new DAOSet();
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = daoSet.getConn();
      System.out.println(conn.isClosed()?"접속종료":"접속중");
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    } finally {
      System.out.println("종료.");
      daoSet.closeDB();
    }
  }
}
