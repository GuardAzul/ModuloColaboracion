package App.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private EstadoEquipo estado;
	private ArrayList<Tarea> tareas;
	private ArrayList<Persona> integrantes;
	private Proyecto proyecto;
	
	
	public Equipo() {
		super();
	}
	
	
	public Equipo(int id, String nombre, EstadoEquipo estado, ArrayList<Tarea> tareas, 
			ArrayList<Persona> integrantes, Proyecto proyecto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.tareas = tareas;
		this.integrantes = integrantes;
		this.proyecto = proyecto;
	}

	//-------------------------------------getters y setters-----------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoEquipo getEstado() {
		return estado;
	}

	public void setEstado(EstadoEquipo estado) {
		this.estado = estado;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	public ArrayList<Persona> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Persona> integrantes) {
		this.integrantes = integrantes;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}

}
