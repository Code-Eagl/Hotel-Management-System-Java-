package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;

import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;



public class SearchRoom extends JFrame implements ActionListener{
	JTable table;
	JButton back, Submit;
	JComboBox cbedType;
	JCheckBox isavaliable;
	public SearchRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text =new JLabel("Search for Room");
		text.setFont(new Font("Ralcway", getFont().PLAIN,17));
		text.setBounds(400,50,200,20);
		add(text);
		
		JLabel bedtype =new JLabel("Which Bed Type");
		bedtype.setFont(new Font("Ralcway", getFont().PLAIN,17));
		bedtype.setBounds(60,100,150,30);
		add(bedtype);
		cbedType =new JComboBox(new String[] {"Single Bed","Double Bed"});
		cbedType.setBounds(200,100,150,25);
		cbedType.setBackground(Color.WHITE);
		add(cbedType);
		
		isavaliable=new JCheckBox("Only Display Avaliable");
		isavaliable.setBounds(550, 100, 150,25);
		isavaliable.setBackground(Color.WHITE);
		add(isavaliable);
		
		
		JLabel l1 =new JLabel("Room No");
		l1.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l1.setBounds(170,170,100,20);
		add(l1);
		JLabel l2 =new JLabel("Is Avail");
		l2.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l2.setBounds(292,170,100,20);
		add(l2);
		JLabel l3 =new JLabel("Status");
		l3.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l3.setBounds(423,170,100,20);
		add(l3);
		JLabel l4 =new JLabel("Price");
		l4.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l4.setBounds(544,170,100,20);
		add(l4);
		JLabel l5 =new JLabel("Type");
		l5.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l5.setBounds(665,170,100,20);
		add(l5);
		
		table =new JTable();
		table.setFont(new Font("Ralcway", getFont().PLAIN,15));
		table.setBounds(150,200,600,500);
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
		
		Submit=new JButton("Submit");
		Submit.setForeground(Color.white);
		Submit.setBackground(Color.BLACK);
		Submit.setBounds(800,90,100,20);
		Submit.addActionListener(this);
		add(Submit);	
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(800,120,100,20);
		back.addActionListener(this);
		add(back);	
		
		
		setBounds(150,150,940,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==Submit) {
			try {
				String quary1="select * from room where room_type= '"+cbedType.getSelectedItem()+"'";
				String quary2="select * from room where avail_status = 'Available' ANd room_type ='"+cbedType.getSelectedItem()+"'";
				conn con= new conn();
				ResultSet rs;
				if(isavaliable.isSelected()) {
					rs=con.s.executeQuery(quary2);
				}else {
					rs=con.s.executeQuery(quary1);
				}
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
				} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else {
			setVisible(false);
			new Reception();		
		}
		
		
	}

	public static void main(String[] args) {
		new SearchRoom();

	}

}

