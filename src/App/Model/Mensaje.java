package App.Model;

import java.io.Serializable;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String contenido;
	
	public Mensaje() {
		super();
	}

	public Mensaje(String id, String contenido) {
		super();
		this.id = id;
		this.contenido = contenido;
	}
	
	//---------------------------Getters y Setters-----------------------------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", contenido=" + contenido + "]";
	}

}
