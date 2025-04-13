package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{
	JButton newCustomer, rooms, customer, depertment, allemployee,
	 		managerinfo,checkout,update, roomstatus,pickup, searchroom, logout;
	public Reception() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		newCustomer=new JButton("New Customer");
		newCustomer.setFont(new Font("Taboma",Font.BOLD, 22));
		newCustomer.setBounds(10,30,200,30);
		newCustomer.setForeground(Color.white);
		newCustomer.setBackground(Color.black);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms=new JButton("Rooms");
		rooms.setFont(new Font("Taboma",Font.BOLD, 22));
		rooms.setBounds(10,70,200,30);
		rooms.setForeground(Color.white);
		rooms.setBackground(Color.black);
		rooms.addActionListener(this);
		add(rooms);
		
		depertment=new JButton("Depertments");
		depertment.setFont(new Font("Taboma",Font.BOLD, 22));
		depertment.setBounds(10,110,200,30);
		depertment.setForeground(Color.white);
		depertment.setBackground(Color.black);
		depertment.addActionListener(this);
		add(depertment);
		
		allemployee=new JButton("All Employee");
		allemployee.setFont(new Font("Taboma",Font.BOLD, 22));
		allemployee.setBounds(10,150,200,30);
		allemployee.setForeground(Color.white);
		allemployee.setBackground(Color.black);
		allemployee.addActionListener(this);
		add(allemployee);
		
		managerinfo=new JButton("Manager Info");
		managerinfo.setFont(new Font("Taboma",Font.BOLD, 22));
		managerinfo.setBounds(10,190,200,30);
		managerinfo.setForeground(Color.white);
		managerinfo.setBackground(Color.black);
		managerinfo.addActionListener(this);
		add(managerinfo);
		
		customer=new JButton("Customer");
		customer.setFont(new Font("Taboma",Font.BOLD, 22));
		customer.setBounds(10,230,200,30);
		customer.setForeground(Color.white);
		customer.setBackground(Color.black);
		customer.addActionListener(this);
		add(customer);
		
		checkout=new JButton("checkout");
		checkout.setFont(new Font("Taboma",Font.BOLD, 22));
		checkout.setBounds(10,270,200,30);
		checkout.setForeground(Color.white);
		checkout.setBackground(Color.black);
		checkout.addActionListener(this);
		add(checkout);
		
		update=new JButton("Update Status");
		update.setFont(new Font("Taboma",Font.BOLD, 22));
		update.setBounds(10,310,200,30);
		update.setForeground(Color.white);
		update.setBackground(Color.black);
		update.addActionListener(this);
		add(update);
		
		roomstatus=new JButton("Room Status");
		roomstatus.setFont(new Font("Taboma",Font.BOLD, 22));
		roomstatus.setBounds(10,350,200,30);
		roomstatus.setForeground(Color.white);
		roomstatus.setBackground(Color.black);
		roomstatus.addActionListener(this);
		add(roomstatus);
		
		pickup=new JButton("Pickup");
		pickup.setFont(new Font("Taboma",Font.BOLD, 22));
		pickup.setBounds(10,390,200,30);
		pickup.setForeground(Color.white);
		pickup.setBackground(Color.black);
		pickup.addActionListener(this);
		add(pickup);
		
		searchroom=new JButton("search Room");
		searchroom.setFont(new Font("Taboma",Font.BOLD, 22));
		searchroom.setBounds(10,430,200,30);
		searchroom.setForeground(Color.white);
		searchroom.setBackground(Color.black);
		searchroom.addActionListener(this);
		add(searchroom);
		
		logout=new JButton("logout");
		logout.setFont(new Font("Taboma",Font.BOLD, 22));
		logout.setBounds(350,430,200,30);
		logout.setForeground(Color.white);
		logout.setBackground(Color.black);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(250, 30,500,370);
		add(image);
		
		setBounds(160,150,800,510);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newCustomer) {
			setVisible(false);
			new AddCustomer();
		}else if(e.getSource()==rooms) {
			setVisible(false);
			new Room();
		}else if(e.getSource()==depertment) {
			setVisible(false);
			new Department();
		}else if(e.getSource()==allemployee) {
			setVisible(false);
			new EmployeeImfo();
		}else if(e.getSource()==managerinfo) {
			setVisible(false);
			new ManagerInfo();
		}else if(e.getSource()==customer) {
			setVisible(false);
			new CustomerInfo();
		}else if(e.getSource()==roomstatus) {
			setVisible(false);
			new UpdateRoom();
		}else if(e.getSource()==update) {
			setVisible(false);
			new UpdateCheck();
		}else if(e.getSource()==searchroom) {
			setVisible(false);
			new SearchRoom();
		}else if(e.getSource()==pickup) {
			setVisible(false);
			new Pickup();
		}else if(e.getSource()==checkout) {
			setVisible(false);
			new CheckOut();
		}else if(e.getSource()==logout){
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Reception();

	}

}
