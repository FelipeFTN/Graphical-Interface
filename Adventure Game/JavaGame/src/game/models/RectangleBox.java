package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import game.Board;

public class RectangleBox extends JPanel{ 				//Este aqui Controla o Player
	private static final KeyEvent KeyEvent = null;
	private Image image;
	private int x, y, dx, dy, w, h;
	private int initX = 125;
	private int initY = 50;
	public static String lastMove;
	private boolean collided = false;
	
	public RectangleBox() {
		playerImage();
		resetState();
	}
	public void playerImage() {							//Cria a imagem do Player
		ImageIcon ii = new ImageIcon("res//PlayerResized.png");
		image = ii.getImage();
		w = 50;
		h = 72;
	}
	public void boxMove() {								//Movimentos do Player
		x += dx;
		y += dy;
	}
	
	public void collided(boolean collided) {
		this.collided = collided;
	}
	//Controles
	public void keyPressed(KeyEvent e) {				//Se as teclas Setinhas forem apertadas, ele movimenta o player
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) {
			lastMove = "UP";
			dy = -2;
		}
		if(key == KeyEvent.VK_DOWN) {
			lastMove = "DOWN";
			dy = 2;
		}
		if(key == KeyEvent.VK_LEFT) {
			lastMove = "LEFT";
			dx = -2;				
		}
		if(key == KeyEvent.VK_RIGHT) {
			lastMove = "RIGHT";
			dx = 2;			
		}
	}
	public void keyReleased(KeyEvent e) {			//Se as teclas Setinhas forem soltas ele para o player
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT) {
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
		this.x = x;
		this.y = y;
		return new Rectangle(x, y, w, h);
	}
}
