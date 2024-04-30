package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class Event extends JPanel implements ActionListener{
	public static boolean checkHit1(Character ch,Odstruction od) {
		if(ch.x + ch.characterSize > od.x && ch.x < od.x) {
			if(ch.y + ch.characterSize >= od.y - od.height) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean checkCoin(Character ch,Coin c) {
		if(ch.x + ch.characterSize > c.x && ch.x < c.x) {
			if(ch.y + ch.characterSize >= c.y - c.coinSize) {
				return true;
			}
		}
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
