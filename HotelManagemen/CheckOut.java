package HotelManagemen;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.foreign.Addressable;
import java.nio.file.LinkOption;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class CheckOut extends JFrame implements ActionListener{
	Choice cid;
	JLabel roomno, ctime, cotime, aname;
	JButton checkout, back, check;
	CheckOut(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(310,80,20,20);
		add(image);
		
		JLabel text =new JLabel("Checkout From Hotel");
		text.setFont(new Font("Ralcway", getFont().PLAIN,30));
		text.setBounds(100,30,300,25);
		add(text);
		
		JLabel id =new JLabel("Customer Id");
		id.setFont(new Font("Ralcway", getFont().PLAIN,17));
		id.setBounds(40,80,100,20);
		add(id);
		cid = new Choice();
		cid.setBounds(180, 80,120,20);
		add(cid);
		
		
		JLabel room =new JLabel("Room Mo");
		room.setFont(new Font("Ralcway", getFont().PLAIN,20));
		room.setBounds(40,130,200,20);
		add(room);
		roomno =new JLabel("");
		roomno.setFont(new Font("Ralcway", getFont().PLAIN,20));
		roomno.setBounds(180,130,200,20);
		add(roomno);
		
		JLabel cin =new JLabel("Checkin Time");
		cin.setFont(new Font("Ralcway", getFont().PLAIN,20));
		cin.setBounds(40,180,200,20);
		add(cin);
		ctime =new JLabel("");
		ctime.setFont(new Font("Ralcway", getFont().PLAIN,20));
		ctime.setBounds(180,180,200,20);
		add(ctime);
		
		JLabel cout =new JLabel("Checkout time");
		cout.setFont(new Font("Ralcway", getFont().PLAIN,20));
		cout.setBounds(40,230,200,20);
		add(cout);
		java.util.Date date=new java.util.Date();
		cotime =new JLabel("" + date);
		cotime.setFont(new Font("Ralcway", getFont().PLAIN,17));
		cotime.setBounds(180,230,200,20);
		add(cotime);
		
		JLabel name =new JLabel("Customer Name :-");
		name.setFont(new Font("Ralcway", getFont().PLAIN,30));
		name.setBounds(100,350,250,25);
		add(name);
		aname =new JLabel("Customer want to Checkout");
		aname.setFont(new Font("Ralcway", getFont().PLAIN,37));
		aname.setBounds(350,350,500,30);
		add(aname);
		
		try {
			conn c= new conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			while(rs.next()) {
				cid.add(rs.getString("number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		check=new JButton("Check");
		check.setForeground(Color.white);
		check.setBackground(Color.BLACK);
		check.setBounds(50, 280, 100,30);
		check.addActionListener(this);
		add(check);
		
		checkout=new JButton("Checkout");
		checkout.setForeground(Color.white);
		checkout.setBackground(Color.BLACK);
		checkout.setBounds(170, 280, 100,30);
		checkout.addActionListener(this);
		add(checkout);
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(300, 280, 100,30);
		back.addActionListener(this);
		add(back);

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel imagee=new JLabel(i6);
		imagee.setBounds(450,50,400,250);
		add(imagee);
		
		setBounds(150,150,940,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckOut();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==checkout) {
			String quary ="delete from customer where number ='"+cid.getSelectedItem()+"'";
			String quary2="update room set avail_status='Available' where roomnumber ='"+roomno.getText()+"' ";
			
			try {
				conn c=new conn();
				c.s.executeUpdate(quary);
				c.s.executeUpdate(quary2);
				JOptionPane.showMessageDialog(null, "Checkout Done");
				
				setVisible(false);
				new Reception();
				
			} catch (Exception e2) {
				e2.printStackTrace();			}
		}else if(e.getSource()==check) {
			String id = cid.getSelectedItem();
			String quary= "select * from customer where number = '"+id+"'";
			try {
				conn c= new conn();
				ResultSet rs = c.s.executeQuery(quary);
				while(rs.next()) {
					roomno.setText(rs.getString("room"));
					ctime.setText(rs.getString("checkin_time"));
					aname.setText(rs.getString("name"));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		 }else {
			setVisible(false);
			new Reception();
		}
		
	}

}
