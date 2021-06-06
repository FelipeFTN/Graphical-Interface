package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import game.models.Boss;
import game.models.Chests;
import game.models.ColliderBox;
import game.models.Door;
import game.models.Lever;
import game.models.RectangleBox;
import game.models.Scene;

public class Board extends JPanel implements ActionListener{

	private Timer timer;
	private Boss boss;
	public RectangleBox box;
	public Rectangle playerHitBox;
	private Rectangle leverHitBox;
	private Rectangle chestHitBox, chestHitBox1;
	private Chests chest;
	private Lever lever;
	private Scene scene;
	private Image keyImage;
	private Door door;
	private Rectangle doorHitBox;
	public Rectangle r2;
	private List<ColliderBox> hitBox;
	private int camX, camY;
	private int offsetMaxX = 800 - 335;
	private int offsetMaxY = 600 - 350;
	private int offsetMinX = 0;
	private int offsetMinY = 0;
	private final int DELAY = 10;
	public static boolean collided = false;
	private final int[][] pos = {
			{0, 0, 799, 40}, {0, 0, 43, 599}, {0, 557, 799, 40}, {542, 462, 40, 137}, {757, 507, 40, 90},
			{757, 0, 40, 448}, {328, 207, 356, 40}, {542, 329, 215, 40}, {542, 329, 40, 54}, {285, 0, 40, 340},
			{43, 474, 162, 81}
	};
	public Board() {
		addKeyListener(new TAdapter());
		setPreferredSize(new Dimension(350, 250));
		setFocusable(true);
		
		initHitBox();
		boss = new Boss();
		scene = new Scene();
		box = new RectangleBox();
		lever = new Lever();
		chest = new Chests();
		door = new Door();
		ImageIcon imageKey = new ImageIcon("res//Key.png");
		keyImage = imageKey.getImage();

		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	private void initHitBox() {
		// TODO Auto-generated method stub
		hitBox = new ArrayList<>();
		for (int[] p : pos) {
				hitBox.add(new ColliderBox(p[0], p[1], p[2], p[3]));				
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Toolkit.getDefaultToolkit().sync();
		g2d.translate(-camX, -camY);
		g2d.drawImage(scene.getImage(), scene.getX(), scene.getY(), this);//cenario
		if(chest.openChest) {
			g2d.drawImage(chest.getImage(), chest.getX(), chest.getY(), chest.getWidth(), chest.getHeight(), this);
			g2d.drawImage(keyImage, box.getX() + 50, box.getY() + 40, 25, 15, null);
		}
		if(chest.openChest1) {
			g2d.drawImage(chest.getImage(), chest.getX1(), chest.getY1(), chest.getWidth(), chest.getHeight(), this);
		}
		g2d.drawImage(box.getImage(), box.getX(), box.getY(), box.getWidth(), box.getHeight(), this);//Player
		g2d.drawImage(boss.getImage(), boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight(), this);
		g2d.drawImage(lever.getImage(), lever.getX(), lever.getY(), lever.getWidth(), lever.getHeight(), this);
		g2d.drawImage(door.getImage(), door.getX(), door.getY(), this);
		g2d.drawImage(lever.getDoorImage(), lever.getDx(), lever.getDy(), this);
		
		g.dispose();
		repaint();//Atualiza Frame
	}
	public void actionPerformed(ActionEvent e) {
		step();
	}
	private void step() {
		box.boxMove();
		playerHitBox = box.getBounds(box.getX(), box.getY());
		checkCollision();
		
		//Camera
		
		camX = box.getX() - 335 / 2;
		camY = box.getY() - 350 / 2;
		
		if (camX > offsetMaxX) {
		    camX = offsetMaxX;
		}
		else if (camX < offsetMinX) {
		    camX = offsetMinX;
		}
		if (camY > offsetMaxY) {
		    camY = offsetMaxY;
		}
		else if (camY < offsetMinY) {
		    camY = offsetMinY;
		}
		repaint();
	}
	public void checkCollision() {
		leverHitBox = lever.getBounds();
		chestHitBox = chest.getBounds();
		chestHitBox1 = chest.getBounds1();
		doorHitBox = door.getBounds();
		Rectangle bossDoorHitBox = lever.getBoundsDoor();
		
		for (ColliderBox hitBox : hitBox) {
			r2 = hitBox.getBounds();
			if(playerHitBox.intersects(r2)) {
				collided = true;
				if(box.lastMove == "UP") {
					playerHitBox = box.getBounds(box.getX(), box.getY() + 2);
				}
				if(box.lastMove == "DOWN") {
					playerHitBox = box.getBounds(box.getX(), box.getY() - 2);
				}
				if(box.lastMove == "LEFT") {
					playerHitBox = box.getBounds(box.getX() + 2, box.getY());
				}
				if(box.lastMove == "RIGHT") {
					playerHitBox = box.getBounds(box.getX() - 2, box.getY());
				}
			}else {
				collided = false;
			}
		}
		
		if(playerHitBox.intersects(doorHitBox)) {
			if(box.lastMove == "UP") {
				playerHitBox = box.getBounds(box.getX(), box.getY() + 2);
				door.useDoor(chest.openChest);
			}
		}
		if(playerHitBox.intersects(bossDoorHitBox) && !lever.leverActive) {
			if(box.lastMove == "RIGHT") {
				playerHitBox = box.getBounds(box.getX() -2, box.getY());
			}
		}
	}
	private class TAdapter extends KeyAdapter{
		
			@Override
			public void keyPressed(KeyEvent e) {
				box.keyPressed(e);
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_SPACE) {
					if(playerHitBox.intersects(leverHitBox)) {
						lever.leverActive = true;
						lever.useLever();
					}
					if(playerHitBox.intersects(chestHitBox)) {
						chest.chest();
					}
					if(playerHitBox.intersects(chestHitBox1)) {
						chest.chest1();
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				box.keyReleased(e);
			}
	}
	public int getXBox() {
		return box.getX();
	}
	public int getYBox() {
		return box.getY();
	}
}
