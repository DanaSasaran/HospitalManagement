package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import DataAccess.UserGateway;
import Model.User;
import View.AdminGUI;
import View.DoctorGUI;
import View.HospitalGUI;
import View.PatientGUI;
import View.Test;



public class HospitalController {
	private HospitalGUI storeg;
	private AdminGUI admingui;
	private AdminController adminController;
	private DoctorGUI doctorgui;
	private DoctorController doctorController;
	private PatientGUI pacientgui;
	private PatientController pacientController;
	
	public HospitalController(HospitalGUI storeg){
		this.storeg = storeg;
		
		this.storeg.addListener(new LoginListener());
	}
	


	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String password = storeg.getPassword();
			String username = storeg.getUsername();
			User user = new User();
			UserGateway usergateway = new UserGateway();
			
			try{
				user = usergateway.login(username, password);
				if (user != null){
					if(user.isAdmin()){
						Test.openAdmin(storeg.getUsername());
						
						storeg.resetUsername();
						storeg.resetPassword();
						storeg.resetLabel();
					}
					else
						if(user.isDoctor()){
						Test.openUser(storeg.getUsername());
						
						storeg.resetUsername();
						storeg.resetPassword();
						storeg.resetLabel();
						}
					
					else
						if(user.isPacient()){
							Test.openPatient(storeg.getUsername());
							
							storeg.resetUsername();
							storeg.resetPassword();
							storeg.resetLabel();
						}
						else{
							storeg.setLabel("Contul sau parola incorecte!!");
						}
					
				}
			
					else{
						storeg.setLabel("Contul sau parola incorecte!!");
					}
				
				/*if(username.equals("admin") && password.equals("parola")){
					admingui = new AdminGUI("admin");
					JFrame userF = admingui.initialize();
					userF.setVisible(true);
					adminController = new AdminController(admingui);
				}
				else if(username.equals("doctor") && password.equals("parola")){
					doctorgui = new DoctorGUI("doctor");
					JFrame userD = doctorgui.initialize();
					userD.setVisible(true);
					doctorController = new DoctorController(doctorgui);
				}
				else if(username.equals("pacient") && password.equals("parola")){
					pacientgui = new PatientGUI("pacient");
					JFrame userD = pacientgui.initialize();
					userD.setVisible(true);
					pacientController = new PatientController(pacientgui);
				}*/
					
			}catch(Exception ex){
				ex.printStackTrace();
		}
		
	}
	}
}
