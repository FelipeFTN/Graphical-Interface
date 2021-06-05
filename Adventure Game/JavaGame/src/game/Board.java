package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import game.models.Boss;
import game.models.ColliderBox;
import game.models.RectangleBox;
import game.models.Scene;

public class Board extends JPanel implements ActionListener{

	private final int DELAY = 10;
	private Timer timer;
	private Boss boss;
	private RectangleBox box;
	private Rectangle playerHitBox;
	private List<ColliderBox> hitBox;
	private int camX, camY;
	private int offsetMaxX = 800 - 335;
	private int offsetMaxY = 600 - 350;
	private int offsetMinX = 0;
	private int offsetMinY = 0;
	private Scene scene;
	public static boolean collided = false;
	private final int[][] pos = {
			{0, 0, 799, 40}, {0, 0, 43, 599}, {0, 557, 799, 40}, {542, 599, 40, -137}, {757, 507, 40, 90},
			{757, 0, 40, 448}, {328, 207, 356, 40}, {542, 329, 215, 40}, {542, 329, 40, 54}, {285, 0, 40, 340}
	};
	//private final int[][] siz = {
	//		{799, 40}, {43, 599}, {799, 40}, {40, 137}, {91,  40},
	//		{40, 448}, {356, 40}, {215, 40}, {40, 54}, {40, 340}
	//};
	public Board() {
		addKeyListener(new TAdapter());
		setPreferredSize(new Dimension(350, 250));
		setFocusable(true);
		
		initHitBox();
		boss = new Boss();
		scene = new Scene();
		box = new RectangleBox();
		//block = new ColliderBox();
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
		g2d.drawImage(box.getImage(), box.getX(), box.getY(), box.getWidth(), box.getHeight(), this);//Player
		g2d.drawImage(boss.getImage(), boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight(), this);
		
		for (ColliderBox hitBox : hitBox) {
			if(hitBox.isVisible()) {
				g.drawRect(hitBox.getX(), hitBox.getY(), hitBox.getWidth(), hitBox.getHeight());
			}
		}
		g2d.setColor(Color.RED);//Borda da HitBox
		
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
		for (ColliderBox hitBox : hitBox) {
			Rectangle r2 = hitBox.getBounds();
			
			if(playerHitBox.intersects(r2)) {
				System.out.println("Colidiu Funcionou!");
			}

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
		
		
	}
	private class TAdapter extends KeyAdapter{
		
			@Override
			public void keyPressed(KeyEvent e) {
				box.keyPressed(e);
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
