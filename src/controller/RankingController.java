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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Game;
import model.Player;

/**
 * @author ZeroN
 *
 */
public class RankingController implements Initializable {

	@FXML
	TextArea area;

	private Game game = LoginController.game;

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		viewRanking();
	}
	
	public void goToHomePage(ActionEvent event) throws IOException {
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
	
	public void viewRanking() {
		Player[] ps = game.getRanking().getRanking(); 

		String a = "";
		
		for (int i = 1; i < ps.length; i++) {
			if (ps[i]!=null) {
				a += i + ") " + ps[i].getNickName() + "           Skill:" + ps[i].getSkill() + "\n";
				System.err.println(i);
			}
		}
		area.setText(a);
	}

}
