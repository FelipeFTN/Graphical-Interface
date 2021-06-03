package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block {

	private Image image;
	
	public Block() {
		loadImage();
	}
	
	public void loadImage() {
		ImageIcon ii = new ImageIcon("res//Block.png");
		image = ii.getImage();
			
	}
	
	public Image getImage() {
		return image;
	}
	
}
