
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Button;

public class Aakash1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;

	 String url,uname,pass;
	 String User_Id,Password;
	 Connection con;
	 Statement st;
	 ResultSet rs;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aakash1 frame = new Aakash1();
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
	public Aakash1() throws Exception {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\Dblogo.png"));
		
		setVisible(true);
		 url = "jdbc:mysql://localhost:3306/company-database";
        uname = "root";
        pass = "Aakash";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con= DriverManager.getConnection(url, uname, pass);
        st = con.createStatement();
        
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1 = new JLabel("User_Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String Id=textField_1.getText();
				int fdbid=Integer.parseInt(Id);
				PreparedStatement pstl=con.prepareStatement("select * from admin_data where Used_Id=?");
				pstl.setInt(1, fdbid);
				ResultSet rs=pstl.executeQuery();
				rs.next();
				Statement s=con.createStatement();
				ResultSet count=s.executeQuery("select count(*) from admin_data where Used_Id="+fdbid);
				count.next();
				
				String pass=textField_2.getText();
				String fdpass = rs.getString(2);
				if(Integer.parseInt(count.getString(1))==0)
					JOptionPane.showMessageDialog(null,"INCORRECT USER_ID OR USER_ID DOESN'T EXIST", "",JOptionPane.INFORMATION_MESSAGE);

				
				System.out.println(fdbid);
				System.out.println(fdpass);
				 if(pass.equals(fdpass)) {
					 new Aakash3();
					 dispose();
									}
				 else {
					 
					 JOptionPane.showMessageDialog(null,"Please enter the correct password", "",JOptionPane.ERROR_MESSAGE);
					 
					 }
				 }
				catch(Exception tf) {
					System.out.println(tf);
				}
			}
		});
		
		
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_2)
										.addComponent(textField_1)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(55)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
									.addGap(28)))))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
	}
}
