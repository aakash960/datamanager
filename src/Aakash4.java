import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;



public class Aakash4 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aakash4 frame = new Aakash4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aakash4() throws Exception  {
		
		
		setVisible(true);
		String url = "jdbc:mysql://localhost:3306/company-database";
        String uname = "root";
        String pass = "Aakash";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url, uname, pass);
        final Statement st = con.createStatement();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(10, 11, 47, 27);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Aakash3();
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 55, 205, 348);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp_Id", "Emp_Name"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(261, 55, 355, 348);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Phone_No", "Workspace", "Salary"
			}
		));
		
		
		JButton btnNewButton_1 = new JButton("Get_Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs=st.executeQuery("select * from employee");
					ResultSet rs2=st.executeQuery("select * from department");
					
					
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				ResultSetMetaData rsmd2=(ResultSetMetaData) rs2.getMetaData();
				DefaultTableModel dtm=(DefaultTableModel) table.getModel();
				DefaultTableModel dtm2=(DefaultTableModel) table_1.getModel();
				int m=rsmd.getColumnCount();
				int n=rsmd2.getColumnCount();
				dtm.setRowCount(0);
				dtm2.setRowCount(0);
				String[] ma=new String[m];
				String[] na=new String[n];
				while(rs.next()) {
					Vector v=new Vector();
					for(int i=1;i<=m;i++) {
						v.add(rs.getString(2));
						v.add(rs.getString(1));
					}
					dtm.addColumn(v);
				}
				}
				catch(Exception ty) {
					ty.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(568, 15, 89, 23);
		contentPane.add(btnNewButton_1);
		
		

		
		
				
	}
}
