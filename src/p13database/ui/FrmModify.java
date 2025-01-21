package p13database.ui;

import p13database.dao.DAOMember;
import p13database.vo.MemberVO;

import javax.swing.*;
import java.awt.*;

public class FrmModify extends FrmBasic {

  private JPanel pnlNorth, pnlCenter, pnlSouth, pnlCNorth, pnlCCenter, pnlCSouth;
  private JTextField tfId, tfName, tfMobile;
  private JPasswordField pfPass;
  private JButton btnModify, btnCancel;
  private JLabel[] labels;
  private String[] lbArr;
  private int mno;

  public FrmModify(int mno) throws HeadlessException {
    super("회원수정", 270, 210);
    this.mno = mno;
    MemberVO memberVO = new DAOMember().getMember(mno);
    tfId.setText(memberVO.getId());
    pfPass.setText(memberVO.getPass());
    tfName.setText(memberVO.getName());
    tfMobile.setText(memberVO.getMobile());
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
    btnModify = new JButton("Modify");
    btnCancel = new JButton("Cancel");

    for (int i = 0; i < lbArr.length; i++) {
      labels[i] = new JLabel(lbArr[i]);
      labels[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
      labels[i].setPreferredSize(new Dimension(80, 20));
    }

    btnModify.addActionListener(e -> {
      // 유효성 검사
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

      // 회원정보 업데이트
      boolean result = new DAOMember().updateMembers(
          new MemberVO(mno, id, pass, name, mobile)
      );

      if (result) {
        JOptionPane.showMessageDialog(null, "수정되었습니다.");
        dispose(); // 수정 성공 시 창 닫기
      } else {
        JOptionPane.showMessageDialog(null, "수정에 실패했습니다.");
      }
    });

    btnCancel.addActionListener(e -> {
      dispose(); // 취소 버튼 클릭 시 창 닫기
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
    pnlSouth.add(btnModify);
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
