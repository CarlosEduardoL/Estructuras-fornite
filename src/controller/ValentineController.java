/**
 * 
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Player;
import model.Weapon;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public class ValentineController implements Initializable {
	
	public static final int MAX_X = 349;
	public static final int MAX_Y = 432;

	@FXML
	private Pane pane;
	
	@FXML
	private TextField ammunition;

	@FXML
	private Button button;

	@FXML
	private ToggleGroup type;
	
	@FXML
	private RadioButton w1,w2,w3,w4,w5;
	
	private boolean left;
	
	private Player testPlayer;
	
	@FXML
	private Label total;
	
	@FXML
	private ImageView image;



	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		testPlayer = LoginController.game.getRanking().getRanking()[0];
		button.setFocusTraversable(true);
		button.requestFocus();
		System.out.println(button.isFocused() + " " + button.isFocusTraversable());
	}
	
	public void generateWeapon(ActionEvent event) {
		String img = "";
		if (w1.isSelected()) {
			img = "/explosiveWeapon.png";
		}else if (w2.isSelected()) {
			img = "/fortnite-tactical-shotgun-png-3.png";
		}else if (w3.isSelected()) {
			img = "/thermal-scope-assault-rifle.png";
		}else if (w4.isSelected()) {
			img = "light-machine-gun.png";
		}else if (w5.isSelected()) {
			img = "guns-clipart-fortnite-1.png";
		}
		testPlayer.getInventory().addWeapon(new Weapon(img,1+ Integer.parseInt(ammunition.getText())));
		total.setText(testPlayer.getInventory().getLastWeapon().getAmmunition() + "");
		image.setImage(new Image(getClass().getResourceAsStream(img)));
	}

	public void move(KeyEvent event) {
		System.out.println(button.getLayoutY());
		if (event.getCode().equals(KeyCode.UP) && button.getLayoutY() > 0) {
			button.setLayoutY(button.getLayoutY() - 5);
		}else if (event.getCode().equals(KeyCode.DOWN) && button.getLayoutY() < MAX_Y) {
			button.setLayoutY(button.getLayoutY() + 5);
		}else if (event.getCode().equals(KeyCode.LEFT) && button.getLayoutX() > 0) {
			button.setLayoutX(button.getLayoutX() - 5);
			if (!left) {
				((ImageView) button.getGraphic()).setImage(new Image(getClass().getResourceAsStream("/spritLeft.gif")));
				left = true;
			}
		}else if (event.getCode().equals(KeyCode.RIGHT) && button.getLayoutX() < MAX_X) {
			button.setLayoutX(button.getLayoutX() + 5);
			if (left) {
				((ImageView) button.getGraphic()).setImage(new Image(getClass().getResourceAsStream("/spritRigth.gif")));
				left = false;
			}
		}
		//		button.requestFocus();
	}

}
