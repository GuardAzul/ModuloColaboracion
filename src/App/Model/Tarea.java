package App.Model;

public class Tarea {

	private String id;
	private String nombre;
	private String descripci�n;
	private EstadoTarea estado;
	
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
	 * @param estado
	 */
	public Tarea(String id, String nombre, String descripci�n, EstadoTarea estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
		this.estado = estado;
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

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", descripci�n=" + descripci�n + ", estado=" + estado + "]";
	}
	
	
}
