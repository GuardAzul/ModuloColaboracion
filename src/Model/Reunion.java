package Model;

import java.util.ArrayList;

public class Reunion {

	private String id;
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
	public Reunion(String id, String motivo, ArrayList<Equipo> integrantes) {
		super();
		this.id = id;
		this.motivo = motivo;
		this.integrantes = integrantes;
	}


//-------------------------------------Getters y Setters--------------------------------------------------------
	public String getId() {
		return id;
	}


	public void setId(String id) {
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
