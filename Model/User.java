package Model;

public class User {

	private String username;
	private String password;
	private boolean isAdmin;
	private boolean isDoctor;
	private boolean isPacient;
	

	public User(String username, String password, boolean isAdmin, boolean isDoctor, boolean isPacient) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isDoctor = isDoctor;
		this.isPacient = isPacient;
	}
	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public boolean isDoctor() {
		return isDoctor;
	}
	public void setDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + ", isDoctor="
				+ isDoctor + ", isPacient=" + isPacient + "]";
	}
	public boolean isPacient() {
		return isPacient;
	}
	public void setPacient(boolean isSecretary) {
		this.isPacient = isSecretary;
	}

}
