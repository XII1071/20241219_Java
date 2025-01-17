package p13database.ui;

import p13database.dao.DAOMember;
import p13database.vo.MemberVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FrmMain extends FrmBasic {
  private JTable tbl;
  private DefaultTableModel tableModel;
  private JScrollPane scp;
  private JLabel lb;
  private JButton btnModify, btnDelete, btnBack;
  private JPanel pnlSouth;

  public FrmMain() throws HeadlessException {
    super("회원 관리 Ver 1.0", 500, 400);
    setTableModel(new DAOMember().getList());
  }

  void setTableModel(ArrayList<MemberVO> list) {
    tableModel.setRowCount(0);
    for (int i = 0; i < list.size(); i++) {
      MemberVO m = list.get(i);
      tableModel.addRow(new String[]{
          m.getMno() + "", m.getName(), m.getId(), m.getPass(), m.getMobile()
      });
    }
    tbl.setModel(tableModel);
  }

  @Override
  public void init() {
    lb = new JLabel("회원 목록");
    lb.setFont(new Font("맑은 고딕", Font.BOLD, 28));
    lb.setHorizontalAlignment(JLabel.CENTER);
    tbl = new JTable();
    scp = new JScrollPane(tbl);
    tableModel = new DefaultTableModel(
        new String[]{"회원번호", "이름", "ID", "Password", "Mobile"}, 0
    );
    btnModify = new JButton("수정");
    btnDelete = new JButton("삭제");
    btnBack = new JButton("Back");
    pnlSouth = new JPanel();
    btnBack.addActionListener(e -> {
      dispose();
      new FrmLogin();
    });
    btnDelete.addActionListener(e -> {
      int selectedRow = tbl.getSelectedRow();
      if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "회원을 먼저 선택하세요");
        return;
      }
      int choice = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 선택",
          JOptionPane.YES_NO_OPTION); // yes 0, no 1
      if (choice == 0) {
        int mno = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        boolean done = new DAOMember().deleteMembers(mno);
        if (done) {
          JOptionPane.showMessageDialog(null, "삭제되었습니다.");
        } else {
          JOptionPane.showMessageDialog(null, "삭제가 안되었습니다.");
        }
      }
    });
  }

  @Override
  public void arrange() {
    add(lb, "North");
    add(scp, "Center");
    pnlSouth.add(btnModify);
    pnlSouth.add(btnDelete);
    pnlSouth.add(btnBack);
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}