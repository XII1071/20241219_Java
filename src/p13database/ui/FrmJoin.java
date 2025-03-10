package p13database.ui;

import p13database.dao.DAOMember;
import p13database.vo.MemberVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmJoin extends FrmBasic {

  private JPanel pnlNorth, pnlCenter, pnlSouth, pnlCNorth, pnlCCenter, pnlCSouth;
  private JTextField tfId, tfName, tfMobile;
  private JPasswordField pfPass;
  private JButton btnJoin, btnCancel;
  private JLabel[] labels;
  private String[] lbArr;

  public FrmJoin() throws HeadlessException {
    super("회원가입", 270, 210);
  }

  @Override
  public void init() {
    lbArr = new String[]{"ID", "Password", "Name", "Mobile"};
    labels = new JLabel[4];
    pnlNorth = new JPanel();
    pnlCenter = new JPanel();
    pnlSouth = new JPanel();
    pnlCNorth = new JPanel();
    pnlCCenter = new JPanel();
    pnlCSouth = new JPanel();
    tfId = new JTextField(10);
    pfPass = new JPasswordField(10);
    tfName = new JTextField(10);
    tfMobile = new JTextField(10);
    btnJoin = new JButton("Join");
    btnCancel = new JButton("Cancel");
    for (int i = 0; i < lbArr.length; i++) {
      labels[i] = new JLabel(lbArr[i]);
      labels[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
      labels[i].setPreferredSize(new Dimension(80, 20));
    }
    btnJoin.addActionListener(e -> {
      //유효성 검사
      String id = tfId.getText();
      String pass = new String(pfPass.getPassword());
      String name = tfName.getText();
      String mobile = tfMobile.getText();
      if (id.equals("")) {
        JOptionPane.showMessageDialog(null, "ID를 확인하세요");
        tfId.requestFocus();
        return;
      }
      if (pass.equals("")) {
        JOptionPane.showMessageDialog(null, "Password를 확인하세요");
        pfPass.requestFocus();
        return;
      }
      if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "이름을 확인하세요");
        tfName.requestFocus();
        return;
      }
      if (mobile.equals("")) {
        JOptionPane.showMessageDialog(null, "Mobile을 확인하세요");
        tfMobile.requestFocus();
        return;
      }
      boolean result = new DAOMember().insertMembers(
          new MemberVO(0L, id, pass, name, mobile));
      if(result) {
        JOptionPane.showMessageDialog(null, "등록되었습니다.");
        tfId.setText("");pfPass.setText("");tfName.setText("");tfMobile.setText("");
      }
    });
    btnCancel.addActionListener(e -> {
      dispose();
      new FrmLogin();
    });
  }

  @Override
  public void arrange() {
    pnlNorth.add(labels[0]);
    pnlNorth.add(tfId);
    pnlCNorth.add(labels[1]);
    pnlCNorth.add(pfPass);
    pnlCCenter.add(labels[2]);
    pnlCCenter.add(tfName);
    pnlCSouth.add(labels[3]);
    pnlCSouth.add(tfMobile);
    pnlSouth.add(btnJoin);
    pnlSouth.add(btnCancel);

    pnlCenter.add(pnlCNorth, "North");
    pnlCenter.add(pnlCCenter, "Center");
    pnlCenter.add(pnlCSouth, "South");

    add(pnlNorth, "North");
    add(pnlCenter, "Center");
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
