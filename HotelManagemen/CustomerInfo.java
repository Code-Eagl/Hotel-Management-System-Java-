package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class CustomerInfo extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	public CustomerInfo(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text =new JLabel("Customer Information");
		text.setFont(new Font("Ralcway", getFont().PLAIN, 30));
		text.setBounds(250,40,400,30);
		add(text);
		
		JLabel l1 =new JLabel("Document");
		l1.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l1.setBounds(40,100,100,20);
		add(l1);
		JLabel l2 =new JLabel("Number");
		l2.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l2.setBounds(150,100,100,20);
		add(l2);
		JLabel l3 =new JLabel("Name");
		l3.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l3.setBounds(260,100,100,20);
		add(l3);
		JLabel l4 =new JLabel("Gender");
		l4.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l4.setBounds(370,100,100,20);
		add(l4);
		JLabel l5 =new JLabel("Country");
		l5.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l5.setBounds(490,100,100,20);
		add(l5);
		JLabel l6 =new JLabel("Room No");
		l6.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l6.setBounds(610,100,100,20);
		add(l6);
		JLabel l7 =new JLabel("Checkin time");
		l7.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l7.setBounds(730,100,100,20);
		add(l7);
		
		
		table =new JTable();
		table.setFont(new Font("Ralcway", getFont().PLAIN,15));
		table.setBounds(10,150,940,500);
		add(table);
		
		try {
			conn con=new conn();
			ResultSet rs =con.s.executeQuery("select * from customer");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colname= new String[cols];
			for(int i=0;i<cols;i++) {
				colname[i]=rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colname);
			String name,age,gender,job,salary, phone, email, adhar;
			while (rs.next()){
				name=rs.getString(1);
				age=rs.getString(2);
				gender=rs.getString(3);
				job=rs.getString(4);
				salary=rs.getString(5);
				phone=rs.getString(6);
				email=rs.getString(7);
				adhar=rs.getString(8);

				String[] row = {name,age,gender,job,salary, phone, email, adhar};
				model.addRow(row);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(750,35,100,20);
		back.addActionListener(this);
		add(back);	
		
		
		setBounds(150,150,940,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new CustomerInfo();

	}

}



	



	
