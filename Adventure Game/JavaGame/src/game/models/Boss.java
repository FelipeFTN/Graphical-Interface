package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Boss{
	private Image image;
	private int x, y, w, h, dx, dy;
	public static int chooseDirection;
	public static boolean bossActive;
	private RectangleBox player;
	Random random = new Random();
	
	public Boss() {
		bossImage();
		dx = 0;
		dy = 0;
		x = 690;
		y = 441;
		
		player = new RectangleBox();
			
				
			if (bossActive) {
				chooseDirection = random.nextInt(4);
				if(chooseDirection == 0) {
					System.out.print(chooseDirection);
					dy = -10;
				}
				if(chooseDirection == 1) {
					System.out.print(chooseDirection);
					dy = 10;
				}
				if(chooseDirection == 2) {
					System.out.print(chooseDirection);
					dx = -10;
				}
				if(chooseDirection == 3) {
					System.out.print(chooseDirection);
					dx = 10;
				}

				System.out.println(player.getX() + " "+ player.getY());
				
				if(player.getX() < getX()) {
					dx = -20;
				}
				if(player.getX() > getX()) {
					dx = 20;
				}
				if(player.getY() < getY()) {
					dy = -20;
				}
				if(player.getY() > getY()) {
					dy = 20;
				}
				x += dx;
				y += dy;
			}
			
	}
	private void bossImage() {
		// TODO Auto-generated method stub
		ImageIcon ii = new ImageIcon("res//BossResized.png");
		image = ii.getImage();
		w = 50;
		h = 75;
		
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
