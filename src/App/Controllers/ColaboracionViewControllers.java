package App.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import App.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;

public class ColaboracionViewControllers implements Initializable {

    @FXML private Menu proyectoMenu;
    @FXML private Menu tareaMenu;
    @FXML private Menu reunionMenu;
    @FXML private Menu chatsMenu;
    @FXML private Label nombreProyecto;
    @FXML private TextArea descripcionProyecto;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	public void setMainApp(MainApp mainApp) {
		// TODO Auto-generated method stub
		
	}
}
