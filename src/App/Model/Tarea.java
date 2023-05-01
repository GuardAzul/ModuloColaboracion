package App.Model;

public class Tarea {

	private String id;
	private String nombre;
	private String descripción;
	
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
	 * @param descripción
	 */
	public Tarea(String id, String nombre, String descripción) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripción = descripción;
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

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", descripción=" + descripción + "]";
	}
}
