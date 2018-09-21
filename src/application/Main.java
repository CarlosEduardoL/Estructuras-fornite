++package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
//			Parent root = FXMLLoader.load(getClass().getResource("/application/window.fxml"));
//			Scene scene = new Scene(root,659,373);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();
			
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
