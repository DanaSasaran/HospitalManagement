package View;

import javax.swing.JFrame;

import Controller.AdminController;
import Controller.DoctorController;
import Controller.HospitalController;
import Controller.PatientController;



public class Test {
	public static AdminController adminController;
	public static DoctorController doctorController;
	public static HospitalController hController;
	public static PatientController pC;
	
	public static HospitalGUI hgui;
	public static AdminGUI admingui;
	public static DoctorGUI usergui;
	public static PatientGUI pgui;
	
	
	public static void main(String[] args) {		
		hgui = new HospitalGUI();
		hController = new HospitalController(hgui);
		
	}
	
	public static void openAdmin(String admin){
		admingui = new AdminGUI(admin);
		JFrame userF = admingui.initialize();
		userF.setVisible(true);
		adminController = new AdminController(admingui);
	}
	public static void openUser(String user){
		usergui = new DoctorGUI(user);
		JFrame userF = usergui.initialize();
		userF.setVisible(true);
		doctorController = new DoctorController(usergui);
	}
	public static void openPatient(String patient){
		pgui = new PatientGUI(patient);
		JFrame user = pgui.initialize();
		user.setVisible(true);
		pC = new PatientController(pgui);
	}
	
}
