package HotelManagemen;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Pickup extends JFrame implements  ActionListener{

	JTable table;
	JButton back, Submit;
	JComboBox cbedType;
	Choice carType;
	JCheckBox isavaliable;
	public Pickup() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text =new JLabel("Pickup Survie");
		text.setFont(new Font("Ralcway", getFont().PLAIN,17));
		text.setBounds(400,50,200,20);
		add(text);
		
		JLabel bedtype =new JLabel("Tyoe of car");
		bedtype.setFont(new Font("Ralcway", getFont().PLAIN,17));
		bedtype.setBounds(60,100,130,30);
		add(bedtype);
		carType = new Choice();
		carType.setBounds(200, 100,120,20);
		add(carType);
		try {
			conn c= new conn();
			ResultSet rs=c.s.executeQuery("select * from driver");
			while(rs.next()) {
				carType.add(rs.getString("model"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel l1 =new JLabel("Name");
		l1.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l1.setBounds(120,170,100,20);
		add(l1);
		JLabel l2 =new JLabel("Age");
		l2.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l2.setBounds(220,170,100,20);
		add(l2);
		JLabel l3 =new JLabel("GEnder");
		l3.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l3.setBounds(320,170,100,20);
		add(l3);
		JLabel l4 =new JLabel("Comany");
		l4.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l4.setBounds(420,170,100,20);
		add(l4);
		JLabel l5 =new JLabel(
				"Model");
		l5.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l5.setBounds(520,170,100,20);
		add(l5);
		JLabel l6 =new JLabel("Is Avaiable");
		l6.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l6.setBounds(610,170,100,20);
		add(l6);
		JLabel l7 =new JLabel("Location");
		l7.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l7.setBounds(710,170,100,20);
		add(l7);
		
		table =new JTable();
		table.setFont(new Font("Ralcway", getFont().PLAIN,15));
		table.setBounds(100,200,700,500);
		add(table);
		
		try {
			conn con=new conn();
			ResultSet rs =con.s.executeQuery("select * from driver");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colname= new String[cols];
			for(int i=0;i<cols;i++) {
				colname[i]=rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colname);
			String name,age,gender,comany,modal,avaliable,location;
			while (rs.next()){
				name=rs.getString(1);
				age=rs.getString(2);
				gender=rs.getString(3);
				comany=rs.getString(4);
				modal=rs.getString(5);
				avaliable=rs.getString(6);
				location=rs.getString(7);
				String[] row = {name,age,gender,comany,modal,avaliable, location};
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
				String quary="select * from driver where model= '"+carType.getSelectedItem()+"'";
				conn con= new conn();
				ResultSet rs;
				rs=con.s.executeQuery(quary);
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colname= new String[cols];
				for(int i=0;i<cols;i++) {
					colname[i]=rsmd.getColumnName(i+1);
				}
				model.setColumnIdentifiers(colname);
				String name,age,gender,comany,modal,avaliable,location;
				while (rs.next()){
					name=rs.getString(1);
					age=rs.getString(2);
					gender=rs.getString(3);
					comany=rs.getString(4);
					modal=rs.getString(5);
					avaliable=rs.getString(6);
					location=rs.getString(7);
					String[] row = {name,age,gender,comany,modal,avaliable, location};
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
		new Pickup();

	}

}
