package App.Model;

public class Proyecto {

	private String id;
	private String descripcion;
	private EstadoProyecto estado;
	private String nombre;
	
	/**
	 * Constructor
	 */
	public Proyecto() {
		super();
	}

	/**
	 * Constructor
	 * @param id
	 * @param descripcion
	 * @param estado
	 * @param nombre
	 */
	public Proyecto(String id, String descripcion, EstadoProyecto estado, String nombre) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.nombre = nombre;
	}

	//-------------------------------Getters y Setter----------------------------------------------
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

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", nombre=" + nombre
				+ "]";
	}
	
	
	
	
}
