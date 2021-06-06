package game.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Boss {
	private Image image;
	private int x, y, w, h, dx, dy, px, py;
	public static int chooseDirection;
	public static boolean bossActive, bossAlive = true;
	private RectangleBox player;
	private Timer timer;
	Random random = new Random();
	
	public Boss() {
		bossImage();
		
		x = 690;
		y = 441;
		
		player = new RectangleBox();
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 2000, 500);
	}
		
	private void bossImage() {									//Cria a imagem do Boss
		ImageIcon ii = new ImageIcon("res//BossResized.png");
		image = ii.getImage();
		w = 50;
		h = 75;
}
	private void paint(Graphics g) {
		
	}
	
	private class ScheduleTask extends TimerTask{	//Faz o boss sair andando por ai
		
		@Override
		public void run() {
			x += dx;
			y += dy;
			
			if (bossActive  && bossAlive) {
				chooseDirection = random.nextInt(4);
				if(chooseDirection == 0) {
					dy = -10;
				}
				if(chooseDirection == 1) {
					dy = 10;
				}
				if(chooseDirection == 2) {
					dx = -10;
				}
				if(chooseDirection == 3) {
					dx = 10;
				}
				if(getX() > 707) {
					dx = -20;
				}
				if(getX() < 44) {
					dx = 20;
				}
				if(getY() < 42) {
					dy = 20;
				}
				if(getY() > 483) {
					dy = -20;
				}
				x += dx;
				y += dy;
			}	
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
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
}

