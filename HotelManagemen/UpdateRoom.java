
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

public class UpdateRoom  extends JFrame implements ActionListener {
	Choice customrChoice;
	JTextField tfroom, tfavail,tfcstatus;
	JButton check, back, update;
	UpdateRoom(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("seventh.jpg"));
		Image i2 =i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image =new JLabel(i3); 
		image.setBounds(400,50,500,300);
		add(image);
		
		JLabel text =new JLabel("Update Room Status");
		text.setFont(new Font("Ralcway", getFont().PLAIN,30));
		text.setBounds(90,20,200,30);
		add(text);
		
		JLabel id =new JLabel("Customer Id");
		id.setFont(new Font("Ralcway", getFont().PLAIN,17));
		id.setBounds(30,80,100,20);
		add(id);
		
		customrChoice= new Choice();
		customrChoice.setBounds(200, 80,120,20);
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
		
		JLabel room =new JLabel("Room NNumber");
		room.setFont(new Font("Ralcway", getFont().PLAIN,17));
		room.setBounds(30,130,150,30);
		add(room);
		
		tfroom =new JTextField();
		tfroom.setFont(new Font("Ralcway", getFont().PLAIN,17));
		tfroom.setBounds(200,130,100,20);
		add(tfroom);
		
		JLabel name =new JLabel("Availability");
		name.setFont(new Font("Ralcway", getFont().PLAIN,17));
		name.setBounds(30,190,100,20);
		add(name);
		
		tfavail =new JTextField();
		tfavail.setFont(new Font("Ralcway", getFont().PLAIN,17));
		tfavail.setBounds(200,190,100,20);
		add(tfavail);
		
		JLabel cstatus =new JLabel("Cleaning Status");
		cstatus.setFont(new Font("Ralcway", getFont().PLAIN,17));
		cstatus.setBounds(30,240,150,30);
		add(cstatus);
		
		tfcstatus =new JTextField();
		tfcstatus.setFont(new Font("Ralcway", getFont().PLAIN,14));
		tfcstatus.setBounds(200,240,100,20);
		add(tfcstatus);
		
		check=new JButton("Check");
		check.setForeground(Color.white);
		check.setBackground(Color.BLACK);
		check.setBounds(30, 300, 100,30);
		check.addActionListener(this);
		add(check);
		
		update=new JButton("Updat");
		update.setForeground(Color.white);
		update.setBackground(Color.BLACK);
		update.setBounds(150, 300, 100,30);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(270, 300, 100,30);
		back.addActionListener(this);
		add(back);


		setBounds(150,150,940,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new UpdateRoom();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check) {
			String id = customrChoice.getSelectedItem();
			String quary= "select * from room where roomnumber = '"+id+"'";
			try {
				conn c= new conn();
				ResultSet rs = c.s.executeQuery(quary);
				while(rs.next()) {
					tfroom.setText(rs.getString("room"));						
				}
				ResultSet rs2= c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
				while(rs2.next()) {
					tfavail.setText(rs2.getString("avail_status"));
					tfcstatus.setText(rs2.getString("room_status"));
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
			String avaliable=tfavail.getText();
			String status=tfcstatus.getText();
			
			 try {
				conn c=new conn();
				c.s.executeUpdate("update room set roomnumber ='"+room+"',avail_status='"+avaliable+"', room_status='"+status+"' where roomnumber = '"+room+"'");
				JOptionPane.showMessageDialog(null, "Dat Updated successfully");
				setVisible(false);
				new Reception();
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}


	}

}
