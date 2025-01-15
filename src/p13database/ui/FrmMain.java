package p13database.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmMain extends FrmBasic {
  private JTable tbl;
  private DefaultTableModel tableModel;
  private JScrollPane scp;
  private JLabel lb;
  private JButton btnModify, btnDelete;

  public FrmMain() throws HeadlessException {
    super("회원 관리 Ver 1.0", 500, 400);
  }

  @Override
  public void init() {

  }

  @Override
  public void arrange() {

  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
