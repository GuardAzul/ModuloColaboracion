package App.Controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import App.MainApp;
import App.Model.EstadoTarea;
import App.Model.Mensaje;
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
import javafx.scene.control.Alert.AlertType;
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
import javafx.stage.FileChooser;

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
    @FXML private Label lb_usuario_amigo;
    @FXML private TextArea txt_mensajes;
    @FXML private TextArea messageBox;
    @FXML private Button btnSend;
    @FXML private Button btnDoc;

    private MainApp mainApp;
    ModelFactoryController modelFactoryController;
    Proyecto proyectoAsignado; 
    Tarea tareaSeleccionada;
    Persona usuario;
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
		// ---------------------------- INFO PROYECTO ----------------------------
		proyectoAsignado = modelFactoryController.getProyecto(1); // 1 por que es el proyecto asignado al grupo de este usuario 1
		lb_nomProyecto.setText(proyectoAsignado.getNombre());
	    lb_descProyecto.setText(proyectoAsignado.getDescripcion());
	    lb_estadoProyecto.setText(proyectoAsignado.getEstado().toString());
		
		
		// ---------------------------- INFO TAREAS ----------------------------
		cbEstadoTarea.getItems().clear();
		cbEstadoTarea.getItems().addAll(EstadoTarea.values());
		
		col_IdTarea.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_Tarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		col_EstadoTarea.setCellValueFactory(new PropertyValueFactory<>("estado"));		
		 
		limpiarCampos();
		
		// Añade los datos de la lista observable a la tabla
		// Esa lista se obtiene del modelFactoryController
		tablaTareas.setItems(getTareasData());
		
		// Acción de la tabla para mostrar informacion de un empleado
		tablaTareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
			tareaSeleccionada = newSelection;			
			
			mostrarInformacionTarea();
		});
		
		inicializarChat();
	}
	
	private void inicializarChat() {
		// ---------------------------- INFO CHAT ----------------------------
		Persona amigo = modelFactoryController.getPersonaPorId(2);
		System.out.println("amigo: "+amigo.getNombre()+" id: "+amigo.getId());
		lb_usuario_amigo.setText(amigo.getNombre());
		
		usuario = modelFactoryController.getPersonaPorId(1);
		
		cargarMensajesChat(usuario);
		
	}
	
	private void mostrarInformacionTarea() {
		if(tareaSeleccionada != null){
			lb_descTarea.setText(tareaSeleccionada.getDescripción());
		    cbEstadoTarea.getSelectionModel().select(tareaSeleccionada.getEstado());
		}	
	}
	
	private void cargarMensajesChat(Persona pers) {
		ArrayList<Mensaje> mensajes = pers.getMensajes();		
		
		try {
			for(Mensaje m : mensajes) {
				txt_mensajes.appendText(m.getContenido());
			}	
		}
		catch(NullPointerException e) {
			System.out.println("No hay mensajes");
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
    void onBtnSend(ActionEvent event) {
    	txt_mensajes.appendText("\n"+messageBox.getText());
    	Mensaje nuevoMensaje = new Mensaje("\n"+messageBox.getText());
    	
    	modelFactoryController.agregarMensaje(usuario.getId(), nuevoMensaje);
    	modelFactoryController.guardarResourceBinario();
    }
    
    @FXML
    void onBtnDoc(ActionEvent event) {
    	subirImagen();
    }
    
    public void subirImagen(){
		// File chooser que solo permita subir archivos de tal tipo (segun requisitos)
		FileChooser fileChooser = new FileChooser();
	    FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
    	FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
    	FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PDF files(*.pdf)","*.PDF");
    	FileChooser.ExtensionFilter ext4 = new FileChooser.ExtensionFilter("DOCX files(*.docx)",".DOCX");
    	FileChooser.ExtensionFilter ext5 = new FileChooser.ExtensionFilter("PPTX files(*.pptx)",".pptx");
    	FileChooser.ExtensionFilter ext6 = new FileChooser.ExtensionFilter("XLS files(*.xls)",".xls");
    	FileChooser.ExtensionFilter ext7 = new FileChooser.ExtensionFilter("TXT files(*.txt)",".txt");
    																	   
    	fileChooser.getExtensionFilters().addAll(ext1, ext2, ext3, ext4, ext5, ext6, ext7);
    	
    	File archivoSeleccionado = fileChooser.showOpenDialog(null);
    	
//    	try {    		        		
//	    	BufferedImage bf;	
//	    	
//	    	if(archivoSeleccionado != null){
//	    		// Leo la imagen para luego mostrarla en el ImageView
//				bf = ImageIO.read(archivoSeleccionado);
//				
//	    		Imageimagen = SwingFXUtils.toFXImage(bf, null);
//	    		imagenViewProducto.setImage(imagen);    	   
//	    		
//	    		// Hacer una copia de la imagen porque la imagen le pertenece a la ruta especifica del usuario
//	    		// Y guardo la nueva ruta para asignarsela al producto
//	    		if(productoSeleccionado != null){
//	    			rutaImagenProductoSeleccionado = crudVendedorViewController.copiarImagen(productoSeleccionado.getNombre(),
//																		    				 archivoSeleccionado.getAbsolutePath());    	    		    	    			   
//	    		} 
//	    		else{ // Esto me permite guardar la imagen de un nuevo producto sin hacer seleccion en la tabla 
//	    			rutaImagenNuevoProducto = crudVendedorViewController.copiarImagen(txtNombreProducto.getText(),
//		    				 														  archivoSeleccionado.getAbsolutePath());
//	    		}
//	    	
//	    	}
//	    	else{
//	    		mostrarMensaje("Notifacion", "Archivo NO valido", "El archivo no ha sido encontrado", AlertType.ERROR);
//	    	}
//    	} catch (IOException e) {
//			e.printStackTrace();
//		}	
    	
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
    public ObservableList<Tarea> getTareasData(){
		listaTareasData.addAll(modelFactoryController.getListaTareasPorEquipo(1)) ;
		return listaTareasData;
	}
    
    
	
}
