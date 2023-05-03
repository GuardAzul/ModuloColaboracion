package App.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import App.MainApp;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ColaboracionViewControllers implements Initializable {

	@FXML private TabPane mainTabPane;
    @FXML private Label lb_nomProyecto;
    @FXML private Label lb_descProyecto;
    @FXML private Label lb_estadoProyecto;
    @FXML private TableView<?> tablaTareas;
    @FXML private TableColumn<?, ?> col_IdTarea;
    @FXML private TableColumn<?, ?> col_Tarea;
    @FXML private TableColumn<?, ?> col_EstadoTarea;
    @FXML private Button BtnActualizarVendedor;
    @FXML private ComboBox<?> cbEstadoTarea;
    @FXML private Label lb_descTarea;
    
    @FXML private HBox onlineUsersHbox;
    @FXML private ListView<?> userList;
    @FXML private ListView<?> chatPane;
    @FXML private TextArea messageBox;
    @FXML private Button btnSend;
    @FXML private Button btnDoc;

    private MainApp mainApp;
    ModelFactoryController modelFactoryController;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		modelFactoryController = ModelFactoryController.getInstance();		
	}

	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
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
	
}
