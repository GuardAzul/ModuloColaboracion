package App.Model;

public class Mensaje {

	private String id;
	private String contenido;
	
	/**
	 * Constructor vacío
	 */
	public Mensaje() {
		super();
	}

	/**
	 * Constructor
	 * @param id
	 * @param contenido
	 */
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
