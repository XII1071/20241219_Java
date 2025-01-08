package p10IO;

import javax.swing.*;
import java.awt.*;

public class Ex04Notepad {
  public static void main(String[] args) {
    new Notepad();
  }
}

/* 메모장을 만들자! */
class Notepad extends JFrame {
  private JTextArea ta;
  private JScrollPane sp;

  private JMenuBar menuBar;

  public Notepad() throws HeadlessException {
    ta = new JTextArea();
    sp = new JScrollPane(ta);
    add(sp);
    setTitle("메모장");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // JFrame 를 닫게해줌
    setLocationRelativeTo(this);
    setVisible(true);
  }
}