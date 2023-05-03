package App.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import App.MainApp;
import App.Model.EstadoTarea;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ColaboracionViewControllers implements Initializable {

	@FXML private TabPane mainTabPane;
    @FXML private Label lb_nomProyecto;
    @FXML private Label lb_descProyecto;
    @FXML private Label lb_estadoProyecto;
    @FXML private TableView<Tarea> tablaTareas;
    @FXML private TableColumn<Tarea, String> col_IdTarea;
    @FXML private TableColumn<Tarea, String> col_Tarea;
    @FXML private TableColumn<Tarea, String> col_EstadoTarea;
    @FXML private Button BtnActualizarVendedor;
    @FXML private ComboBox<EstadoTarea> cbEstadoTarea;
    @FXML private Label lb_descTarea;
    
    @FXML private HBox onlineUsersHbox;
    @FXML private ListView<?> userList;
    @FXML private ListView<?> chatPane;
    @FXML private TextArea messageBox;
    @FXML private Button btnSend;
    @FXML private Button btnDoc;

    private MainApp mainApp;
    ModelFactoryController modelFactoryController;
    Tarea tareaSeleccionada;
    ObservableList<Tarea> listaTareasData = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(()->{
			modelFactoryController = ModelFactoryController.getInstance();
			inicializarVista();
		});
				
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
	}
	
	public void inicializarVista() {
		
		
		
// ---------------------------- TAB TAREAS ----------------------------
		cbEstadoTarea.getItems().clear();
		cbEstadoTarea.getItems().addAll(EstadoTarea.values());
		
		col_IdTarea.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_Tarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		col_EstadoTarea.setCellValueFactory(new PropertyValueFactory<>("estado"));		
		 
		limpiarCampos();
		
		// A�ade los datos de la lista observable a la tabla
		// Esa lista se obtiene del modelFactoryController
		tablaTareas.setItems(getTareasData());
		
		// Acci�n de la tabla para mostrar informacion de un empleado
		tablaTareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
			tareaSeleccionada = newSelection;			
			
			mostrarInformacionTarea();
		});
	}
	
	private void mostrarInformacionTarea() {
		if(tareaSeleccionada != null){
			lb_descTarea.setText(tareaSeleccionada.getDescripci�n());
		    cbEstadoTarea.getSelectionModel().select(tareaSeleccionada.getEstado());
		}	
	}
	
	
	public void limpiarCampos() {
		// Limpio los textfield y combobox
		lb_descProyecto.setText("");		
		cbEstadoTarea.getSelectionModel().clearSelection();		
		
		tablaTareas.getSelectionModel().clearSelection();		
    }
	
	
	@FXML
    void onBtnActualizarTarea(ActionEvent event) {
		
    }

    @FXML
    void onBtnDoc(ActionEvent event) {

    }

    @FXML
    void onBtnSend(ActionEvent event) {

    }
    
    
// Este metodo recibir�a el usuario que est� logueado (o el equipo), pero como 
// no tenemos un Login no recibir� ningun parametro, por lo que la lista de tareas  
// que retorne ser�n las tareas de un equipo aleatorio (en este caso el equipo 1)
    public ObservableList<Tarea> getTareasData(){
		listaTareasData.addAll(modelFactoryController.getListaTareasPorEquipo(1)) ;
		return listaTareasData;
	}
	
}
