package App.Controllers.dinamico;

import java.net.URL;
import java.util.ResourceBundle;

import App.Model.Proyecto;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ProyectoController implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private Label idProyecto;
    @FXML private Label nombreProyecto;
    @FXML private Label estadoProyecto;
	
	Proyecto proyecto;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(()->{
			inicializarDatos();
		});
	}


	// Recordar: Javafx funciona de manera extraña, como cualquier otro framework.
	// Cuando llamamos esta funcion luego de crear un controlador con esta clase,
	// No podemos asignarle valores a sus atributos @FXML (label, button ...), 
	// porque aún no se han creado por completo. Por lo que hacemos es guardar
	// datos en una variable normal (proyecto) la cual se le obtendran los datos
	// para luego asignarlos a los atributos @FXML usando Platform.runLater()
	
	// Platform.runLater() --> se Ejecuta luego de crear todos los atributos
	// del controlador de javafx (@FXML en concreto)
	public void establecerDatos(Proyecto proyecto) {
		this.proyecto = proyecto;		
	}
	
	public void inicializarDatos() {
		idProyecto.setText(""+proyecto.getId());
	    nombreProyecto.setText(proyecto.getNombre());
	    estadoProyecto.setText(proyecto.getEstado().toString());
	}

}
