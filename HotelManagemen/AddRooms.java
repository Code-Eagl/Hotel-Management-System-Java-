package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener{
	JTextField tfroom,tfroomprice;
	JComboBox availablecombo, statuscombo, typecombo;
	JButton add,cancel;
	public AddRooms() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading=new JLabel("Add Rooms");
		heading.setFont(new Font("Taboma",Font.BOLD, 30));
		heading.setBounds(150,20,300,20);
		add(heading);
		
		JLabel lb1Roomno=new JLabel("Room Number");
		lb1Roomno.setFont(new Font("Taboma", Font.PLAIN, 20));
		lb1Roomno.setBounds(60, 80,130,20);
		add(lb1Roomno);
		tfroom=new JTextField();
		tfroom.setBounds(220,80,150,30);
		add(tfroom);
		
		JLabel roomAvail=new JLabel("Available? ");
		roomAvail.setFont(new Font("Taboma", Font.PLAIN, 20));
		roomAvail.setBounds(60, 130,130,20);
		add(roomAvail);
		String availoptoion[]= {"Available","Occupied"};
		availablecombo=new JComboBox(availoptoion);
		availablecombo.setBounds(220,130,150,30);
		availablecombo.setBackground(Color.WHITE);
		add(availablecombo);
		
		JLabel roomstatus=new JLabel("Room Status? ");
		roomstatus.setFont(new Font("Taboma", Font.PLAIN, 20));
		roomstatus.setBounds(60, 180,132,20);
		add(roomstatus);
		String statusoptoion[]= {"Clean","Dirty"};
		statuscombo=new JComboBox(statusoptoion);
		statuscombo.setBounds(220,180,150,30);
		statuscombo.setBackground(Color.WHITE);
		add(statuscombo);
		
		JLabel lb1Roomprie=new JLabel("Room Price");
		lb1Roomprie.setFont(new Font("Taboma", Font.PLAIN, 20));
		lb1Roomprie.setBounds(60, 230,130,20);
		add(lb1Roomprie);
		tfroomprice=new JTextField();
		tfroomprice.setBounds(220,230,150,30);
		add(tfroomprice);
		
		JLabel roomtype=new JLabel("Room type? ");
		roomtype.setFont(new Font("Taboma", Font.PLAIN, 21));
		roomtype.setBounds(60, 280,130,20);
		add(roomtype);
		String typeoptoion[]= {"Single Bed","Double Bed"};
		typecombo=new JComboBox(typeoptoion);
		typecombo.setBounds(220,280,150,30);
		typecombo.setBackground(Color.WHITE);
		add(typecombo);
		
		add=new JButton("Add Room");
		add.setForeground(Color.white);
		add.setBackground(Color.BLACK);
		add.setBounds(60, 350, 130,30);
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220, 350, 130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(400,30,500,300);
		add(image);
		
		setBounds(150,150,940,470);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			String roomnumber=tfroom.getText();
			String avail_status=(String) availablecombo.getSelectedItem();
			String room_status=(String) statuscombo.getSelectedItem();
			String toom_price=tfroomprice.getText();
			String room_type=(String) typecombo.getSelectedItem();
			
			try {
				conn con=new conn();
				String quary = "insert into room values('"+roomnumber+"','"+avail_status+"','"+room_status+"','"+toom_price+"','"+room_type+"')";
				con.s.executeUpdate(quary);
				JOptionPane.showMessageDialog(null, "New Entry added successfully");
				} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new AddRooms();

	}

}
