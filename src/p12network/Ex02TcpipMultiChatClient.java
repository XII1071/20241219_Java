package p12network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ex02TcpipMultiChatClient extends JFrame {
  public static void main(String[] args) {
    new Ex02TcpipMultiChatClient();
  }

  private JTextArea ta;
  private JScrollPane scp;
  private JTextField tf;

  private String nickname;
  private DataOutputStream out;

  public Ex02TcpipMultiChatClient() throws HeadlessException {
    init(); arrange(); inflate();
  }

  private void init() {
    ta = new JTextArea();
    scp = new JScrollPane(ta);
    tf = new JTextField();
    ta.setEditable(false);
    ta.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    tf.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

    nickname = JOptionPane.showInputDialog("당신의 닉네임을 입력하시오");
    String ip = JOptionPane.showInputDialog("서버 IP:","10.100.204.26");
    try {
      Socket socket = new Socket(ip, 7777);
      out = new DataOutputStream(socket.getOutputStream());
      out.writeUTF(nickname);
      new Receiver(socket).start();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    tf.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          out.writeUTF(
              String.format("[%s] %s", nickname, tf.getText())
          );
          tf.setText("");
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void arrange() {
    add(scp, "Center");add(tf, "South");
  }

  private void inflate() {
    setTitle("채팅창");
    setSize(400, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
  }

  class Receiver extends Thread {
    DataInputStream in;

    public Receiver(Socket socket) {
      try {
        in = new DataInputStream(socket.getInputStream());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void run() {
      while (in != null) {
        try {
          String msg = in.readUTF();
          ta.append(msg + "\n");
          ta.setCaretPosition(ta.getDocument().getLength());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
