package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Dashboard(){
		setBounds(0,0,1550,1000);
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,1550,1000);
		add(image);
		
		JLabel text=new JLabel("The Tajgroup Welcone Tou");
		text.setBounds(300,65,1000,60);
		text.setFont(new Font("Tahoma", Font.PLAIN, 50));
		text.setForeground(Color.white);
		image.add(text);
		
		//nenubar
		JMenuBar mb =new JMenuBar();
		mb.setBounds(0,0,1550, 50);
		image.add(mb);
		
		JMenu Hotel=new JMenu("HOTL MANAGEMENT");
		Hotel.setForeground(Color.RED);
		mb.add(Hotel);
		
		JMenuItem recepuion=new JMenuItem("Recepuion");
		recepuion.addActionListener(this);
		Hotel.add(recepuion);
		
		JMenu admin=new JMenu("ADMIN");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		JMenuItem addemployee=new JMenuItem("Add Employee");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		JMenuItem addRooms=new JMenuItem("Add Rooms");
		addRooms.addActionListener(this);
		admin.add(addRooms);
		JMenuItem addDrivers=new JMenuItem("Add Drivers");
		addDrivers.addActionListener(this);
		admin.add(addDrivers);
		
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add Employee")) {
			new AddEmployee();
		}else if (e.getActionCommand().equals("Add Rooms")) {
			new AddRooms();
		}else if (e.getActionCommand().equals("Add Drivers")) {
			new AddDriveers();
		}else if (e.getActionCommand().equals("Recepuion")) {
			new Reception();
		}
		
	}
	public static void main(String[] args) {
		new Dashboard();
	}

}
