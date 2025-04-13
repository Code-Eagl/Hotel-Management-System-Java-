package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDriveers extends JFrame implements ActionListener{
	JTextField tfname,tfage, tfcompany, tfmodel,tflocation;
	JComboBox gendercombo, availcombo;
	JButton add,cancel;
	public AddDriveers() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading=new JLabel("Add Drivers");
		heading.setFont(new Font("Taboma",Font.BOLD, 30));
		heading.setBounds(150,10,300,25);
		add(heading);
		
		JLabel name=new JLabel("Name");
		name.setFont(new Font("Taboma", Font.PLAIN, 20));
		name.setBounds(60, 60,130,20);
		add(name);
		tfname=new JTextField();
		tfname.setBounds(220,60,150,30);
		add(tfname);
		
		JLabel age=new JLabel("age?");
		age.setFont(new Font("Taboma", Font.PLAIN, 20));
		age.setBounds(60, 110,130,20);
		add(age);
		tfage=new JTextField();
		tfage.setBounds(220,110,150,30);
		add(tfage);
		
		JLabel gender=new JLabel("Your Gender? ");
		gender.setFont(new Font("Taboma", Font.PLAIN, 20));
		gender.setBounds(60, 160,132,20);
		add(gender);
		String genderopt[]= {"Female","Male"};
		gendercombo=new JComboBox(genderopt);
		gendercombo.setBounds(220,160,150,30);
		gendercombo.setBackground(Color.WHITE);
		add(gendercombo);
		
		JLabel carcompany=new JLabel("Car Comany");
		carcompany.setFont(new Font("Taboma", Font.PLAIN, 20));
		carcompany.setBounds(60, 210,130,20);
		add(carcompany);
		tfcompany=new JTextField();
		tfcompany.setBounds(220,210,150,30);
		add(tfcompany);
		
		JLabel carnodel=new JLabel("Car Model? ");
		carnodel.setFont(new Font("Taboma", Font.PLAIN, 21));
		carnodel.setBounds(60, 260,130,20);
		add(carnodel);
		tfmodel=new JTextField();
		tfmodel.setBounds(220,260,150,30);
		add(tfmodel);
		
		JLabel avail=new JLabel("is Available? ");
		avail.setFont(new Font("Taboma", Font.PLAIN, 20));
		avail.setBounds(60, 310,132,20);
		add(avail);
		String driveropt[]= {"Avaliable","Bussy"};
		availcombo=new JComboBox(driveropt);
		availcombo.setBounds(220,310,150,30);
		availcombo.setBackground(Color.WHITE);
		add(availcombo);
		
		JLabel location=new JLabel("Where is? ");
		location.setFont(new Font("Taboma", Font.PLAIN, 21));
		location.setBounds(60, 360,130,20);
		add(location);
		tflocation=new JTextField();
		tflocation.setBounds(220,360,150,30);
		add(tflocation);
		
		add=new JButton("Add Driver");
		add.setForeground(Color.white);
		add.setBackground(Color.BLACK);
		add.setBounds(60, 410, 130,30);
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220, 410, 130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
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
			String name=tfname.getText();
			String age=tfage.getText();
			String gender=(String) gendercombo.getSelectedItem();
			String company=tfcompany.getText();
			String brand=tfmodel.getText();
			String avaliable=(String) availcombo.getSelectedItem();
			String location=tflocation.getText();

			
			try {
				conn con=new conn();
				String quary = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+avaliable+"','"+location+"')";
				con.s.executeUpdate(quary);
				JOptionPane.showMessageDialog(null, "New Driver Entry added successfully");
				} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new AddDriveers();

	}

}
