package App.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import App.Model.Documento;
import App.Model.Domain;
import App.Model.Equipo;
import App.Model.EstadoEquipo;
import App.Model.EstadoProyecto;
import App.Model.Mensaje;
import App.Model.Persona;
import App.Model.Proyecto;
import App.Model.Reunion;
import App.Model.Tarea;

public class ModelFactoryController {


	Domain domain;
	
	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
		
	public ModelFactoryController() {
		if(domain == null){
			System.out.println("DOMAIN ES NULL");
			inicializarDatos();
//			guardarResourceSerializable();
//			guardarResourceXML();
		}
	}
		
	
	private void inicializarDatos() {
		domain = new Domain();
		
		// Creacion de personas
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombre("Ana");
		persona.setApellido("Rodriguez");
		persona.setFechaNacimiento(LocalDate.of(1995, 12, 31));
		persona.setDocumentos(null);
		persona.setMensajes(null);
		domain.getListaPersonas().add(persona);
		
		persona = new Persona();
		persona.setId(2);
		persona.setNombre("Carlos");
		persona.setApellido("Gonzalez");
		persona.setFechaNacimiento(LocalDate.of(1980, 5, 15));
		persona.setDocumentos(null);
		persona.setMensajes(null);
		domain.getListaPersonas().add(persona);

		persona.setId(3);
		persona.setNombre("Julia");
		persona.setApellido("Martinez");
		persona.setFechaNacimiento(LocalDate.of(1998, 2, 28));
		persona.setDocumentos(null);
		persona.setMensajes(null);
		domain.getListaPersonas().add(persona);

		// Creacion de proyectos
		Proyecto proyecto = new Proyecto();
		proyecto.setId(1);
		proyecto.setNombre("Construccion puente");
		proyecto.setDescripcion("Proyecto para construir un puente");
		proyecto.setEstado(EstadoProyecto.INICIADO);
		domain.getListaProyectos().add(proyecto);
		
		proyecto = new Proyecto();
		proyecto.setId(2);
		proyecto.setNombre("Construccion Edificio");
		proyecto.setDescripcion("Proyecto para construir un edificio");
		proyecto.setEstado(EstadoProyecto.INICIADO);
		domain.getListaProyectos().add(proyecto);

		proyecto = new Proyecto();
		proyecto.setId(3);
		proyecto.setNombre("Construccion Carretera");
		proyecto.setDescripcion("Proyecto para construir un edificio");
		proyecto.setEstado(EstadoProyecto.TERMINADO);
		domain.getListaProyectos().add(proyecto);
		
		// Creacion de equipos
		Equipo equipo = new Equipo();
		equipo.setId(1);
		equipo.setNombre("Equipo 1");
		equipo.setEstado(EstadoEquipo.LIBRE);
		equipo.setTareas(null);
			ArrayList<Persona> integrantes = new ArrayList<>();
			integrantes.add(domain.getListaPersonas().get(0));
			integrantes.add(domain.getListaPersonas().get(1));		
		equipo.setIntegrantes(integrantes);
		equipo.setProyecto(domain.getListaProyectos().get(0));
		domain.getListaEquipos().add(equipo);
		
		equipo = new Equipo();
		equipo.setId(2);
		equipo.setNombre("Equipo 2");
		equipo.setEstado(EstadoEquipo.LIBRE);
		equipo.setTareas(null);
			integrantes = new ArrayList<>();
			integrantes.add(domain.getListaPersonas().get(1));
			integrantes.add(domain.getListaPersonas().get(2));		
		equipo.setIntegrantes(integrantes);
		equipo.setProyecto(domain.getListaProyectos().get(1));
		domain.getListaEquipos().add(equipo);
		
		equipo = new Equipo();
		equipo.setId(3);
		equipo.setNombre("Equipo 3");
		equipo.setEstado(EstadoEquipo.OCUPADO);
		equipo.setTareas(null);
			integrantes = new ArrayList<>();
			integrantes.add(domain.getListaPersonas().get(2));
			integrantes.add(domain.getListaPersonas().get(0));		
		equipo.setIntegrantes(integrantes);
		equipo.setProyecto(domain.getListaProyectos().get(2));
		domain.getListaEquipos().add(equipo);
		
	
		// Creacion de reuniones
		Reunion reunion = new Reunion();
		reunion.setId(1);
		reunion.setMotivo("Est� Reunion se realiza porque tiririn tararan");
			ArrayList<Equipo> reu_int = new ArrayList<>();
			reu_int.add(domain.getListaEquipos().get(0));
			reu_int.add(domain.getListaEquipos().get(1));
		reunion.setIntegrantes(reu_int);
		domain.getListaReuniones().add(reunion);
		
		reunion = new Reunion();
		reunion.setId(2);
		reunion.setMotivo("Est� Reunion se realiza porque ya tu sabe");
			reu_int = new ArrayList<>();
			reu_int.add(domain.getListaEquipos().get(1));
			reu_int.add(domain.getListaEquipos().get(2));
		reunion.setIntegrantes(reu_int);
		domain.getListaReuniones().add(reunion);
		
	}
		
}