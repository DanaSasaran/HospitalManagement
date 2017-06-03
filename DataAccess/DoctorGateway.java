package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Doctor;
import Model.Doctor;

public class DoctorGateway {
	private static final String addDoctor = "insert into doctori (iddoctor,nume,cabinet) values(?, ?, ?)";
	private static final String deleteDoctor = "delete from doctori where iddoctor= ?";
	private static final String updateDoctor = "update doctori set nume = ?, cabinet = ? where iddoctor = ?";
	private static final String findAll = "select * from doctori";
	private static final String findById = "select * from doctori where iddoctor = ?";
	
	
	public void add(Doctor e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(addDoctor);
			statement.setInt(1, e.getId());
			statement.setString(2, e.getNume());
			statement.setString(3, e.getCabinet());

			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void delete(Doctor e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(deleteDoctor);
			statement.setInt(1, e.getId());
			
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public void update(Doctor e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(updateDoctor);
			statement.setInt(3, e.getId());
			statement.setString(1, e.getNume());
			statement.setString(2, e.getCabinet());
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	

	public ArrayList<Doctor> findDoctor(String Doctorname) {
		ArrayList<Doctor> Doctor = new ArrayList<Doctor>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findById);
			statement.setString(1, Doctorname);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				new Doctor(new Integer(rs.getInt("iddoctor")),
						new String(rs.getString("nume")),
						new String(rs.getString("cabinet"))
						);
			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Doctor;
	}
	

	public ArrayList<Doctor> findAll() {
		ArrayList<Doctor> Doctor = new ArrayList<Doctor>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findAll);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				Doctor.add(new Doctor(new Integer(rs.getInt("iddoctor")),
						new String(rs.getString("nume")),
						new String(rs.getString("cabinet"))
						));
			}
			
			
			//return Doctor;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Doctor;
	}

	

	public Doctor findByDoctorname(int iddoctor) {
		Doctor Doctor = null;
		
		try{
			
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = null;
			ResultSet rs = null;
			
			 statement = db
					.prepareStatement(findById);
			statement.setInt(1, iddoctor);
			
			 rs = statement.executeQuery();
		
			if(rs != null && rs.next()){
				Doctor = new Doctor(iddoctor, rs.getString("nume"), rs.getString("cabinet"));
			}

				} catch (Exception e) {
					e.printStackTrace();
				}
		return Doctor;
			}
	
	
	

}
