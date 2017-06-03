package Model;

import java.util.Date;

public class Consultation {

	private int idConsult;
	private int idPacient;
	private int idDoctor;
	private Date data;
	private String description;
	
	public Consultation(int idC, int idP, int idD, Date data, String desc){
		this.idConsult = idC;
		this.idPacient = idP;
		this.idDoctor = idD;
		this.data = data;
		this.description = desc;
	}

	public int getIdConsult() {
		return idConsult;
	}

	public void setIdConsult(int idConsult) {
		this.idConsult = idConsult;
	}

	public int getIdPacient() {
		return idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Consultation [idConsult=" + idConsult + ", idPacient=" + idPacient + ", idDoctor=" + idDoctor
				+ ", data=" + data + ", description=" + description + "]";
	}
	
}
