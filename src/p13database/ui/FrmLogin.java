package p13database.ui;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends FrmBasic {
  private JPanel pnlNorth, pnlCenter, pnlSouth;
  private JLabel lbId, lbPass;
  private JTextField tfId;
  private JPasswordField pfPass;
  private JButton btnLogin, btnJoin;

  // 생성자와 초기화 블럭은 상속되지 않는다. 멤버와 메서드만 상속
  public FrmLogin() throws HeadlessException {
    super("Login", 270, 200);
  }

  @Override
  public void init() {
    pnlNorth = new JPanel();
    pnlCenter = new JPanel();
    pnlSouth = new JPanel();
    lbId = new JLabel("ID");
    lbPass = new JLabel("Pass");
    lbId.setPreferredSize(new Dimension(50, 20));
    lbPass.setPreferredSize(new Dimension(50, 20));
    tfId = new JTextField(10);
    pfPass = new JPasswordField(10);
    tfId.setFont(new Font("consolas", Font.PLAIN, 16));
    pfPass.setFont(new Font("consolas", Font.PLAIN, 16));
    btnLogin = new JButton("Login");
    btnJoin = new JButton("Join");
    
    btnLogin.addActionListener(e -> {

    });
    btnJoin.addActionListener(e -> {
      new FrmJoin();
      dispose();
    });
  }

  @Override
  public void arrange() {
    pnlNorth.add(lbId);
    pnlNorth.add(tfId);
    pnlCenter.add(lbPass);
    pnlCenter.add(pfPass);
    pnlCenter.add(btnJoin);
    pnlSouth.add(btnLogin);
    pnlSouth.add(btnJoin);
    add(pnlNorth, "North");
    add(pnlCenter, "Center");
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}

/* border layout = JFrame JDialog */