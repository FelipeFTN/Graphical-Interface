package game.models;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel{
	private Image image, imageBackground;
	private int x, y, w, h;
	private int xb, yb, wb, hb;
	
	public Scene() {
		loadImage();
	}
	private void loadImage() {
		ImageIcon ii = new ImageIcon("res//Scenario.png");
		image = ii.getImage();
		x = 0;
		y = 0;
		w = image.getWidth(null);
		h = image.getHeight(null);
		//Background Image
		ImageIcon ib = new ImageIcon("res//Background.png");
		imageBackground = ib.getImage();
		xb = 0;
		yb = 0;
		wb = imageBackground.getWidth(null);
		hb = imageBackground.getHeight(null);
				
		
		
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
