package App.Model;

import java.util.ArrayList;

public class Reunion {

	private int id;
	private String motivo;
	private ArrayList<Equipo> integrantes;
	
	
	/**
	 * Constructor vacío
	 */
	public Reunion() {
		super();
	}


	/**
	 * Constructor
	 * @param id
	 * @param motivo
	 * @param integrantes
	 */
	public Reunion(int id, String motivo, ArrayList<Equipo> integrantes) {
		super();
		this.id = id;
		this.motivo = motivo;
		this.integrantes = integrantes;
	}


//-------------------------------------Getters y Setters--------------------------------------------------------
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public ArrayList<Equipo> getIntegrantes() {
		return integrantes;
	}


	public void setIntegrantes(ArrayList<Equipo> integrantes) {
		this.integrantes = integrantes;
	}
	
	
	
	
}
