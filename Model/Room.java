package Model;

public class Room {
	private int id;
	private int idP;
	private boolean isAvailable;
	public Room(int id, int idP, boolean isAvailable){
		this.id = id;
		this.idP = idP;
		this.isAvailable = isAvailable;
	}
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", idP=" + idP + ", isAvailable=" + isAvailable + "]";
	}
	
	
}
