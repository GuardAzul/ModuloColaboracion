package App.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import App.MainApp;
import javafx.fxml.Initializable;

public class ChatViewController implements Initializable{

	private MainApp mainApp;
    ModelFactoryController modelFactoryController;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		modelFactoryController = ModelFactoryController.getInstance();		
	}

	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
	}


	public void establecerValores(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;		
	}

}
