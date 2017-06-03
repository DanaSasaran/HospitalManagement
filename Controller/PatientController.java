package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import DataAccess.ConsultationGateway;
import DataAccess.DoctorGateway;
import DataAccess.RoomGateway;
import Model.Consultation;
import Model.Doctor;
import Model.Patient;
import Model.Room;
import View.PatientGUI;

public class PatientController {
private PatientGUI Patientgui;
	
	public PatientController(PatientGUI Patientgui){
		this.Patientgui = Patientgui;
		
		this.Patientgui.findAllCListener(new FindAllCListener());
		this.Patientgui.findAllListener(new FindAllListener());
		this.Patientgui.addListener(new AddListener());
	}
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Room> users = null;
			List<Room> userss = null;
			RoomGateway userg = new RoomGateway();
		    int idR = Patientgui.getIdRoom();
		    int idP = Patientgui.getIdPac();
		    Room r = new Room(idR, idP, false);
			try{
				userss  = userg.findById(idR);
				Room r2 = userss.get(0);
				if(r2.isAvailable()){
					userg.update(r2.getId(), false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Nu este liber salonul!");
				}
					
				
			userg.findAll();
			users = userg.findAll();
			Patientgui.getModelR().setRowCount(0);
			
			for(Room u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getIdP(),u.isAvailable()};
				Patientgui.getModelR().addRow(dataRow);
		}	
			
			Patientgui.setIdRoom("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class FindAllListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Room> users = null;
			RoomGateway userg = new RoomGateway();
		//int id = Patientgui.getIdConsult1();
			try{
			userg.findAll();
			users = userg.findAll();
			Patientgui.getModelR().setRowCount(0);
			
			for(Room u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getIdP(),u.isAvailable()};
				Patientgui.getModelR().addRow(dataRow);
		}	
			
			Patientgui.setIdRoom("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	class FindAllCListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Consultation> users = null;
			ConsultationGateway userg = new ConsultationGateway();
		int id = Patientgui.getIdConsult1();
			try{
			userg.findById(id);
			users = userg.findAll();
			Patientgui.getModel().setRowCount(0);
			
			for(Consultation u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getIdPacient(),u.getData(),u.getDescription()};
				Patientgui.getModel().addRow(dataRow);
		}	
			
			Patientgui.setIdConsult1("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
}
