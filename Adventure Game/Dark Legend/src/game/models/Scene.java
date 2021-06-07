package game.models;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private int x, y, w, h;
	public Scene() {
		loadImage();
	}
	private void loadImage() {					//So cria a imagem do cenario e manda pro Board.java
		ImageIcon ii = new ImageIcon(Scene.class.getResource("/Scenario.png"));
		image = ii.getImage();
		x = 0;
		y = 0;
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	public Image getImage() {
		return image;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
}
