package DataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Consultation;
import Model.Doctor;

public class ConsultationGateway {
	private static final String addConsultation = "insert into programari (idprogramare,idPacient,idDoctor, data, description) values(?, ?, ?, ?,?)";
	private static final String deleteConsultation = "delete from programari where idprogramare= ?";
	private static final String updateConsultation = "update programari set idPacient = ?, idDoctor = ?, data =?, description = ? where idprogramare = ?";
	private static final String findAll = "select * from programari";
	private static final String findById = "select * from programari where idprogramare = ?";
	private static final String findByIDPacient = "select * from programari where idPacient =?";
	
	public void add(Consultation e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(addConsultation);
			statement.setInt(1, e.getIdConsult());
			statement.setInt(2, e.getIdPacient());
			statement.setInt(3, e.getIdDoctor());
			statement.setDate(4, (Date)e.getData());
			statement.setString(5, e.getDescription());

			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public ArrayList<Consultation> findById(int id) {
		ArrayList<Consultation> user = new ArrayList<Consultation>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findByIDPacient);
			statement.setInt(1, id);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				user.add(new Consultation(rs.getInt("idprogramare"), rs.getInt("idPacient"), rs.getInt("idDoctor"), rs.getDate("data"), rs.getString("description")));
			
			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	public void delete(Consultation e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(deleteConsultation);
			statement.setInt(1, e.getIdConsult());
			
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public void update(Consultation e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(updateConsultation);
			statement.setInt(5, e.getIdConsult());
			statement.setInt(1, e.getIdPacient());
			statement.setInt(2, e.getIdDoctor());
			statement.setDate(3, (Date)e.getData());
			statement.setString(4, e.getDescription());
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public ArrayList<Consultation> findAll() {
		ArrayList<Consultation> consult = new ArrayList<Consultation>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findAll);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				consult.add(new Consultation(rs.getInt("idprogramare"), rs.getInt("idPacient"), rs.getInt("idDoctor"), rs.getDate("data"), rs.getString("description")));
			}
			
			
			//return Consultation;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return consult;
	}

	
	

}
