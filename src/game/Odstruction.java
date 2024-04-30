package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Odstruction extends JPanel implements ActionListener{
	public int x,y,height,width,speed;
	private int xstart;
	
	public Odstruction(int x,int y,int h,int w,int speed,JPanel Backbrop) {
		this.x = x;
		this.xstart = x;
		this.y = y;
		this.height = h;
		this.width = w;
		this.speed = speed;
		move(Backbrop);
		
	}
	public void move(JPanel Backbrop) {
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x -= speed;
				Backbrop.repaint();
				if(x < 0) {
					x = xstart;
				}
			}
		});
		timer.start();
	}
    
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img\\12.png"));
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
