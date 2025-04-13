package HotelManagemen;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
	JTextField username, pasword;
	JButton login, cancel;
	private static final long serialVersionUID = 1L;
	public Login() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		//labels
		JLabel user= new JLabel("UserName");
		user.setBounds(40,20,100,20);
		add(user);
		JLabel pass= new JLabel("PasWord");
		pass.setBounds(40,70,100,20);
		add(pass);
		
		//textfield
		username=new JTextField();
		username.setBounds(150,20,150,30);
		add(username);
		pasword=new JTextField();
		pasword.setBounds(150,70,150,30);
		add(pasword);
		
		//buttons
		login= new JButton("Login");
		login.setBounds(40, 150,120,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		cancel= new JButton("Cancel");
		cancel.setBounds(180, 150,120,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
		Image i2 =i1.getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350,10,200,200);
		add(image);
		
		setBounds(150,200,600, 300);
		setVisible(true);
	}
  
	public static void main(String[] args) {
		new Login();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			String user= username.getText();
			String pass=pasword.getText();
			try {
				conn c = new conn();
				String query ="select * from login where username ='"+ user +"'and password ='"+ pass +"'";
				ResultSet rs=c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Dashboard();
				
				}else {
					JOptionPane.showMessageDialog(null, "Imvalid credinsitials");
					setVisible(false);
				}
				} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(e.getSource()==cancel){
			 setVisible(false);
		}
		
	}

}
