package HotelManagemen;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import javax.print.attribute.standard.RequestingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.*;


public class AddCustomer extends JFrame implements ActionListener{
	JTextField tfnumber, tfname,tfcountry,tfdeposite;
	JComboBox userid;
	JRadioButton rmale, rfemale;
	JLabel checkin ;
	Choice croom;
	JButton back,add;
		public AddCustomer() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("New Customer Form");
		text.setBounds(100, 20, 300, 30);
		text.setFont(new Font("Ralcway", getFont().PLAIN, 30));
		add(text);
		
		JLabel id = new JLabel("ID");
		id.setBounds(40, 80, 100, 30);
		id.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(id);
		
		String options[] = {"Adhar Card", "Passport", "Driving License", "Voter Id Card", "Ration Card"};
		userid = new JComboBox(options);
		userid.setBounds(200,80,150,25 );
		userid.setBackground(Color.white);
		add(userid);
		
		JLabel number = new JLabel("Number");
		number.setBounds(40, 120, 100, 30);
		number.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(number);
		
		tfnumber=  new JTextField();
		tfnumber.setBounds(200, 120,150,25);
		add(tfnumber);
		
		JLabel name = new JLabel("Name");
		name.setBounds(40, 160, 100, 30);
		name.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(200, 160,150,25);
		add(tfname);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(40, 200, 100, 30);
		gender.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(gender);
		
		rmale =new JRadioButton("Male")	;
		userid.setBackground(Color.white);
		rmale.setBounds(200,200,60,25);
		add(rmale);
		rfemale =new JRadioButton("Female")	;
		rfemale.setBackground(Color.white);
		rfemale.setBounds(270,200,100,25);
		add(rfemale);
		
		JLabel country = new JLabel("Country");
		country.setBounds(40, 240, 100, 30);
		country.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(country);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(200, 240,150,25);
		add(tfcountry);
		
		JLabel alroom = new JLabel("RoomNo");
		alroom.setBounds(40, 280, 100, 25);
		alroom.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(alroom);
		
		croom =new Choice();
		try {
			conn con=new conn();
			String quary= "select * from room";
			ResultSet rs = con.s.executeQuery(quary);
			while (rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		croom.setBounds(200,290,150,30);
		add(croom);
		
		JLabel time = new JLabel("checkin time");
		time.setBounds(40, 320, 100, 25);
		time.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(time);
		
		java.util.Date date=new java.util.Date();
		checkin = new JLabel(" "+date);
		checkin.setBounds(200, 320, 200, 25);
		checkin.setFont(new Font("Ralcway", getFont().PLAIN, 17));
		add(checkin);
		
		JLabel deposite = new JLabel("eposite");
		deposite.setBounds(40, 360, 100, 30);
		deposite.setFont(new Font("Ralcway", getFont().PLAIN, 20));
		add(deposite);
		
		tfdeposite  = new JTextField();
		tfdeposite.setBounds(200, 360,150,25);
		add(tfdeposite);
		
		add=new JButton("Add");
		add.setForeground(Color.white);
		add.setBackground(Color.BLACK);
		add.setBounds(50, 410, 130,30);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(240, 410, 130,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,30,500,300);
		add(image);

		setBounds(150,150,940,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			String document=(String) userid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender=null;
			if (rfemale.isSelected()) {
				gender="Female";
			}else {
				gender="Male";
			}
			String country=tfcountry.getText();
			String room= croom.getSelectedItem();
			String checkin_time= checkin.getText();
			String deposite=tfdeposite.getText();
			try {
				String quary = "insert into customer values('"+document+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+checkin_time+"','"+deposite+"')";
				String quary2="update room set avail_status='Occupied' where roomnumber = '"+room+"' ";
				conn con= new conn();
				con.s.executeUpdate(quary);
				con.s.executeUpdate(quary2);
				JOptionPane.showMessageDialog(null, "New Customer Added" );
				setVisible(false);
				new Reception();

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}	
	}

	public static void main(String[] args) {
		new AddCustomer();
	}

}
