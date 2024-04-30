package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame {
	static JFrame frame = new JFrame();
	static JButton startButton, exitButton;
	
	
    public static void main(String[] args) {
    	frame.setTitle("My Game");
    	frame.setSize(1000, 600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);

        // กำหนดขนาดหน้าต่างและตำแหน่งให้อยู่ตรงกลางของหน้าจอ
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int windowWidth = 1000;
        int windowHeight = 600;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;
        frame.setLocation(windowX, windowY);

        frame.setLayout(null);

        startButton = new JButton("Start");
        startButton.setBounds(400, 250, 200, 50);
        frame.add(startButton);
        startButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Backbrop game = new Backbrop();
        		frame.getContentPane().removeAll(); 
        		frame.add(game);
        		frame.revalidate(); 
        		frame.repaint(); 
                game.requestFocusInWindow();
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setBounds(400, 320, 200, 50);
        frame.add(exitButton);
        
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // เมื่อปุ่ม Start ถูกกด
                JOptionPane.showMessageDialog(null, "exitButton button clicked!");
                System.exit(0);
            }
        });

        frame.getContentPane().setBackground(Color.BLACK); // ตั้งค่าพื้นหลังเป็นสีดำ
        frame.setVisible(true);
    }
    public void backhome() {
    	frame.getContentPane().removeAll(); // ลบทุกคอมโพเนนต์ออกจาก JFrame
    	frame.add(startButton);
    	frame.add(exitButton);
		frame.revalidate(); // เรียกใช้ revalidate เพื่อให้การเปลี่ยนแปลงในการเรนเดอร์มีผล
		frame.repaint(); // รีเรนเดอร์ JFrame เพื่อให้การเปลี่ยนแปลงมีผล
    }
}
