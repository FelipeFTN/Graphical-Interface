package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RectangleBox extends JPanel{ 				//Este aqui Controla o Player
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	static int x;
	static int y;
	private int dx;
	private int dy;
	private int w;
	private int h;
	private int initX = 125;
	private int initY = 50;
	public static String lastMove;
	public RectangleBox() {
		playerImage();
		resetState();
	}
	public void playerImage() {							//Cria a imagem do Player
		ImageIcon ii = new ImageIcon(RectangleBox.class.getResource("/PlayerResized.png"));
		image = ii.getImage();
		w = 50;
		h = 72;
	}
	public void boxMove() {								//Movimentos do Player
		x += dx;
		y += dy;
	}
	
	public void collided(boolean collided) {
	}
	//Controles
	public void keyPressed(KeyEvent e) {				//Se as teclas Setinhas forem apertadas, ele movimenta o player
		int key = e.getKeyCode();
		if(key == java.awt.event.KeyEvent.VK_UP) {
			lastMove = "UP";
			dy = -2;
		}
		if(key == java.awt.event.KeyEvent.VK_DOWN) {
			lastMove = "DOWN";
			dy = 2;
		}
		if(key == java.awt.event.KeyEvent.VK_LEFT) {
			lastMove = "LEFT";
			dx = -2;				
		}
		if(key == java.awt.event.KeyEvent.VK_RIGHT) {
			lastMove = "RIGHT";
			dx = 2;			
		}
	}
	public void keyReleased(KeyEvent e) {			//Se as teclas Setinhas forem soltas ele para o player
		int key = e.getKeyCode();
		
		if(key == java.awt.event.KeyEvent.VK_UP) {
			dy = 0;
		}
		if(key == java.awt.event.KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(key == java.awt.event.KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(key == java.awt.event.KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
	private void resetState() {					//Isso aqui faz o player iniciar numa determinada posicao
		x = initX;
		y = initY;
	}
	
	//Metodos get
	
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
	public Rectangle getBounds(int x, int y) {
		RectangleBox.x = x;
		RectangleBox.y = y;
		return new Rectangle(x, y, w, h);
	}
}
