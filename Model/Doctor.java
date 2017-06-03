
package Model;

public class Doctor {
	
	private int id;
	private String nume;
	private String cabinet;
	
	public Doctor(int id, String nume, String cabinet){
		this.id = id;
		this.nume = nume;
		this.cabinet = cabinet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCabinet() {
		return cabinet;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", nume=" + nume + ", cabinet=" + cabinet + "]";
	}
	
	
}
