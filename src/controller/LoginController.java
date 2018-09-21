/**
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;

/**
 * @author ZeroN
 *
 */
public class LoginController implements Initializable {
	
	@FXML
	private TextField name;
	
	@FXML
	private PasswordField pass;
	
	public static Game game;
	

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			game = new Game();
			game.initRanking();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.sortRanking();
		
//		game.extractPlayersFromRanking();
	}
	
	public void singIn(ActionEvent event) {
		try {
			if (game.checkDeveloper(name.getText().toUpperCase(), pass.getText().toUpperCase())) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/HomePage.fxml"));
				loader.load();
				Parent root = loader.getRoot();
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setTitle("Home Page");
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
