package App;
import java.io.IOException;

import App.Controllers.ColaboracionViewControllers;
import App.Controllers.ModelFactoryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	ModelFactoryController modelFactoryController;
//	Domain domain;	


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Modulo Colaboracion");
		
		initRootLayout();
	}
	
	/**
	 * Initializes the Root Layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Views/ColaboracionView.fxml"));
			BorderPane colaboracionOverview = (BorderPane) loader.load();
			
			// Give the con+troller access to the main app.
			// Le doy el acceso al controlodar de la main app
			ColaboracionViewControllers controller = loader.getController();
			controller.setMainApp(this);
			
			// Show the scene containing the root layout.
			Scene scene = new Scene(colaboracionOverview);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public BorderPane getRootLayout() {
		return rootLayout;
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
