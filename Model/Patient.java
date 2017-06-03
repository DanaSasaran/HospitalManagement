package Model;

public class Patient {

	private int id;
	private String nume;
	private int cnp;
	private String address;
	
	public Patient(int id, String nume, int cnp, String address){
		this.id = id;
		this.nume = nume;
		this.cnp = cnp;
		this.address = address;
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

	public int getCnp() {
		return cnp;
	}

	public void setCnp(int cnp) {
		this.cnp = cnp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nume=" + nume + ", cnp=" + cnp + ", address=" + address + "]";
	}
	
	
}
