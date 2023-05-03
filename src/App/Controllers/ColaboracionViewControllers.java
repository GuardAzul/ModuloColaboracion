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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class ColaboracionViewControllers implements Initializable {

    @FXML private Menu proyectoMenu;
    @FXML private Menu tareaMenu;
    @FXML private Menu reunionMenu;
    @FXML private Menu chatsMenu;
    @FXML private Label nombreProyecto;
    @FXML private TextArea descripcionProyecto;
	
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
    void onChatsMenu(ActionEvent event) {
		
		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Views/ChatView.fxml"));
			BorderPane root;		
			root = loader.load();
					
			ChatViewController chatViewController = loader.getController();
			chatViewController.setMainApp(mainApp);
			chatViewController.establecerValores(modelFactoryController);
		
		//		Scene scene = btnIngresar.getScene();
			Scene scene = new Scene(root);
		//		AnchorPane loginView = (AnchorPane) scene.getRoot();
		//		loginView.getChildren().add(root);
			mainApp.getPrimaryStage().setScene(scene);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
