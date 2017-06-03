package DataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Consultation;
import Model.Patient;
import Model.Room;

public class RoomGateway {
	private static final String addPatient = "insert into rooms (idroom,idPacient,free) values(?, ?, ?)";
	//private static final String deletePatient = "delete from pacienti where idpacient= ?";
	private static final String updatePatient = "update rooms set free=? where idroom = ?";
	private static final String findAll = "select * from rooms";
	private static final String findById = "select * from rooms where idroom = ?";
	
	public void update(int id, boolean b) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(updatePatient);
			statement.setInt(2,id);
			statement.setBoolean(1, b);
			
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void add(Room e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(addPatient);
			statement.setInt(1, e.getId());
			statement.setInt(2, e.getIdP());
			statement.setBoolean(3, e.isAvailable());
			

			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public ArrayList<Room> findById(int id) {
		ArrayList<Room> user = new ArrayList<Room>();
		Room r = new Room();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findById);
			statement.setInt(1, id);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				user.add(new Room(rs.getInt("idroom"), rs.getInt("idPacient"), rs.getBoolean("free")));
			
			}
		 //r = new Room(rs.getInt("idroom"), rs.getInt("idPacient"), rs.getBoolean("free"));
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}

	public ArrayList<Room> findAll() {
		ArrayList<Room> Patient = new ArrayList<Room>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findAll);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				Patient.add(new Room(new Integer(rs.getInt("idroom")),
						
						new Integer(rs.getInt("idPacient")),
						new Boolean(rs.getBoolean("free"))
						));
			}
			
			
			//return Patient;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Patient;
	}

	

	
}
