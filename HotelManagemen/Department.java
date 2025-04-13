package HotelManagemen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.DefaultPersistenceDelegate;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Department extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	public Department() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 =new JLabel("Department");
		l1.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l1.setBounds(180,90,100,20);
		add(l1);
		JLabel l2 =new JLabel("Budgt");
		l2.setFont(new Font("Ralcway", getFont().PLAIN,17));
		l2.setBounds(370,90,100,20);
		add(l2);
		
		
		table =new JTable();
		table.setFont(new Font("Ralcway", getFont().PLAIN,15));
		table.setBounds(80,110,456,400);
		add(table);
		
		try {
			conn con = new conn();
			String quary = "select * from department";
			ResultSet rs = con.s.executeQuery(quary);
			ResultSetMetaData rrsmd= (ResultSetMetaData) rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols=rrsmd.getColumnCount();
			String[] colName= new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]= rrsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String department, budget;
			while (rs.next()) {
				department=rs.getString(1);
				budget=rs.getString(2);
				String[] raw= {department, budget};
				model.addRow(raw);	
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		back=new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setBounds(260,50,100,20);
		back.addActionListener(this);
		add(back);	
		
		
		setBounds(150,150,700,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new Department();

	}

}
