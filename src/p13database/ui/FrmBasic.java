package p13database.ui;

import javax.swing.*;
import java.awt.*;

abstract public class FrmBasic extends JFrame {
  private String title;
  private int width, height;

  public FrmBasic(String title, int width, int height) throws HeadlessException {
    this.title = title;this.width = width;this.height = height;
    init();arrange();inflate();
  }

  public abstract void init();

  public abstract void arrange();

  public void inflate() {
    setTitle(title);
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
  }

}
