package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.User;

public class UserGateway {
	private static final String addUser = "insert into useri (username,password,isAdmin, isDoctor, isPatient) values(?, ?, ?,?,?)";
	private static final String deleteUser = "delete from useri where username= ?";
	private static final String updateUser = "update useri set password = ?, isAdmin = ?, isDoctor = ?, isPatient=? where username = ?";
	private static final String findAll = "select * from useri";
	private static final String findById = "select * from useri where username = ?";
	
	
	public void add(User e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(addUser);
			statement.setString(1, e.getUsername());
			statement.setString(2, e.getPassword());
			statement.setBoolean(3, e.isAdmin());
			statement.setBoolean(4, e.isDoctor());
			statement.setBoolean(5, e.isPacient());
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void delete(User e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(deleteUser);
			statement.setString(1, e.getUsername());
			
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public void update(User e) {
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(updateUser);
			statement.setString(5, e.getUsername());
			statement.setString(1, e.getPassword());
			statement.setBoolean(2, e.isAdmin());
			statement.setBoolean(3, e.isDoctor());
			statement.setBoolean(4, e.isPacient());
		
			statement.executeUpdate();

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	

	public ArrayList<User> findUser(String username) {
		ArrayList<User> user = new ArrayList<User>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findById);
			statement.setString(1, username);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				new User(new String(rs.getString("username")),
						new String(rs.getString("password")),
						new Boolean(rs.getBoolean("isAdmin")),
						new Boolean(rs.getBoolean("isDoctor")),
						new Boolean(rs.getBoolean("isSecretary")));
			}
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	

	public ArrayList<User> findAll() {
		ArrayList<User> user = new ArrayList<User>();
		try{
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = db
					.prepareStatement(findAll);
		
			statement.execute();
			ResultSet rs = statement.getResultSet();
			
			
			while(rs.next()) {
				user.add(new User(new String(rs.getString("username")),
						new String(rs.getString("password")),
						new Boolean(rs.getBoolean("isAdmin")),
						new Boolean(rs.getBoolean("isDoctor")),
						new Boolean(rs.getBoolean("isPatient"))));
				
			}
			
			
			//return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}

	

	public User findByUsername(String username) {
		User user = null;
		
		try{
			
			Connection db = DBConnection.getDBConnection();
			PreparedStatement statement = null;
			ResultSet rs = null;
			
			 statement = db
					.prepareStatement(findById);
			statement.setString(1, username);
			
			 rs = statement.executeQuery();
		
			if(rs != null && rs.next()){
				user = new User(username, rs.getString("password"), rs.getBoolean("isAdmin"), rs.getBoolean("isDoctor"), rs.getBoolean("isPatient"));
			}

				} catch (Exception e) {
					e.printStackTrace();
				}
		return user;
			}
	
	
	
	public User login(String username, String password) {
		UserGateway userData = new UserGateway();
		User user = userData.findByUsername(username);
		if (user == null) {
			return null;
		}
		String userPassword = user.getPassword();
		if (userPassword != null && userPassword.equals(password)) {
			return user;
		}
		return null;
	}

}
