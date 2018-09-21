/**
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

/**
 * @author ZeroN
 *
 */
public class HomeController implements Initializable {
	
	private Game game = LoginController.game;

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void viewRanking(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getClass().getResource("/application/Ranking.fxml"));
		try {
			loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Parent root = loader.getRoot();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Ranking");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void viewValentine(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getClass().getResource("/application/Valentine.fxml"));
		try {
			loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Parent root = loader.getRoot();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Ranking");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
