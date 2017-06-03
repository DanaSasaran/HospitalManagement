package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.AdminController.AddBListener;
import Controller.AdminController.AddListener;
import Controller.AdminController.DeleteBListener;
import Controller.AdminController.DeleteListener;
import Controller.AdminController.FindAllBListener;
import Controller.AdminController.FindAllListener;
import Controller.AdminController.UpdateBListener;
import Controller.AdminController.UpdateListener;
import DataAccess.ConsultationGateway;
import DataAccess.DoctorGateway;
import DataAccess.PatientGateway;
import Model.Consultation;
import Model.Doctor;
import Model.Patient;
import View.DoctorGUI;

public class DoctorController {

	private DoctorGUI doctorgui;
	
	public DoctorController(DoctorGUI Doctorgui){
		this.doctorgui = Doctorgui;
		
		this.doctorgui.findAllBListener(new FindAllBListener());
		this.doctorgui.addBListener(new AddBListener());
		this.doctorgui.deleteBListener(new DeleteBListener());
		this.doctorgui.updateBListener(new UpdateBListener());
		
		this.doctorgui.findAllListener(new FindAllListener());
		this.doctorgui.addListener(new AddListener());
		this.doctorgui.deleteListener(new DeleteListener());
		this.doctorgui.updateListener(new UpdateListener());
		
	}
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Consultation> users = null;
			ConsultationGateway userg = new ConsultationGateway();
			int idPac = doctorgui.getIdPac1();
			int idD = doctorgui.getIdD1();
			Date data = doctorgui.getData1();
			String det = doctorgui.getDetalii1();
			Consultation us = new Consultation(0,idPac, idD, data,det);
			try{
			userg.add(us);
			users = userg.findAll();
			doctorgui.getModel().setRowCount(0);
			
			for(Consultation u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getIdConsult(),u.getIdPacient(),u.getIdDoctor(), u.getData(), u.getDescription()};
				doctorgui.getModel().addRow(dataRow);
		}	
			doctorgui.setIdConsult1("");
			doctorgui.setIdPac1("");
			doctorgui.setIdD1("");
			doctorgui.setData1("");
			doctorgui.setDetalii1("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Consultation> users = null;
			ConsultationGateway userg = new ConsultationGateway();
			int idPac = doctorgui.getIdPac1();
			int idD = doctorgui.getIdD1();
			Date data = doctorgui.getData1();
			String det = doctorgui.getDetalii1();
			int idC = doctorgui.getIdConsult1();
			Consultation us = new Consultation(idC,idPac, idD, data,det);
			try{
			userg.delete(us);
			users = userg.findAll();
			doctorgui.getModel().setRowCount(0);
			
			for(Consultation u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getIdConsult(),u.getIdPacient(),u.getIdDoctor(), u.getData(), u.getDescription()};
				doctorgui.getModel().addRow(dataRow);
		}	
			doctorgui.setIdConsult1("");
			doctorgui.setIdPac1("");
			doctorgui.setIdD1("");
			doctorgui.setData1("");
			doctorgui.setDetalii1("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class UpdateListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Consultation> users = null;
			ConsultationGateway userg = new ConsultationGateway();
			int idPac = doctorgui.getIdPac1();
			int idD = doctorgui.getIdD1();
			Date data = doctorgui.getData1();
			String det = doctorgui.getDetalii1();
			int idC = doctorgui.getIdConsult1();
			Consultation us = new Consultation(idC,idPac, idD, data,det);
			try{
			userg.update(us);
			users = userg.findAll();
			doctorgui.getModel().setRowCount(0);
			
			for(Consultation u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getIdConsult(),u.getIdPacient(),u.getIdDoctor(), u.getData(), u.getDescription()};
				doctorgui.getModel().addRow(dataRow);
		}	
			doctorgui.setIdConsult1("");
			doctorgui.setIdPac1("");
			doctorgui.setIdD1("");
			doctorgui.setData1("");
			doctorgui.setDetalii1("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class FindAllListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Consultation> users = null;
			ConsultationGateway userg = new ConsultationGateway();
			
			try{
			//userg.update(us);
			users = userg.findAll();
			doctorgui.getModel().setRowCount(0);
			
			for(Consultation u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getIdConsult(),u.getIdPacient(),u.getIdDoctor(), u.getData(), u.getDescription()};
				doctorgui.getModel().addRow(dataRow);
		}	
			doctorgui.setIdConsult1("");
			doctorgui.setIdPac1("");
			doctorgui.setIdD1("");
			doctorgui.setData1("");
			doctorgui.setDetalii1("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class AddBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Patient> users = null;
			PatientGateway userg = new PatientGateway();
			String nume = doctorgui.getNume();
			int cabinet = doctorgui.getCnp();
			String adresa = doctorgui.getAdresa();
			Patient us = new Patient(0,nume, cabinet, adresa);
			try{
			userg.add(us);
			users = userg.findAll();
			doctorgui.getModelPacienti().setRowCount(0);
			
			for(Patient u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCnp(), u.getAddress()};
				doctorgui.getModelPacienti().addRow(dataRow);
		}	
			doctorgui.setId("");
			doctorgui.setNume("");
			doctorgui.setCnp("");
			doctorgui.setAdresa("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	class DeleteBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Patient> users = null;
			PatientGateway userg = new PatientGateway();
			String nume = doctorgui.getNume();
			int cabinet = doctorgui.getCnp();
			String adresa = doctorgui.getAdresa();
			int id = doctorgui.getIdP();
			Patient us = new Patient(id,nume, cabinet, adresa);
			try{
			userg.delete(us);
			users = userg.findAll();
			doctorgui.getModelPacienti().setRowCount(0);
			
			for(Patient u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCnp(), u.getAddress()};
				doctorgui.getModelPacienti().addRow(dataRow);
		}	
			doctorgui.setId("");
			doctorgui.setNume("");
			doctorgui.setCnp("");
			doctorgui.setAdresa("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class UpdateBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Patient> users = null;
			PatientGateway userg = new PatientGateway();
			String nume = doctorgui.getNume();
			int cabinet = doctorgui.getCnp();
			String adresa = doctorgui.getAdresa();
			int id = doctorgui.getIdP();
			Patient us = new Patient(id,nume, cabinet, adresa);
			try{
			userg.update(us);
			users = userg.findAll();
			doctorgui.getModelPacienti().setRowCount(0);
			
			for(Patient u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCnp(), u.getAddress()};
				doctorgui.getModelPacienti().addRow(dataRow);
		}	
			doctorgui.setId("");
			doctorgui.setNume("");
			doctorgui.setCnp("");
			doctorgui.setAdresa("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	
	class FindAllBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
			List<Patient> users = null;
			PatientGateway userg = new PatientGateway();
			
			try{
			//userg.update(us);
			users = userg.findAll();
			doctorgui.getModelPacienti().setRowCount(0);
			
			for(Patient u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCnp(), u.getAddress()};
				doctorgui.getModelPacienti().addRow(dataRow);
		}	
			doctorgui.setId("");
			doctorgui.setNume("");
			doctorgui.setCnp("");
			doctorgui.setAdresa("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
}
