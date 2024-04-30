package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Character extends JPanel implements ActionListener{
	public int x,y,blood,point;
	public int characterSize, jump_y = 150;
	
	public Character(int x,int y,int characterSize,int blood,int point) {
		this.x = x;
		this.y = y;
		this.characterSize = characterSize;
		this.blood = blood;
		this.point = point;
		
		
    }
	public void jump(JPanel Backbrop ) {
		this.y -= jump_y;
		Backbrop.repaint();
		Timer timer = new Timer(150,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				y += jump_y;
				Backbrop.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
    }
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img\\11.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

