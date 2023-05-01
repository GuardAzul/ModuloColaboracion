package App.Model;

public class Tarea {

	private String id;
	private String nombre;
	private String descripci�n;
	
	/**
	 * Constructor
	 */
	public Tarea() {
		super();
	}

	/**
	 * Constructor
	 * @param id
	 * @param nombre
	 * @param descripci�n
	 */
	public Tarea(String id, String nombre, String descripci�n) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
	}

	//-------------------------------------------Getters y Setters--------------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", descripci�n=" + descripci�n + "]";
	}
}
