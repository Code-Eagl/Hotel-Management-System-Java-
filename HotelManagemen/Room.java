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

public class Room extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	public Room() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
		Image i2 =i1.getImage().getScaledInstance(480, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image =new JLabel(i3); 
		image.setBounds(480,30,500,300);
		add(image);
		
		JLabel l1 =new JLabel("Room No");
		l1.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l1.setBounds(25,90,100,20);
		add(l1);
		JLabel l2 =new JLabel("Is Avail");
		l2.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l2.setBounds(112,90,100,20);
		add(l2);
		JLabel l3 =new JLabel("Status");
		l3.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l3.setBounds(213,90,100,20);
		add(l3);
		JLabel l4 =new JLabel("Price");
		l4.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l4.setBounds(304,90,100,20);
		add(l4);
		JLabel l5 =new JLabel("Type");
		l5.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l5.setBounds(405,90,100,20);
		add(l5);
		
		table =new JTable();
		table.setFont(new Font("Ralcway", getFont().PLAIN,15));
		table.setBounds(20,110,456,400);
		add(table);
		
		try {
			conn con=new conn();
			ResultSet rs =con.s.executeQuery("select * from room");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colname= new String[cols];
			for(int i=0;i<cols;i++) {
				colname[i]=rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colname);
			String roomnumber,avail_status,room_status,toom_price,room_type;
			while (rs.next()){
				roomnumber=rs.getString(1);
				avail_status=rs.getString(2);
				room_status=rs.getString(3);
				toom_price=rs.getString(4);
				room_type=rs.getString(5);
				String[] row = {roomnumber,avail_status,room_status,toom_price,room_type};
				model.addRow(row);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(200,50,100,20);
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
		new Room();

	}

}
