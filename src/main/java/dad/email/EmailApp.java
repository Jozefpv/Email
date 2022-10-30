package dad.email;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EmailApp extends Application{
	public static Stage PrimaryStage;
	private Controller controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		EmailApp.PrimaryStage = primaryStage;
		controller = new Controller();
		
		primaryStage.setTitle("Enviar email");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.getIcons().add(new Image("/images/email-send-icon-32x32.png"));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
