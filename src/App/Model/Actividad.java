package App.Model;

public class Actividad {

	private String id;
	private String descripcion;
	
	
	/**
	 * Constructor vacío
	 */
	public Actividad() {
		super();
	}

	/**
	 * Constructor
	 * @param id
	 * @param descripcion
	 */
	public Actividad(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

//------------------------------Getters y Setters---------------------------------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
