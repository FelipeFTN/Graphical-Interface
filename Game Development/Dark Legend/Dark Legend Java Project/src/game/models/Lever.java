package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Lever {
	private Image image, doorImage;
	private ImageIcon leverOff, leverOn, bossDoorOpened, bossDoorClosed;
	private int x, y, w, h;
	private int dx, dox, doy, dy, dw, dh;
	public static boolean leverActive = false;
	public Lever(){
		leverImage();
		useLever();
		bossDoorImage();
		new Boss();
		//x = 327;
		//y = 92;
		x = 327;
		y = 248;
		dx = 540;
		dy = 383;
		dox = 465;
		doy = 376;
	}

	private void leverImage() {						//Cria as imagens da alavanca
		leverOff = new ImageIcon(Lever.class.getResource("/Lever0.png"));
		leverOn = new ImageIcon(Lever.class.getResource("/Lever1.png"));	
		
		image = leverOff.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	private void bossDoorImage() {					//Cria as imagens da porta que a alavanca abre
		bossDoorOpened = new ImageIcon(Lever.class.getResource("/BossDoorOpened.png"));
		bossDoorClosed = new ImageIcon(Lever.class.getResource("/BossDoorClosed.png"));
		
		doorImage = bossDoorClosed.getImage();
		dw = doorImage.getWidth(null);
		dh = doorImage.getHeight(null);
	}
	public void useLever() {						//Isso aqui eh chamado no arquivo Board.java na linha 211
		if(leverActive) {							//Basicamente abre a porta do boss e ativa ele
			image = leverOn.getImage();
			doorImage = bossDoorOpened.getImage();
			dx = dox;
			dy = doy;
			Boss.bossActive = true;
		}else {
			image = leverOff.getImage();
		}
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
	public int getDx() {
		return dx;
	}
	public int getDy() {
		return dy;
	}
	public Image getDoorImage() {
		return doorImage;
	}
	public Rectangle getBoundsDoor() {
		return new Rectangle(dx, dy, dw, dh);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
}
