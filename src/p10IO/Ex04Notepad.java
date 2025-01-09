package p10IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


/* 메모장을 만들자! */
public class Ex04Notepad {
  public static void main(String[] args) {
    new Notepad();
  }
}

class Notepad extends JFrame {
  private JTextArea ta;
  private JScrollPane sp;

  private JMenuBar menuBar;
  private JMenu menuF, menuE, menuO, menuV, menuH;
  private JMenuItem miNew, miOpen, miSave, miExit, miInfo;

  private JFileChooser fc;

  public Notepad() throws HeadlessException {
    ta = new JTextArea();
    sp = new JScrollPane(ta);
    menuBar = new JMenuBar();
    menuF = new JMenu("파일(F)");
    menuE = new JMenu("편집(E)");
    menuO = new JMenu("서식(O)");
    menuV = new JMenu("보기(V)");
    menuH = new JMenu("도움말(H)");
    miNew = new JMenuItem("새로 만들기(N)");
    miOpen = new JMenuItem("열기(O)");
    miSave = new JMenuItem("저장(S)");
    miExit = new JMenuItem("끝내기(X)");
    miInfo = new JMenuItem("정보(A)");
    fc = new JFileChooser();

    // addActionListener는 이벤트가 일어나면 그것을 체크할수 있음.
    // 이벤트가 일어났을 때 그것을 처리하는 익명 객체
    miNew.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!ta.getText().toString().equals("")) {
          // yes 0, no =1, x = -1
          int confirm = JOptionPane.showConfirmDialog(
              miNew, "저장하시겠습니까?", "저장", JOptionPane.YES_NO_OPTION);
          if (confirm == 0) fileSave();
        }
        ta.setText("");
      }
    });
    miOpen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int ret = fc.showOpenDialog(miOpen);
        // miOpen만 하면 값 정의가 애매하게 잡혀 int추가
        if (ret == 0) {
          // 중간에 창 캔슬 해도 에러 안뜸
          String selectedFile = fc.getSelectedFile().toString();
          try (FileReader fr = new FileReader(selectedFile);) {
            ta.setText(""); // 열기전 창 내용 비우기
            int data;
            while ((data = fr.read()) != -1) {
              ta.append(String.valueOf((char) data));
            }
          } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });
    miSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fileSave();
      }
    });
    miExit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    // 익명객체의 this는 익명객체이지만, 람다식의 this는 자신이 속한 클래스.
    miInfo.addActionListener(e -> new InfoDialog(this, true));
    menuF.add(miNew);
    menuF.add(miOpen);
    menuF.add(miSave);
    menuF.add(miExit);
    menuH.add(miInfo);
    menuBar.add(menuF);
    menuBar.add(menuE);
    menuBar.add(menuO);
    menuBar.add(menuV);
    menuBar.add(menuH);
    setJMenuBar(menuBar);
    // 추가다하고 setMenuBar 추가

    add(sp);
    setTitle("메모장");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // JFrame 를 닫게해줌
    setLocationRelativeTo(this);
    setVisible(true);
  }

  private void fileSave() {
    int ret = fc.showSaveDialog(miSave);
    if (ret == 0) {
      String saveFile = fc.getSelectedFile().toString();
      try (
          FileWriter fw = new FileWriter(saveFile);
          BufferedWriter bw = new BufferedWriter(fw);
      ) {
        bw.write(ta.getText());
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
  }
}

class InfoDialog extends JDialog {
  // 이미지 레이블
  JLabel lbImg = new JLabel(new ImageIcon("dog.png"));

  JLabel lbTxt = new JLabel("널 위해 만들었어");

  public InfoDialog(JFrame fr, boolean modal) {
    super(fr, modal);

    add(lbImg, "South");
    add(lbTxt, "Center");

    setTitle("정보");
    setLocationRelativeTo(this);
    setSize(348, 400);
    setVisible(true);
  }
}