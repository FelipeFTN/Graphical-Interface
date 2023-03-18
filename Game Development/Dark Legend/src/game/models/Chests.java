package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Chests {

	private int x, y, x1, y1, w, h;
	public static boolean openChest = false, openChest1 = false;
	private Image image;
	
	public Chests() {
		x = 205;
		y = 37;
		x1 = 460;
		y1 = 36;
		w = 78;
		h = 59;
		loadImage();
	}
	private void loadImage() { 											//Cria imagem dos baus
		// TODO Auto-generated method stub
		ImageIcon ii = new ImageIcon(Chests.class.getResource("/Chest.png"));
		image = ii.getImage();

	}
	public void chest() {												//Metodo que faz o bau 1 ser aberto (depois eh chamado no Board.java)
		// TODO Auto-generated method stub
		 openChest = true;
	}
	public void chest1() {												//Metodo que faz o bau 2 ser aberto (depois eh chamado no Board.java)
		// TODO Auto-generated method stub
		openChest1 = true;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, w ,h);
	}
	public Rectangle getBounds1() {
		return new Rectangle(x1, y1, w, h);
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
	public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
}
