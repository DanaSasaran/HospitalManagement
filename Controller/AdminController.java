package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import DataAccess.DoctorGateway;
import DataAccess.UserGateway;
import Model.Doctor;
import Model.User;
import View.AdminGUI;

public class AdminController {
	private AdminGUI admingui;
	
	
	
	public AdminController(AdminGUI admingui){
		this.admingui = admingui;
		
		this.admingui.findAllBListener(new FindAllBListener());
		this.admingui.addBListener(new AddBListener());
		this.admingui.deleteBListener(new DeleteBListener());
		this.admingui.updateBListener(new UpdateBListener());
		
		this.admingui.findAllListener(new FindAllListener());
		this.admingui.addListener(new AddListener());
		this.admingui.deleteListener(new DeleteListener());
		this.admingui.updateListener(new UpdateListener());
		
	//	this.admingui.addReportListener(new ReportListener());
	}
	
	class AddBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			//Doctor user = new Doctor();
			List<Doctor> users = null;
			DoctorGateway userg = new DoctorGateway();
			String nume = admingui.getNumeDoctor1();
			String cabinet = admingui.getCabinet1();
			Doctor us = new Doctor(0,nume, cabinet);
			try{
			userg.add(us);
			users = userg.findAll();
			admingui.getModel().setRowCount(0);
			
			for(Doctor u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCabinet()};
				admingui.getModel().addRow(dataRow);
		}	
			admingui.setCabinet1("");
			admingui.setNumeDoctor1("");
			admingui.setId("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	class DeleteBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			//Doctor user = new Doctor();
			List<Doctor> users = null;
			DoctorGateway userg = new DoctorGateway();
			String nume = admingui.getNumeDoctor1();
			String cabinet = admingui.getCabinet1();
			int id = admingui.getId();
			Doctor us = new Doctor(id,nume, cabinet);
			try{
			userg.delete(us);
			users = userg.findAll();
			admingui.getModel().setRowCount(0);
			
			for(Doctor u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCabinet()};
				admingui.getModel().addRow(dataRow);
		}	
			admingui.setCabinet1("");
			admingui.setNumeDoctor1("");
			admingui.setId("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class UpdateBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			//Doctor user = new Doctor();
			List<Doctor> users = null;
			DoctorGateway userg = new DoctorGateway();
			String nume = admingui.getNumeDoctor1();
			String cabinet = admingui.getCabinet1();
			int id = admingui.getId();
			Doctor us = new Doctor(id,nume, cabinet);
			try{
			userg.update(us);
			users = userg.findAll();
			admingui.getModel().setRowCount(0);
			
			for(Doctor u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCabinet()};
				admingui.getModel().addRow(dataRow);
		}	
			admingui.setCabinet1("");
			admingui.setNumeDoctor1("");
			admingui.setId("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	
	class FindAllBListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			//Doctor user = new Doctor();
			List<Doctor> users = null;
			DoctorGateway userg = new DoctorGateway();
			String nume = admingui.getNumeDoctor1();
			String cabinet = admingui.getCabinet1();
			Doctor us = new Doctor(0,nume, cabinet);
			try{
			//userg.update(us);
			users = userg.findAll();
			admingui.getModel().setRowCount(0);
			
			for(Doctor u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getId(),u.getNume(),u.getCabinet()};
				admingui.getModel().addRow(dataRow);
		}	
			admingui.setCabinet1("");
			admingui.setNumeDoctor1("");
			admingui.setId("");
		
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			User user = new User();
			List<User> users = null;
			UserGateway userg = new UserGateway();
			String username = admingui.getUsername();
			String password = admingui.getPassword1();
			Boolean isAdmin = admingui.getIsAdmin();
			Boolean isDoctor = admingui.getIsDoctor();
			Boolean isPacient = admingui.getIsPatient();
			User us = new User(username, password, isAdmin, isDoctor, isPacient);
			
			try{
			userg.add(us);
			users = userg.findAll();
			admingui.getModelUseri().setRowCount(0);
			
			for(User u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getUsername(),u.getPassword(),u.isAdmin(), u.isDoctor(), u.isPacient()};
				admingui.getModelUseri().addRow(dataRow);
		}	
			admingui.setUsername1("");
			admingui.setPassword1("");
			admingui.setIsAdmin(false);
			admingui.setIsDoctor(false);
			admingui.setIsPatient(false);
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	
	class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			User user = new User();
			List<User> users = null;
			UserGateway userg = new UserGateway();
			String username = admingui.getUsername();
			String password = admingui.getPassword1();
			Boolean isAdmin = admingui.getIsAdmin();
			Boolean isDoctor = admingui.getIsDoctor();
			Boolean isPacient = admingui.getIsPatient();
			User us = new User(username, password, isAdmin, isDoctor, isPacient);
			
			try{
			userg.delete(us);
			users = userg.findAll();
			admingui.getModelUseri().setRowCount(0);
			
			for(User u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getUsername(),u.getPassword(),u.isAdmin(), u.isDoctor(), u.isPacient()};
				admingui.getModelUseri().addRow(dataRow);
		}	
			admingui.setUsername1("");
			admingui.setPassword1("");
			admingui.setIsAdmin(false);
			admingui.setIsDoctor(false);
			admingui.setIsPatient(false);
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	
	class UpdateListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			User user = new User();
			List<User> users = null;
			UserGateway userg = new UserGateway();
			String username = admingui.getUsername();
			String password = admingui.getPassword1();
			Boolean isAdmin = admingui.getIsAdmin();
			Boolean isDoctor = admingui.getIsDoctor();
			Boolean isPacient = admingui.getIsPatient();
			User us = new User(username, password, isAdmin, isDoctor, isPacient);
			
			try{
			userg.update(us);
			users = userg.findAll();
			admingui.getModelUseri().setRowCount(0);
			
			for(User u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getUsername(),u.getPassword(),u.isAdmin(), u.isDoctor(), u.isPacient()};
				admingui.getModelUseri().addRow(dataRow);
		}	
			admingui.setUsername1("");
			admingui.setPassword1("");
			admingui.setIsAdmin(false);
			admingui.setIsDoctor(false);
			admingui.setIsPatient(false);
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
	
	
	class FindAllListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			User user = new User();
			List<User> users = null;
			UserGateway userg = new UserGateway();
			String username = admingui.getUsername();
			String password = admingui.getPassword1();
			Boolean isAdmin = admingui.getIsAdmin();
			Boolean isDoctor = admingui.getIsDoctor();
			Boolean isPacient = admingui.getIsPatient();
			User us = new User(username, password, isAdmin, isDoctor, isPacient);
			
			try{
			//userg.update(us);
			users = userg.findAll();
			admingui.getModelUseri().setRowCount(0);
			
			for(User u : users){
				System.out.println(u);
				
				Object dataRow [] = {u.getUsername(),u.getPassword(),u.isAdmin(), u.isDoctor(), u.isPacient()};
				admingui.getModelUseri().addRow(dataRow);
		}	
			admingui.setUsername1("");
			admingui.setPassword1("");
			admingui.setIsAdmin(false);
			admingui.setIsDoctor(false);
			admingui.setIsPatient(false);
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Nu sunt useri!");
		}
				
		}
	}
}
