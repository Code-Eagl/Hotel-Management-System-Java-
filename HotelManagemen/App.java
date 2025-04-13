package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame implements ActionListener{
	public App() {
		setSize(966, 445);
		setLocation(100,100);
		setLayout(null);
		
		//image and text
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(0,0,966,445);
		add(image);
		JLabel text=new JLabel("Hotel Management Syatem");
		text.setBounds(20,340,600,50);
		text.setForeground(Color.white);
		text.setFont(new Font("serif", Font.PLAIN, 50));
		image.add(text);
		
		//next button
		JButton next=new JButton("Next");
		next.setBounds(800, 360, 100,30);
		next.setBackground(Color.white);
		next.setForeground(Color.BLUE);
		next.addActionListener(this);
		next.setFont(new Font("serif", Font.PLAIN, 30));
		image.add(next);
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent ac) {
		setVisible(false);
		new Login();
	}

	public static void main(String[] args) {
		new App();

	}

}
