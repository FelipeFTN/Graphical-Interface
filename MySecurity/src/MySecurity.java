package mysecurity;

import javax.swing.JFrame;

public class MySecurity {
  public MySecurity() {
    add(new Frame());
    setTitle("MySecurity");
    setSize(335, 350);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    MySecurity ms = new MySecurity();
    ms.setVisible(true);
  }
}
