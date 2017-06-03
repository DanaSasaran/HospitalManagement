package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Patient;

public class PatientGateway {
	private static final String addPatient = "insert into pacienti (idpacient,nume,cnp,adresa) values(?, ?, ?,?)";
	private static final String deletePatient = "delete from pacienti where idpacient= ?";
	private static final String updatePatient = "update pacienti set nume = ?, cnp = ?, adresa=? where idpacient = ?";
	private static final String findAll = "select * from pacienti";
	private static final String findById = "select * from pacienti where idpacient = ?";
	
	
	public void add(Patient e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(addPatient);
			statement.setInt(1, e.getId());
			statement.setString(2, e.getNume());
			statement.setInt(3, e.getCnp());
			statement.setString(4, e.getAddress());

			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void delete(Patient e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(deletePatient);
			statement.setInt(1, e.getId());
			
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public void update(Patient e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(updatePatient);
			statement.setInt(4, e.getId());
			statement.setString(1, e.getNume());
			statement.setInt(2, e.getCnp());
			statement.setString(3, e.getAddress());
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	

	public ArrayList<Patient> findPatient(String Patientname) {
		ArrayList<Patient> Patient = new ArrayList<Patient>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findById);
			statement.setString(1, Patientname);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				Patient.add(new Patient(new Integer(rs.getInt("idpacient")),
						new String(rs.getString("nume")),
						new Integer(rs.getInt("cnp")),
						new String(rs.getString("adresa"))
						));
			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Patient;
	}
	

	public ArrayList<Patient> findAll() {
		ArrayList<Patient> Patient = new ArrayList<Patient>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findAll);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				Patient.add(new Patient(new Integer(rs.getInt("idpacient")),
						new String(rs.getString("nume")),
						new Integer(rs.getInt("cnp")),
						new String(rs.getString("adresa"))
						));
			}
			
			
			//return Patient;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Patient;
	}

	

	
	
	
}
