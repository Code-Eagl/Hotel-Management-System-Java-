package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.concurrent.SubmissionPublisher;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.html.FormSubmitEvent;

import org.w3c.dom.CDATASection;

public class AddEmployee extends JFrame implements ActionListener{
	JTextField tfname,tfage, tfsalory, tfphone,tfemail,tfadhar;
	JRadioButton female,male;
	JComboBox cbjob;
	JButton submit;
	public AddEmployee() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text=new JLabel("Add Employee");
		text.setFont(new Font("Taboma",Font.BOLD, 30));
		text.setBounds(460,30,300,30);
		add(text);
		
		//name
		JLabel name=new JLabel("Name");
		name.setFont(new Font("Taboma",Font.BOLD, 17));
		name.setBounds(60,30,120,30);
		add(name);
		tfname =new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		//name
		JLabel age=new JLabel("Age");
		age.setFont(new Font("Taboma",Font.BOLD, 17));
		age.setBounds(60,80,120,30);
		add(age);
		tfage =new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		//gender
		JLabel gender=new JLabel("Gender");
		gender.setFont(new Font("Taboma",Font.BOLD, 17));
		gender.setBounds(60,130,120,30);
		add(gender);
		female =new JRadioButton("Female");
		female.setBounds(200,130,80,30);
		female.setFont(new Font("Taboma",Font.PLAIN, 14));
		female.setBackground(Color.WHITE);
		add(female);
		male =new JRadioButton("Male");
		male.setBounds(280,130,90,30);
		male.setFont(new Font("Taboma",Font.PLAIN, 14));
		male.setBackground(Color.WHITE);
		add(male);
		ButtonGroup bg=new ButtonGroup();
		bg.add(female);
		bg.add(male);
		
		//job
		JLabel job=new JLabel("Job");
		job.setFont(new Font("Taboma",Font.BOLD, 17));
		job.setBounds(60,180,120,30);
		add(job);
		String str[] = {"Front Dest Coerks","Portters","Housekeeping","Kitchen Staff","Roon Service","Water/Wetresses","Manager","Acountants"};
		cbjob=new JComboBox(str);
		cbjob.setBackground(Color.WHITE);
		cbjob.setBounds(200,180,150,30);
		add(cbjob);
		
		//Salory
		JLabel salory=new JLabel("Salory");
		salory.setFont(new Font("Taboma",Font.BOLD, 17));
		salory.setBounds(60,230,120,30);
		add(salory);
		tfsalory =new JTextField();
		tfsalory.setBounds(200,230,150,30);
		add(tfsalory);
		
		//phone no
		JLabel phone=new JLabel("Phone");
		phone.setFont(new Font("Taboma",Font.BOLD, 17));
		phone.setBounds(60,280,120,30);
		add(phone);
		tfphone =new JTextField();
		tfphone.setBounds(200,280,150,30);
		add(tfphone);
		
		//email
		JLabel email=new JLabel("Email");
		email.setFont(new Font("Taboma",Font.BOLD, 17));
		email.setBounds(60,330,120,30);
		add(email);
		tfemail =new JTextField();
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		//adhar
		JLabel adhar=new JLabel("Adhar");
		adhar.setFont(new Font("Taboma",Font.BOLD, 17));
		adhar.setBounds(60,380,120,30);
		add(adhar);
		tfadhar =new JTextField();
		tfadhar.setBounds(200,380,150,30);
		add(tfadhar);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(160, 428,150,30);
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
		Image i2 =i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(380,60,450,380);
		add(image);
		
		setBounds(150,150,940,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=tfname.getText();
		String age=tfage.getText();
		String phone=tfphone.getText();
		String salory=tfsalory.getText();
		String email=tfemail.getText();
		String adhar=tfadhar.getText();
		
		String gender=null;
		if (male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}
		
		String job=(String) cbjob.getSelectedItem();
		try {
			conn con=new conn();
			String quary = "insert into employee values('"+name+"','"+avail_status+"','"+gender+"','"+job+"','"+salory+"','"+phone+"','"+email+"','"+adhar+"')";
			con.s.executeUpdate(quary);
			JOptionPane.showMessageDialog(null, "Employee added Successfully");
			setVisible(false);
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new AddEmployee(); 

	}

}
