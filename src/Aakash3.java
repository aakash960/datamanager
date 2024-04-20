import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

public class Aakash3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	ResultSet rs6;
	String Name;
	String ws;
	String sl;
	String pn;
	String Emp_Id2;
	int ftfid;
	
	int ftid;
	int ftno;
	int fts;
	
	 String url,uname,pass;
	 String User_Id,Password;
	 Connection con;
	 Statement st;
	 ResultSet rs;
	 private JButton btnNewButton_5;

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aakash3 frame = new Aakash3();
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
	public Aakash3() throws Exception {
		setResizable(false);
		 url = "jdbc:mysql://localhost:3306/company-database";
	        uname = "";
	        pass = "";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con= DriverManager.getConnection(url, uname, pass);
	        st = con.createStatement();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Aakash1();
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Emp_Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Emp_Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_3 = new JLabel("Phone_No");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_4 = new JLabel("Workspace");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_5 = new JLabel("Salary");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton_1 = new JButton("UPDATE_DATA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gid=textField.getText();
					int gid1=Integer.parseInt(gid);
				    String po=textField_3.getText();
				    int po1=Integer.parseInt(po);
				    String wspw=textField_4.getText();
				    String slry=textField_5.getText();
				    String nm=textField_1.getText();
				    int slry1=Integer.parseInt(slry);
				    
					//st.executeUpdate("UPDATE department SET Phone_No="+po1+",Workspace=wspw,Salary="+slry1+"Emp_Name=nm WHERE Emp_Id="+gid);
				    	PreparedStatement up=con.prepareStatement("Update department SET Phone_No=?,Workspace=?,Salary=? where Emp_Id=?");
				    	up.setInt(1,po1);
				    	up.setString(2,wspw);
				    	up.setInt(3,slry1);
				    	up.setInt(4,gid1);
				    	//up.setInt(5,gid1);
				    	up.executeUpdate();
					 JOptionPane.showMessageDialog(null,"Record Updated Successfully", "",JOptionPane.PLAIN_MESSAGE);

				} 
				catch (SQLException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String temp=textField.getText();
					int temp1=Integer.parseInt(temp);
					st.executeUpdate("delete from employee where Emp_Id="+temp1);
					st.executeUpdate("delete from department where Emp_Id="+temp1);
					//For the reference
				/*PreparedStatement pst=con.prepareStatement("delete from employee where Emp_Id=?");
				pst.setInt(1, temp1);
				pst.executeUpdate();*/
				 JOptionPane.showMessageDialog(null,"Record Deleted Successfully", "",JOptionPane.PLAIN_MESSAGE);
				}
				catch(Exception jk) {
					 JOptionPane.showMessageDialog(null,"You have entered Incorrect_Id \n"
					 		+ "or\n Inorrect format", "",JOptionPane.PLAIN_MESSAGE);
					 System.out.print(jk);

				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_4 = new JButton("Data_Insert");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String Emp_Id=textField.getText();
				String emp_Name=textField_1.getText();
				
				String Phone_No=textField_3.getText();
				String Workspace=textField_4.getText();
				String salary=textField_5.getText();
				int ftid=Integer.parseInt(Emp_Id);
				int ftno=Integer.parseInt(Phone_No);
				int fts=Integer.parseInt(salary);
				try {
					int p=JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					System.out.print(p);
					if(p==0) {
				//st.executeUpdate("INSERT INTO employee Values (Emp_Name,"+ftid+")");
				//st.executeUpdate("Insert into department Values("+ftid+","+ftno+",Workspace,"fts+")");
					PreparedStatement psp=con.prepareStatement("insert into employee values(?,?)");
					psp.setString(1,emp_Name);
					psp.setInt(2,ftid);
					psp.executeUpdate();
					
					PreparedStatement psp1=con.prepareStatement("insert into department values(?,?,?,?)");
					psp1.setInt(1,ftid);
					psp1.setInt(2,ftno);
					psp1.setString(3,Workspace);
					psp1.setInt(4,fts);
					psp1.executeUpdate();
					
				 JOptionPane.showMessageDialog(null,"Data Inserted Successfully", "",JOptionPane.PLAIN_MESSAGE);
					}
				}
				catch(Exception h) {
					System.out.println(h);
					 JOptionPane.showMessageDialog(null,"USER_ID EXISTED IN DATABASE IN \n Please use another USER_ID \nEnter the valid data", "",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton_5 = new JButton("GET_USER_DETAILS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int c1=0,c2=0;
					Emp_Id2=textField.getText();
				    ftfid=Integer.parseInt(Emp_Id2);
					rs=st.executeQuery("select * from employee");
					while(rs.next()) {
						c1++;
					int Id=rs.getInt(2);
					if(ftfid==Id){
						Name=rs.getString(1);
						System.out.print(Name);
						textField_1.setText(Name);
						System.out.println(c1);
						
						
					}
					}
					rs6=st.executeQuery("Select * from department");
					while(rs6.next()) {
						int Id2=rs6.getInt(1);
						if(ftfid==Id2) {
							pn=rs6.getString(2);
							ws=rs6.getString(3);
							sl=rs6.getString(4);
							textField_3.setText(pn);
							textField_4.setText(ws);
							textField_5.setText(sl);
						}
					}
					
				}
				catch(Exception o) {
					
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_6 = new JButton("Refresh");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cl="";
				textField.setText(cl);
				textField_1.setText(cl);
				textField_3.setText(cl);
				textField_4.setText(cl);
				textField_5.setText(cl);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addGap(35)
					.addComponent(btnNewButton_5)
					.addGap(18)
					.addComponent(btnNewButton_6)
					.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(24)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(386))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(139)
					.addComponent(btnNewButton_4)
					.addContainerGap(411, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(606, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(71)
					.addComponent(btnNewButton_4)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_6))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
