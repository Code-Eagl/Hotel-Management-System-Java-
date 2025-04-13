package HotelManagemen;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck  extends JFrame implements ActionListener {
	Choice customrChoice;
	JTextField tfroom, tfname,tftime ,tfamont,tfpending;
	JButton check, back, update;
	UpdateCheck(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
		JLabel image =new JLabel(i1); 
		image.setBounds(400,50,500,300);
		add(image);
		
		JLabel text =new JLabel("Update customer Room Status");
		text.setFont(new Font("Ralcway", getFont().PLAIN,30));
		text.setBounds(80,20,600,50);
		add(text);
		
		JLabel id =new JLabel("Customer Id");
		id.setFont(new Font("Ralcway", getFont().PLAIN,17));
		id.setBounds(30,80,100,20);
		add(id);
		
		customrChoice= new Choice();
		customrChoice.setBounds(200, 80,150,20);
		add(customrChoice);
		
		try {
			conn c=new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				customrChoice.add(rs.getString("number"));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel room =new JLabel("Room No");
		room.setFont(new Font("Ralcway", getFont().PLAIN,17));
		room.setBounds(30,120,100,20);
		add(room);
		
		tfroom =new JTextField();
		tfroom.setFont(new Font("Ralcway", getFont().PLAIN,17));
		tfroom.setBounds(200,120,100,20);
		add(tfroom);
		
		JLabel name =new JLabel("Name");
		name.setFont(new Font("Ralcway", getFont().PLAIN,17));
		name.setBounds(30,160,100,20);
		add(name);
		
		tfname =new JTextField();
		tfname.setFont(new Font("Ralcway", getFont().PLAIN,17));
		tfname.setBounds(200,160,100,20);
		add(tfname);
		
		JLabel ctime =new JLabel("Checkin Time");
		ctime.setFont(new Font("Ralcway", getFont().PLAIN,17));
		ctime.setBounds(30,200,100,30);
		add(ctime);
		
		tftime =new JTextField();
		tftime.setFont(new Font("Ralcway", getFont().PLAIN,14));
		tftime.setBounds(200,200,100,20);
		add(tftime);
		
		JLabel pamount =new JLabel("Amount Paid");
		pamount.setFont(new Font("Ralcway", getFont().PLAIN,17));
		pamount.setBounds(30,240,100,20);
		add(pamount);
		
		tfamont =new JTextField();
		tfamont.setFont(new Font("Ralcway", getFont().PLAIN,17));
		tfamont.setBounds(200,240,100,20);
		add(tfamont);
		
		JLabel pending =new JLabel("Amount Pending");
		pending.setFont(new Font("Ralcway", getFont().PLAIN,17));
		pending.setBounds(30,280,100,20);
		add(pending);
		
		tfpending =new JTextField();
		tfpending.setBounds(200,280,100,20);
		add(tfpending);
		
		check=new JButton("Check");
		check.setForeground(Color.white);
		check.setBackground(Color.BLACK);
		check.setBounds(30, 340, 100,30);
		check.addActionListener(this);
		add(check);
		
		update=new JButton("Updat");
		update.setForeground(Color.white);
		update.setBackground(Color.BLACK);
		update.setBounds(150, 340, 100,30);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(270, 340, 100,30);
		back.addActionListener(this);
		add(back);


		setBounds(150,150,940,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new UpdateCheck();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check) {
			String id = customrChoice.getSelectedItem();
			String quary= "select * from customer where number = '"+id+"'";
			try {
				conn c= new conn();
				ResultSet rs = c.s.executeQuery(quary);
				while(rs.next()) {
					tfroom.setText(rs.getString("room"));
					tfname.setText(rs.getString("name"));
					tftime.setText(rs.getString("checkin_time"));
					tfamont.setText(rs.getString("deposite"));	
				}
				ResultSet rs2= c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
				while(rs2.next()) {
					String price= rs2.getString("toom_price");
					int amountpaid =Integer.parseInt(price)-Integer.parseInt(tfamont.getText());
					tfpending.setText(""+amountpaid);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
			
		}else if(e.getSource()==update) {
			String id = customrChoice.getSelectedItem();
			String room= tfroom.getText();
			String name = tfname.getText();
			String checkin = tftime.getText();
			String deposte=tfamont.getText();
			 try {
				conn c=new conn();
				c.s.executeUpdate("update customer set room ='"+room+"', name ='"+name+"', checkin_time='"+checkin+"', deposite='"+deposte+"'where number ='"+id+"'");
				JOptionPane.showMessageDialog(null, "Dat Updated successfully");
				setVisible(false);
				new Reception();
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}


	}

}
