package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	private final int DELAY = 10;
	private Timer timer;
	private RectangleBox box;
	private ColliderBox block;
	private Rectangle playerHitBox;
	private Rectangle blockHitBox;

	
	public Board() {
		addKeyListener(new TAdapter());
		setPreferredSize(new Dimension(350, 250));
		setFocusable(true);
		
		box = new RectangleBox();
		block = new ColliderBox();
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Toolkit.getDefaultToolkit().sync();
		//g2d.fillRect(box.getX(),  box.getY(), 12, 19);//hitbox || Substituir por Rectangle! e deixar invisivel n
		g2d.drawImage(box.getImage(), box.getX(), box.getY(), this);//sprite dentro da hitbox
		g2d.drawImage(block.getImage(), block.getX(), block.getY(), this);
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		step();
	}
	private void step() {
		// TODO Auto-generated method stub
		box.boxMove();
		playerHitBox = box.getBounds(box.getX(), box.getY());
		blockHitBox = block.getBounds();
		checkCollision();
		repaint();
	}
	public void checkCollision() {
		if(playerHitBox.intersects(blockHitBox)) {
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
	
}
