package App.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Domain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	ArrayList<Persona> listaPersonas = new ArrayList<>();
	ArrayList<Equipo> listaEquipos = new ArrayList<>();
	ArrayList<Proyecto> listaProyectos = new ArrayList<>();
	ArrayList<Reunion> listaReuniones = new ArrayList<>();
	
	public Domain() {
		
	}

	
	public ArrayList<Tarea> getListaTareasPorEquipo(int idEquipo) {
		return getEquipoPorId(idEquipo).getTareas();
	}
	
	public Tarea getTareaPorIdYEquipo(String idTarea, int idEquipo) {
		ArrayList<Tarea> equipos = getListaTareasPorEquipo(idEquipo);
		Tarea tarea = null;
		
		for(Tarea t : equipos) {
			if(t.getId() == idTarea || t.getId().equalsIgnoreCase(idTarea)) {
				tarea = t;
				break;
			}
		}
		
		return tarea;
	}

	
	public Equipo getEquipoPorId(int idEquipo) {
		Equipo equipo = null;
		
		for(Equipo e: getListaEquipos()){
			if(e.getId() == idEquipo){
				equipo = e;
				break;
			}
		}
		
		return equipo;
	}
	
	public Proyecto getProyecto(int idProyecto) {
		Proyecto proyectoEncontrado = null;

		for (Proyecto p : getListaProyectos()) {
			if(p.getId() == idProyecto) {
				proyectoEncontrado = p;
				break;
			}
		}

		return proyectoEncontrado;	
	}
	
	
	public boolean actualizarEstadoTarea(int idEquipo, String idTarea, EstadoTarea nuevoEstado) {
		Boolean flagActualizada = false;
		Equipo equipo = getEquipoPorId(idEquipo);
		
		if(equipo != null){
			Tarea tarea = getTareaPorIdYEquipo(idTarea, idEquipo);
			tarea.setEstado(nuevoEstado);
			flagActualizada = true;
		}			
		else{
			System.out.println("No se ha podido actualizar");
		}
		
		return flagActualizada;
	}		
	
	public Persona getPersonaPorId(int idPersona) {
		Persona personaEncontrada = null;

		for (Persona p : getListaPersonas()) {
			if(p.getId() == idPersona) {
				personaEncontrada = p;
				break;
			}
		}

		return personaEncontrada;	
	}
	

	public boolean agregarMensaje(int idPersona, Mensaje mensaje) {		
		if(getPersonaPorId(idPersona)!=null) {
			System.out.println("idPe: "+idPersona+ " msj: "+mensaje.getContenido());
			getPersonaPorId(idPersona).getMensajes().add(mensaje);
			return true;	
		}
		
		return false;
	}
	
	
	// -------------------------- GETTERS Y SETTERS COMUNES --------------------------  
	public ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public ArrayList<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(ArrayList<Proyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}

	public ArrayList<Reunion> getListaReuniones() {
		return listaReuniones;
	}

	public void setListaReuniones(ArrayList<Reunion> listaReuniones) {
		this.listaReuniones = listaReuniones;
	}

}
