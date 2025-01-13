package p13database.ui;

import javax.swing.*;
import java.awt.*;

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
