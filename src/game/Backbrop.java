package game;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Backbrop extends JPanel implements KeyListener {
	int backbropspeed = 20;
	Character ch = new Character(50,360,50,100,0);
	Odstruction od = new Odstruction(700,400,30,20,20,this);
	Game hoemGame;
	
	Coin c = new Coin(700,200,20,20,this);
	private Odstruction[] odstructionSet =  maKeodstruction(4);
	private Coin[] coinSet =  maKeCoin(4);
    public Backbrop() {
        this.setBounds(0, 0, 1000, 600);
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(this);
        hoemGame = new Game();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            drawBackground(g2d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font("Arial", Font.PLAIN, 16); // แบบอักษร Arial, ขนาด 16
        g2d.setFont(font);
        
        g2d.setColor(Color.GRAY);
        g2d.drawImage(ch.getImage(),ch.x,ch.y,ch.characterSize,ch.characterSize,null);
        g2d.drawString(ch.blood+"%", 40, 30);
        g2d.drawString("point " + ch.point, 40, 50);
        for (Odstruction od : odstructionSet) {
            g2d.setColor(Color.RED);
            g2d.drawImage(od.getImage(),od.x, od.y, od.width, od.height,null);
            if(Event.checkHit1(ch, od)) {
                g2d.setStroke(new BasicStroke(5.0f));
                g2d.setColor(Color.RED);
                g2d.drawRect(0, 0, 1000, 1000);
                ch.blood -= 5;
                if (ch.blood  == 0) {
                	JOptionPane.showMessageDialog(null, "Game Over !!! ");
                    hoemGame.backhome(); 
                }
                
            }
        }
        
        for (Coin c : coinSet) {
            g2d.setColor(Color.PINK);
            g2d.drawImage(c.getImage(),c.x,c.y,c.coinSize,c.coinSize,null);
            if(Event.checkCoin(ch, c)) {
            	g2d.setStroke(new BasicStroke(5.0f));
            	g2d.setColor(Color.PINK);
            	g2d.drawRect(0, 0, 1000, 900);
            	ch.point += 1;
            }
         }
       
     }
  
	private Odstruction[] maKeodstruction(int num) {
    	Odstruction[] odstructionSet = new Odstruction[num];
    	for(int i = 0;i < num;i++) {
    		double odLocation = 1000+Math.floor(Math.random()*1000);
    		odstructionSet[i] = new Odstruction((int)odLocation,370,40,20,50,this);
    	}
		return odstructionSet;
    }
	
    private Coin[] maKeCoin(int num) {
		Coin[] coinSet = new Coin[num];
    	for(int i = 0;i < num;i++) {
    		double cLocation = 1000+Math.floor(Math.random()*1000);
    		coinSet[i] = new Coin((int)cLocation,360,20,50,this);
    	}
		return coinSet;
    }
	
	
	private void drawBackground(Graphics2D g2d) throws IOException {
	    g2d.drawImage(ImageIO.read(new File("img\\9.png")), 0, 0, 1000, 1000, null);
	    g2d.drawImage(ImageIO.read(new File("img\\10.png")), 0, 400, 2000, 600, null);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==38||e.getKeyCode()==32) {
			ch.jump(this);
			this.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

    
}
