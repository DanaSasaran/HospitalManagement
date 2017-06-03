package View;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminGUI {
	private JFrame frame;
	private JPanel panel;
	private DefaultTableModel model, modelR;
	private JTable table, tableR;
	private JScrollPane scroll, scrollR;
	
	private JButton tab, add, update, delete, search, logout, rr;
	private JButton tabB, addB, updateB, deleteB, searchB;
	
	private JLabel username, password;
	private JTextField username1, password1;
	private Checkbox isAdmin, isDoctor, isPatient;
	
	private String admin;
	//private Checkbox radioPDF, radioCSV;

	private JLabel adm, id;
	private JLabel titlu, autor, gen, cantitate, pret;
	private JTextField titlu1, autor1, gen1, cantitate1, pret1, id1;
	
	public AdminGUI(String admin){
		this.admin = admin;
	}
	
	public JFrame initialize(){
		
		if(frame == null){
			
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBackground(new Color(255, 255, 224));
		frame.setBounds(410, 0, 900, 1030);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 950, 1030);
		frame.add(this.panel);
		
		logout = new JButton("Logout");
		logout.setBackground(Color.GRAY);
		logout.setForeground(new Color(0, 0, 0));
		logout.setFont(new Font("Lobster", Font.BOLD, 15));
		logout.setBounds(700, 50, 100, 20);
		logout.setVisible(true);
		panel.add(logout);
		
		/////
			JLabel adminServices = new JLabel("Administrator:  ");
			adminServices.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
			adminServices.setForeground(Color.GRAY);
			adminServices.setBounds(50, 50, 300, 20);
			panel.add(adminServices);
			
			JLabel adm = new JLabel(" " + admin);
			adm.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
			adm.setForeground(Color.GRAY);
			adm.setBounds(200, 50, 300, 20);
			adm.setVisible(true);
			panel.add(adm);
			
			JLabel instr = new JLabel("*Completati toate campurile necesare, apoi selectati optiunea dorita.");
			instr.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
			instr.setBounds(100, 290, 550, 20);
			instr.setVisible(true);
			panel.add(instr);
			
			JLabel instr2 = new JLabel("*Completati toate campurile necesare, apoi selectati optiunea dorita.");
			instr2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
			instr2.setBounds(100, 690, 550, 20);
			instr2.setVisible(true);
			panel.add(instr2);
		////
		
		this.model = new DefaultTableModel(null, new Object[]{"Username", "Password", "Administrator", "Doctor", "Pacient"});
		this.table = new JTable(model);
		this.scroll = new JScrollPane(table);
		
		scroll.setBounds(80, 100, 700, 170);
		scroll.setVisible(true);
		panel.add(scroll);
		
		this.modelR = new DefaultTableModel(null, new Object[]{"IdDoctor", "Nume", "Cabinet"});
		this.tableR = new JTable(modelR);
		this.scrollR = new JScrollPane(tableR);
		
		scrollR.setBounds(80, 500, 700, 170);
		scrollR.setVisible(true);
		panel.add(scrollR);
		
		username = new JLabel("Username:");
		username.setBounds(100, 340, 100, 30);
		username.setVisible(true);
		panel.add(username);
		
		username1 = new JTextField("");
		username1.setBounds(200, 340, 150, 25);
		username1.setVisible(true);
		panel.add(username1);
		
		password = new JLabel("Password:");
		password.setBounds(100, 370, 100, 30);
		password.setVisible(true);
		panel.add(password);
		
		password1 = new JTextField("");
		password1.setBounds(200, 370, 150, 25);
		password1.setVisible(true);
		panel.add(password1);
		
		isAdmin = new Checkbox("Administrator");
		isAdmin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		isAdmin.setBounds(100, 400, 150, 25);
		isAdmin.setVisible(true);
		panel.add(isAdmin);
		
		isDoctor = new Checkbox("Doctor");
		isDoctor.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		isDoctor.setBounds(100, 425, 150, 25);
		isDoctor.setVisible(true);
		panel.add(isDoctor);
		
		isPatient = new Checkbox("Patient");
		isPatient.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		isPatient.setBounds(100, 450, 150, 25);
		isPatient.setVisible(true);
		panel.add(isPatient);
		
		tab = new JButton("Tabel useri");
		tab.setBackground(Color.LIGHT_GRAY);
		tab.setForeground(new Color(0, 0, 0));
		tab.setFont(new Font("Lobster", Font.BOLD, 13));
		tab.setBounds(470, 330, 130, 30);
		tab.setVisible(true);
		panel.add(tab);
		
		add = new JButton("Adauga user");
		add.setBackground(Color.LIGHT_GRAY);
		add.setForeground(new Color(0, 0, 0));
		add.setFont(new Font("Lobster", Font.BOLD, 13));
		add.setBounds(630, 330, 130, 30);
		add.setVisible(true);
		panel.add(add);
		
		update = new JButton("Update user");
		update.setBackground(Color.LIGHT_GRAY);
		update.setForeground(new Color(0, 0, 0));
		update.setFont(new Font("Lobster", Font.BOLD, 13));
		update.setBounds(470, 370, 130, 30);
		update.setVisible(true);
		panel.add(update);
		
		delete = new JButton("Sterge user");
		delete.setBackground(Color.LIGHT_GRAY);
		delete.setForeground(new Color(0, 0, 0));
		delete.setFont(new Font("Lobster", Font.BOLD, 13));
		delete.setBounds(630, 370, 130, 30);
		delete.setVisible(true);
		panel.add(delete);
	
		titlu = new JLabel("Nume: ");
		titlu.setBounds(100, 740, 150, 25);
		titlu.setVisible(true);
		panel.add(titlu);
		
		titlu1 = new JTextField("");
		titlu1.setBounds(200, 740, 150, 25);
		titlu1.setVisible(true);
		panel.add(titlu1);
		
		autor = new JLabel("Cabinet: ");
		autor.setBounds(100, 770, 150, 25);
		autor.setVisible(true);
		panel.add(autor);
		
		autor1 = new JTextField("");
		autor1.setBounds(200, 770, 150, 25);
		autor1.setVisible(true);
		panel.add(autor1);
		
		id = new JLabel("ID");
		id.setBounds(100, 800, 150, 25);
		id.setVisible(true);
		panel.add(id);
		
		id1 = new JTextField("");
		id1.setBounds(200, 800, 150, 25);
		id1.setVisible(true);
		panel.add(id1);
		
		
		tabB = new JButton("Tabel doctori");
		tabB.setBackground(Color.LIGHT_GRAY);
		tabB.setForeground(new Color(0, 0, 0));
		tabB.setFont(new Font("Lobster", Font.BOLD, 13));
		tabB.setBounds(470, 740, 130, 30);
		tabB.setVisible(true);
		panel.add(tabB);
		
		addB = new JButton("Adauga doctor");
		addB.setBackground(Color.LIGHT_GRAY);
		addB.setForeground(new Color(0, 0, 0));
		addB.setFont(new Font("Lobster", Font.BOLD, 13));
		addB.setBounds(630, 740, 130, 30);
		addB.setVisible(true);
		panel.add(addB);
		
		updateB = new JButton("Update doctor");
		updateB.setBackground(Color.LIGHT_GRAY);
		updateB.setForeground(new Color(0, 0, 0));
		updateB.setFont(new Font("Lobster", Font.BOLD, 13));
		updateB.setBounds(470, 780, 130, 30);
		updateB.setVisible(true);
		panel.add(updateB);
		
		deleteB = new JButton("Sterge doctor");
		deleteB.setBackground(Color.LIGHT_GRAY);
		deleteB.setForeground(new Color(0, 0, 0));
		deleteB.setFont(new Font("Lobster", Font.BOLD, 13));
		deleteB.setBounds(630, 780, 130, 30);
		deleteB.setVisible(true);
		panel.add(deleteB);
		
		
		

		}
		return frame;
		
	
	
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public String getUsername(){
		return username1.getText();
	}


	public void setUsername1(String s) {
		this.username1.setText(s);;
	}

	public String getPassword1() {
		return password1.getText();
	}

	public void setPassword1(String s) {
		this.password1.setText(s);;
	}

	public boolean getIsAdmin() {
		return isAdmin.getState();
	}

	public void setIsAdmin(boolean b) {
		this.isAdmin.setState(b);;
	}
	
	public boolean getIsDoctor() {
		return isDoctor.getState();
	}

	public void setIsDoctor(boolean b) {
		this.isDoctor.setState(b);;
	}
	
	public boolean getIsPatient() {
		return isPatient.getState();
	}

	public void setIsPatient(boolean b) {
		this.isPatient.setState(b);;
	}

	public String getNumeDoctor1() {
		return titlu1.getText();
	}
	
	

	public void setNumeDoctor1(String s) {
		this.titlu1.setText(s);;
	}

	public String getCabinet1() {
		return autor1.getText();
	}

	public void setCabinet1(String s) {
		this.autor1.setText(s);;
	}

	public int getId(){
		return Integer.parseInt(id1.getText());
	}
	public void setId(String s){
		this.id1.setText(s);
	}
	
	
	public void addBListener(ActionListener listenAddB){
		addB.addActionListener(listenAddB);
	}
	public void deleteBListener(ActionListener listenRemoveB){
		deleteB.addActionListener(listenRemoveB);
	}
	public void updateBListener(ActionListener listenUpdateB){
		updateB.addActionListener(listenUpdateB);
	}
	public void findAllBListener(ActionListener listenFindAllB){
		tabB.addActionListener(listenFindAllB);
	}
	
	public void addListener(ActionListener listenAdd){
		add.addActionListener(listenAdd);
	}
	public void deleteListener(ActionListener listenRemove){
		delete.addActionListener(listenRemove);
	}
	public void updateListener(ActionListener listenUpdate){
		update.addActionListener(listenUpdate);
	}
	public void findAllListener(ActionListener listenFindAll){
		tab.addActionListener(listenFindAll);
	}
	
	public DefaultTableModel getModel(){
		return modelR;
	}
	
	public DefaultTableModel getModelUseri(){
		return model;
	}
	
		void displayErrorMessage(String errorMessage){
		 JOptionPane.showMessageDialog(this.frame, errorMessage);
	 }

}
