package mysecurity;

import javax.swing.*;

public class Main{
  public Main() {
    JFrame frame = new JFrame("MySecurity");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    JButton button = new JButton("Button 0");
    JButton button1 = new JButton("Button 1");
    frame.getContentPane().add(button);
    frame.getContentPane().add(button1);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    Main ms = new Main();
  }
}
