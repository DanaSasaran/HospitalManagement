package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PatientGUI {
	private JFrame frame;
	private JPanel panel;
	private DefaultTableModel model, modelP;
	private JTable table, tableP;
	private JScrollPane scroll, scrollP;
	private JButton add, tab, logout, addP, updateP, viewP, deleteP, tabB, addB;
	private JLabel idConsult, detalii, idP, numeP, cnpP, adresaP, idR, idPac;
	private JTextField idConsult1, detalii1, idP1,numeP1, cnpP1, adresaP1, idR1, idPac1;
	
	private String doctor;
	public PatientGUI (String doctor){
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
			
			this.model = new DefaultTableModel(null, new Object[]{"ID", "Data programare","Diagnostic"});
			this.table = new JTable(model);
			this.scroll = new JScrollPane(table);
			
			scroll.setBounds(80, 100, 700, 170);
			scroll.setVisible(true);
			panel.add(scroll);
			
			this.modelP = new DefaultTableModel(null, new Object[]{"ID salon", "ID Pacient","isAvailable"});
			this.tableP = new JTable(modelP);
			this.scrollP = new JScrollPane(tableP);
			
			scrollP.setBounds(80, 500, 700, 170);
			scrollP.setVisible(true);
			panel.add(scrollP);
			
			idConsult = new JLabel("ID :");
			idConsult.setBounds(100, 340, 100, 30);
			idConsult.setVisible(true);
			panel.add(idConsult);
			
			idConsult1 = new JTextField("");
			idConsult1.setBounds(200, 340, 150, 25);
			idConsult1.setVisible(true);
			panel.add(idConsult1);
			
			
			
			tab = new JButton("Vizualizeaza");
			tab.setBackground(Color.LIGHT_GRAY);
			tab.setForeground(new Color(0, 0, 0));
			tab.setFont(new Font("Lobster", Font.BOLD, 13));
			tab.setBounds(470, 330, 130, 30);
			tab.setVisible(true);
			panel.add(tab);
			
			idR = new JLabel("ID salon:");
			idR.setBounds(100, 750, 100, 30);
			idR.setVisible(true);
			panel.add(idR);

			idR1 = new JTextField("");
			idR1.setBounds(200, 750, 150, 25);
			idR1.setVisible(true);
			panel.add(idR1);
			
			idPac = new JLabel("ID pacient:");
			idPac.setBounds(100, 780, 100, 30);
			idPac.setVisible(true);
			panel.add(idPac);

			idPac1 = new JTextField("");
			idPac1.setBounds(200, 780, 150, 25);
			idPac1.setVisible(true);
			panel.add(idPac1);
			
			tabB = new JButton("Tabel saloane");
			tabB.setBackground(Color.LIGHT_GRAY);
			tabB.setForeground(new Color(0, 0, 0));
			tabB.setFont(new Font("Lobster", Font.BOLD, 13));
			tabB.setBounds(470, 740, 130, 30);
			tabB.setVisible(true);
			panel.add(tabB);
			
			addB = new JButton("Adauga cazare");
			addB.setBackground(Color.LIGHT_GRAY);
			addB.setForeground(new Color(0, 0, 0));
			addB.setFont(new Font("Lobster", Font.BOLD, 13));
			addB.setBounds(630, 740, 130, 30);
			addB.setVisible(true);
			panel.add(addB);
			
			}
		return frame;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	
	public DefaultTableModel getModelR() {
		return modelP;
	}
	public void setModelR(DefaultTableModel model) {
		this.modelP = model;
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
	public int getIdRoom(){
		return Integer.parseInt(idR1.getText());
	}
	public int getIdPac(){
		return Integer.parseInt(idPac1.getText());
	}
	public void setIdRoom(String s){
		this.idR1.setText(s);
	}
	public void setIdPac(String s){
		this.idPac1.setText("");
	}
	
	public void addCListener(ActionListener listenAddC){
		add.addActionListener(listenAddC);
	}
	
	public void findAllCListener(ActionListener listenFindAllC){
		tab.addActionListener(listenFindAllC);
	}
	
	public void addListener(ActionListener listenAddC){
		addB.addActionListener(listenAddC);
	}
	
	public void findAllListener(ActionListener listenFindAllC){
		tabB.addActionListener(listenFindAllC);
	}
}
