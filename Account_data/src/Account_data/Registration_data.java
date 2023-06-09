package Account_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration_data {

	private JFrame frame;
	private JTextField tb1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_data window = new Registration_data();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration_data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 507, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(120, 21, 224, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(61, 87, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(61, 127, 72, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Branch");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(61, 163, 72, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tb1 = new JTextField();
		tb1.setBounds(157, 84, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Cse", "Aiml", "Iot", "Ds", "Cs", "It", "Ece", "EEE"}));
		c1.setBounds(157, 162, 86, 22);
		frame.getContentPane().add(c1);
		
		JRadioButton r1 = new JRadioButton("Female");
		r1.setBackground(Color.BLACK);
		r1.setForeground(Color.WHITE);
		r1.setBounds(157, 126, 59, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setBackground(Color.BLACK);
		r2.setForeground(Color.WHITE);
		r2.setBounds(218, 126, 109, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=  new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel cb = new JLabel("Pgm Lan");
		cb.setForeground(Color.WHITE);
		cb.setFont(new Font("Tahoma", Font.BOLD, 18));
		cb.setBounds(61, 188, 93, 27);
		frame.getContentPane().add(cb);
		
		JCheckBox cb1 = new JCheckBox("C");
		cb1.setBackground(Color.BLACK);
		cb1.setForeground(Color.WHITE);
		cb1.setBounds(157, 191, 33, 23);
		frame.getContentPane().add(cb1);
		
		JCheckBox cb3 = new JCheckBox("Python");
		cb3.setBackground(Color.BLACK);
		cb3.setForeground(Color.WHITE);
		cb3.setBounds(157, 216, 97, 23);
		frame.getContentPane().add(cb3);
		
		JCheckBox cb2 = new JCheckBox("Java");
		cb2.setBackground(Color.BLACK);
		cb2.setForeground(Color.WHITE);
		cb2.setBounds(273, 193, 97, 23);
		frame.getContentPane().add(cb2);
		
		JCheckBox cb4 = new JCheckBox("C++");
		cb4.setBackground(Color.BLACK);
		cb4.setForeground(Color.WHITE);
		cb4.setBounds(273, 216, 97, 23);
		frame.getContentPane().add(cb4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tb1.getText();
				String g;
				if(r1.isSelected())
				{
					g="Female";
				}
				else if(r2.isSelected())
				{
					g="Male";
				}
				else
				{
					g="Invalid";
				}
				String s2 = (String) c1.getSelectedItem();
				String m=" ";
				if(cb4.isSelected())
				{
					m=m+"c++";
				}
				if(cb2.isSelected())
				{
					m=m+","+" java";
				}
				if(cb3.isSelected())
				{
					m=m+","+" python";
				}
				if(cb1.isSelected())
				{
					m=m+","+" c";
				}
				try {
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","mrec");
				    String q= "insert into registration values('"+s+"','"+g+"','"+s2+"','"+m+"')";
				    Statement st=cn.createStatement();
				    st.execute(q);
				    cn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(btnNewButton, "Name:"+s+"\n gender:"+g+"\n branch"+s2+"\n pgm lan :"+m);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(127, 261, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 47, 30, -11);
		frame.getContentPane().add(separator);
	}
}
