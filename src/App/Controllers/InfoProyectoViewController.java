package App.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import App.MainApp;
import App.Model.EstadoTarea;
import App.Model.Persona;
import App.Model.Proyecto;
import App.Model.Tarea;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class InfoProyectoViewController implements Initializable {

	@FXML private TabPane mainTabPane;
    @FXML private Label lb_nomProyecto;
    @FXML private Label lb_nomProyecto1;
    @FXML private Label lb_descProyecto;
    @FXML private Label lb_estadoProyecto;
    @FXML private TableView<Tarea> tablaTareas;
    @FXML private TableColumn<Tarea, String> col_IdTarea;
    @FXML private TableColumn<Tarea, String> col_Tarea;
    @FXML private TableColumn<Tarea, String> col_EstadoTarea;
    @FXML private Button BtnActualizarVendedor;
    @FXML private ComboBox<EstadoTarea> cbEstadoTarea;
    @FXML private Label lb_descTarea;
    
    @FXML private Button btnLogout;
    @FXML private Button btnRegresar;
    

    private MainApp mainApp;
    ModelFactoryController modelFactoryController;
    Proyecto proyectoAsignado; 
    Tarea tareaSeleccionada;
    Persona usuario;
    ObservableList<Tarea> listaTareasData = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(()->{
//			modelFactoryController = ModelFactoryController.getInstance();
			modelFactoryController =  mainApp.getModelFactoryController();
			inicializarVista();
		});				
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
	}
	
	// TODO: YO CREERIA QUE ES MEJOR AGREGARLE UN BOTON COMO VER Y LO QUE HAGA SEA ABRIR
	// OTRO CONTROLADOR CON LA MISMA PLANTILLA (USER LOGOUT) Y PONER LA TODA LA INFORMACION
	// DEL PROYECTO CON LAS TAREAS DE FORMA DINAMICA
	// O HACER OTRO TABPANE INVISIBLE, PERO QUEDARIA DEMASIADO CODIGO EN SOLO ESTE CONTROLADOR
	// POR LO QUE CREO QUE ES MEJOR LA PRIMERA OPCION
   
	public void inicializarVista() {		
		// ---------------------------- INFO PROYECTO ----------------------------
//		proyectoAsignado = modelFactoryController.getProyecto(1); // 1 por que es el proyecto asignado al grupo de este usuario 1
//		lb_nomProyecto.setText(proyectoAsignado.getNombre());
//	    lb_descProyecto.setText(proyectoAsignado.getDescripcion());
//	    lb_estadoProyecto.setText(proyectoAsignado.getEstado().toString());
//		
//		
//		// ---------------------------- INFO TAREAS ----------------------------
//		cbEstadoTarea.getItems().clear();
//		cbEstadoTarea.getItems().addAll(EstadoTarea.values());
//		
//		col_IdTarea.setCellValueFactory(new PropertyValueFactory<>("id"));
//		col_Tarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//		col_EstadoTarea.setCellValueFactory(new PropertyValueFactory<>("estado"));		
//		 
//		limpiarCampos();
//		
//		// Añade los datos de la lista observable a la tabla
//		// Esa lista se obtiene del modelFactoryController
//		tablaTareas.setItems(getTareasData());
//		
//		// Acción de la tabla para mostrar informacion de un empleado
//		tablaTareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
//			tareaSeleccionada = newSelection;			
//			
//			mostrarInformacionTarea();
//		});
		
	}
	
	private void mostrarInformacionTarea() {
		if(tareaSeleccionada != null){
			lb_descTarea.setText(tareaSeleccionada.getDescripción());
		    cbEstadoTarea.getSelectionModel().select(tareaSeleccionada.getEstado());
		}	
	}
	
	
	
	public void limpiarCampos() {
		// Limpio los textfield y combobox
		lb_descTarea.setText("");		
		cbEstadoTarea.getSelectionModel().clearSelection();		
		
		tablaTareas.getSelectionModel().clearSelection();		
    }
	
	
	@FXML
    void onBtnActualizarTarea(ActionEvent event) {
		int idEquipo = 1; // Equipo en el que está el usuario (Esto no se conoce, debe ser de otro modulo)
		String idTarea = tareaSeleccionada.getId();
		EstadoTarea nuevoEstado = cbEstadoTarea.getValue();
		if (modelFactoryController.actualizarEstadoTarea(idEquipo, idTarea, nuevoEstado)) {
			mostrarMensaje("Notificacion", "Tarea Actualizada", "La tarea ha sido actualizada con exito", AlertType.INFORMATION);
			modelFactoryController.guardarResourceBinario();
			tablaTareas.refresh();
		}			
		else {
			mostrarMensaje("Error", "Tarea No Actualizada", "La tarea NO ha sido actualizada con exito", AlertType.ERROR);
		}					
    }
  
    @FXML
    void onBtnLogout(ActionEvent event) { 
			mostrarMensaje("Notifacion", "Cerrando Sesion", "Usuario: "+mainApp.getUsuarioLogeado().getNombre()+ " ha cerrado sesion", AlertType.INFORMATION);
			mainApp.setUsuarioLogeado(null);
			
			// Llamo al LoginViewController y cambio la view (el fxml)				
			try {			
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Views/Login.fxml"));
				Parent root = loader.load();
				
				// Creo el controlador
				LoginViewController loginViewController = loader.getController();
				loginViewController.setMainApp(mainApp);
			
				Scene scene = new Scene(root);
				mainApp.getPrimaryStage().setScene(scene);				
			} 
			catch (IOException e) {
				e.printStackTrace();
    		}	
    }
    
    @FXML
    void onBtnRegresar(ActionEvent event) {
    	try {			
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Views/Colaboracion.fxml"));
			Parent root = loader.load();

			// Creo el controlador y se le asigna la MainApp
			ColaboracionViewController colaboracionViewController = loader.getController();
			colaboracionViewController.setMainApp(mainApp);
			
			Scene scene = new Scene(root);
			mainApp.getPrimaryStage().setScene(scene);					
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType){
    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
    }
    
    
// Este metodo recibiría el usuario que está logueado (o el equipo), pero como 
// no tenemos un Login no recibirá ningun parametro, por lo que la lista de tareas  
// que retorne serán las tareas de un equipo aleatorio (en este caso el equipo 1,
// en el cual se encuentra el usuario 1)
//    public ObservableList<Tarea> getTareasData(){
//		listaTareasData.addAll(modelFactoryController.getListaTareasPorEquipo(1)) ;
//		return listaTareasData;
//	}
	


}
