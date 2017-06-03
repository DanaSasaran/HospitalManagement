package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HospitalGUI {
	private JFrame frame;
	private JPanel panel;
	private JTextField user1;
	private JPasswordField pass1;
	private JLabel user;
	private JLabel pass;
	private JLabel login;
	private JButton buton;
	private JLabel text;

	
	public HospitalGUI() {
		
		this.frame = new JFrame("Hospital");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(400, 600);
		this.frame.setVisible(true);
		this.frame.setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBounds(0, 0, 400, 600);
		this.frame.add(this.panel);
		
		this.login = new JLabel("Autentificare");
		login.setFont(new Font("Lobster", Font.BOLD, 30));
		login.setBounds(100, 40, 250, 30);
		login.setVisible(true);
		panel.add(login);
		
		this.user = new JLabel("Username: ");
		user.setFont(new Font("Lobster", Font.BOLD, 17));
		user.setBounds(20, 150, 200, 25);
		user.setVisible(true);
		panel.add(user);
		
		this.user1 = new JTextField("");
		user1.setFont(new Font("Calibri", Font.BOLD, 15));
		user1.setBounds(150, 150, 150, 23);
		user1.setVisible(true);
		panel.add(user1);
		
		this.pass = new JLabel("Password: ");
		pass.setFont(new Font("Lobster", Font.BOLD, 17));
		pass.setBounds(20, 180, 200, 25);
		pass.setVisible(true);
		panel.add(pass);
		
		this.pass1 = new JPasswordField("");
		pass1.setFont(new Font("Calibri", Font.BOLD, 15));
		pass1.setBounds(150, 180, 150, 23);
		pass1.setVisible(true);
		panel.add(pass1);
		
		this.buton = new JButton("Login");
		buton.setBackground(Color.GRAY);
		buton.setForeground(new Color(0, 0, 0));
		buton.setFont(new Font("Lobster", Font.BOLD, 23));
		buton.setBounds(115, 425, 150, 27);
		buton.setVisible(true);
		panel.add(buton);
		
		this.text = new JLabel("");
		text.setFont(new Font("Lobster", Font.BOLD, 15));
		text.setForeground(Color.red);
		text.setBounds(90, 460, 250, 27);
		text.setVisible(true);
		panel.add(text);
		
		
			
	}
	
	public String getUsername(){
		return user1.getText();
	}

	public String getPassword(){
		return pass1.getText();
	}
	
	public void setLabel(String s){
		this.text.setText(s);;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public void resetUsername(){
		this.user1.setText("");
	}
	
	public void resetPassword(){
		this.pass1.setText("");
	}
	
	public void resetLabel(){
		this.text.setText("");
	}
	
	public void addListener(ActionListener listenLogin){
		buton.addActionListener(listenLogin);
	}
	
	//mesaj pt erori
		 void displayErrorMessage(String errorMessage){
			 JOptionPane.showMessageDialog(this.frame, errorMessage);
		 }
}
