package App.Model;

import java.util.ArrayList;

public class Domain {

	ArrayList<Persona> listaPersonas = new ArrayList<>();
	ArrayList<Equipo> listaEquipos = new ArrayList<>();
	ArrayList<Proyecto> listaProyectos = new ArrayList<>();
	ArrayList<Reunion> listaReuniones = new ArrayList<>();
	
	public Domain() {
		
	}

	
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
