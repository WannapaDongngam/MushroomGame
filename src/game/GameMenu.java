package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameMenu extends JPanel implements ActionListener {
	JButton startButton, exitButton;

    private ImageIcon backgroundImage;
    public GameMenu() {
    	 startButton = new JButton("Start");
       startButton.setBounds(500,500,200,50);

       exitButton = new JButton("Exit");
       exitButton.setBounds(550,550,200,50);
       setVisible(true);
       add(exitButton);
       add(startButton);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        backgroundImage = new ImageIcon ("img\\14.png"); 
        backgroundImage.paintIcon(this, g, 0, 0);
        }
    }