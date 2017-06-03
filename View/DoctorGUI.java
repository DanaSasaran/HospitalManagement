package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DoctorGUI {
	private JFrame frame;
	private JPanel panel;
	private DefaultTableModel model, modelP;
	private JTable table, tableP;
	private JScrollPane scroll, scrollP;
	private JButton add, tab,delete, update, logout, addP, updateP, viewP, deleteP;
	private JLabel idConsult, detalii,data, idPac, idD, idP, numeP, cnpP, adresaP;
	private JTextField idConsult1, detalii1,data1, idPac1, idD1, idP1,numeP1, cnpP1, adresaP1;
	
	private String doctor;
	public DoctorGUI (String doctor){
		this.doctor = doctor;
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
				JLabel adminServices = new JLabel("Doctor:  ");
				adminServices.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
				adminServices.setForeground(Color.GRAY);
				adminServices.setBounds(50, 50, 300, 20);
				panel.add(adminServices);
				
				JLabel adm = new JLabel(" " + doctor);
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
				
			
			////
			
			this.model = new DefaultTableModel(null, new Object[]{"ID Consult", "ID Pacient","ID Doctor", "Data", "Detalii"});
			this.table = new JTable(model);
			this.scroll = new JScrollPane(table);
			
			scroll.setBounds(80, 100, 700, 170);
			scroll.setVisible(true);
			panel.add(scroll);
			
			this.modelP = new DefaultTableModel(null, new Object[]{"ID Pacient", "Nume","CNP", "Adresa"});
			this.tableP = new JTable(modelP);
			this.scrollP = new JScrollPane(tableP);
			
			scrollP.setBounds(80, 500, 700, 170);
			scrollP.setVisible(true);
			panel.add(scrollP);
			
			idConsult = new JLabel("ID Consult:");
			idConsult.setBounds(100, 340, 100, 30);
			idConsult.setVisible(true);
			panel.add(idConsult);
			
			idConsult1 = new JTextField("");
			idConsult1.setBounds(200, 340, 150, 25);
			idConsult1.setVisible(true);
			panel.add(idConsult1);
			
			idPac = new JLabel("ID Pacient:");
			idPac.setBounds(100, 370, 100, 30);
			idPac.setVisible(true);
			panel.add(idPac);
			
			idPac1 = new JTextField("");
			idPac1.setBounds(200, 370, 150, 25);
			idPac1.setVisible(true);
			panel.add(idPac1);
			
			idD = new JLabel("ID Doctor:");
			idD.setBounds(100, 400, 100, 30);
			idD.setVisible(true);
			panel.add(idD);
			
			idD1 = new JTextField("");
			idD1.setBounds(200, 400, 150, 25);
			idD1.setVisible(true);
			panel.add(idD1);
			
			data = new JLabel("Data:");
			data.setBounds(100, 430, 100, 30);
			data.setVisible(true);
			panel.add(data);
			
			data1 = new JTextField("");
			data1.setBounds(200, 430, 150, 25);
			data1.setVisible(true);
			panel.add(data1);
			
			detalii = new JLabel("Descriere:");
			detalii.setBounds(100, 460, 100, 30);
			detalii.setVisible(true);
			panel.add(detalii);
			
			detalii1 = new JTextField("");
			detalii1.setBounds(200, 460, 150, 25);
			detalii1.setVisible(true);
			panel.add(detalii1);
			
			tab = new JButton("Consultatii");
			tab.setBackground(Color.LIGHT_GRAY);
			tab.setForeground(new Color(0, 0, 0));
			tab.setFont(new Font("Lobster", Font.BOLD, 13));
			tab.setBounds(470, 330, 130, 30);
			tab.setVisible(true);
			panel.add(tab);
			
			add = new JButton("Adauga");
			add.setBackground(Color.LIGHT_GRAY);
			add.setForeground(new Color(0, 0, 0));
			add.setFont(new Font("Lobster", Font.BOLD, 13));
			add.setBounds(630, 330, 130, 30);
			add.setVisible(true);
			panel.add(add);
			
			delete = new JButton("Delete");
			delete.setBackground(Color.LIGHT_GRAY);
			delete.setForeground(new Color(0, 0, 0));
			delete.setFont(new Font("Lobster", Font.BOLD, 13));
			delete.setBounds(470, 370, 130, 30);
			delete.setVisible(true);
			panel.add(delete);
			
			update = new JButton("Update");
			update.setBackground(Color.LIGHT_GRAY);
			update.setForeground(new Color(0, 0, 0));
			update.setFont(new Font("Lobster", Font.BOLD, 13));
			update.setBounds(630, 370, 130, 30);
			update.setVisible(true);
			panel.add(update);
			
			
			idP = new JLabel("ID: ");
			idP.setBounds(100, 740, 150, 25);
			idP.setVisible(true);
			panel.add(idP);
			
			idP1 = new JTextField("");
			idP1.setBounds(200, 740, 150, 25);
			idP1.setVisible(true);
			panel.add(idP1);
			
			numeP = new JLabel("Nume: ");
			numeP.setBounds(100, 770, 150, 25);
			numeP.setVisible(true);
			panel.add(numeP);
			
			numeP1 = new JTextField("");
			numeP1.setBounds(200, 770, 150, 25);
			numeP1.setVisible(true);
			panel.add(numeP1);
			
			cnpP = new JLabel("CNP: ");
			cnpP.setBounds(100, 800, 150, 25);
			cnpP.setVisible(true);
			panel.add(cnpP);
			
			cnpP1 = new JTextField("");
			cnpP1.setBounds(200, 800, 150, 25);
			cnpP1.setVisible(true);
			panel.add(cnpP1);
			
			adresaP = new JLabel("Adresa: ");
			adresaP.setBounds(100, 830, 150, 25);
			adresaP.setVisible(true);
			panel.add(adresaP);
			
			adresaP1 = new JTextField("");
			adresaP1.setBounds(200, 830, 150, 25);
			adresaP1.setVisible(true);
			panel.add(adresaP1);
			
			
			
			
			viewP = new JButton("Tabel pacienti");
			viewP.setBackground(Color.LIGHT_GRAY);
			viewP.setForeground(new Color(0, 0, 0));
			viewP.setFont(new Font("Lobster", Font.BOLD, 13));
			viewP.setBounds(470, 740, 130, 30);
			viewP.setVisible(true);
			panel.add(viewP);
			
			addP = new JButton("Adauga pacient");
			addP.setBackground(Color.LIGHT_GRAY);
			addP.setForeground(new Color(0, 0, 0));
			addP.setFont(new Font("Lobster", Font.BOLD, 13));
			addP.setBounds(630, 740, 130, 30);
			addP.setVisible(true);
			panel.add(addP);
			
			updateP = new JButton("Update pacient");
			updateP.setBackground(Color.LIGHT_GRAY);
			updateP.setForeground(new Color(0, 0, 0));
			updateP.setFont(new Font("Lobster", Font.BOLD, 13));
			updateP.setBounds(470, 780, 130, 30);
			updateP.setVisible(true);
			panel.add(updateP);
			
			deleteP = new JButton("Sterge pacient");
			deleteP.setBackground(Color.LIGHT_GRAY);
			deleteP.setForeground(new Color(0, 0, 0));
			deleteP.setFont(new Font("Lobster", Font.BOLD, 13));
			deleteP.setBounds(630, 780, 130, 30);
			deleteP.setVisible(true);
			panel.add(deleteP);
			
			
			
			}
		return frame;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	
	public DefaultTableModel getModelPacienti() {
		return modelP;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public int getIdConsult1() {
		return Integer.parseInt(idConsult1.getText());
	}
	public void setIdConsult1(String s){
		this.idConsult1.setText(s);
	}
	
	public String getDetalii1() {
		return detalii1.getText();
	}
	public void setDetalii1(String detalii1) {
		this.detalii1.setText(detalii1);
	}
	
	public void addBListener(ActionListener listenAddB){
		addP.addActionListener(listenAddB);
	}
	public void deleteBListener(ActionListener listenRemoveB){
		deleteP.addActionListener(listenRemoveB);
	}
	public void updateBListener(ActionListener listenUpdateB){
		updateP.addActionListener(listenUpdateB);
	}
	public void findAllBListener(ActionListener listenFindAllB){
		viewP.addActionListener(listenFindAllB);
	}
	
	public void addListener(ActionListener listenAdd){
		add.addActionListener(listenAdd);
	}

	public void findAllListener(ActionListener listenFindAll){
		tab.addActionListener(listenFindAll);
	}
	public void deleteListener(ActionListener listenRemove){
		delete.addActionListener(listenRemove);
	}
	public void updateListener(ActionListener listenUpdate){
		update.addActionListener(listenUpdate);
	}
	
	public int getIdP(){
		return Integer.parseInt(idP1.getText());
	}
	public String getAdresa(){
		return adresaP1.getText();
	}
	public String getNume(){
		return numeP1.getText();
	}
	public int getCnp(){
		return Integer.parseInt(cnpP1.getText());
	}
	public void setId(String s){
		this.idP1.setText(s);
	}
	public void setNume(String s){
		this.numeP1.setText(s);
	}
	public void setCnp(String s){
		this.cnpP1.setText(s);
	}
	public void setAdresa(String s){
		this.adresaP1.setText(s);
	}
	
	public void setData1(String s) {
		this.data1.setText(s); 
	}
	public int getIdPac1() {
		return Integer.parseInt(idPac1.getText());
	}
	public void setIdPac1(String idPac1) {
		this.idPac1.setText(idPac1);
	}
	public int getIdD1() {
		return Integer.parseInt(idD1.getText());
	}
	public void setIdD1(String s) {
		this.idD1.setText(s);
	}

	public Date getData1() {
		return Date.valueOf(data1.getText());
	}
	
}
