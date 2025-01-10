package p12network;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;

public class Ex02TcpipMultiChatClient extends JFrame {
  public static void main(String[] args) {
    new Ex02TcpipMultiChatClient();
  }

  // 화면 구성
  private JTextArea ta;
  private JScrollPane scp;
  private JTextField tf;
  // 통신 구성
  private String nickName;
  private DataOutputStream out;

  // throws 책임 회피
  public Ex02TcpipMultiChatClient() throws HeadlessException {
    init();
    arrange();
    inflate();
  }

  private void init() {
  }

  private void arrange() {
  }

  private void inflate() {
    setTitle("채팅창");
    setSize(300, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
