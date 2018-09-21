/**
 * 
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public class ValentineController implements Initializable {

	@FXML
	private Node pane;

	@FXML
	private Button button;

	@FXML
	private ToggleGroup type;



	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		button.setFocusTraversable(true);
		button.requestFocus();
		System.out.println(button.isFocused() + " " + button.isFocusTraversable());
	}

	public void move(KeyEvent event) {
		System.out.println(event.getCode());
		if (event.getCode().equals(KeyCode.UP)) {
			button.setLayoutY(button.getLayoutY() - 5);
		}else if (event.getCode().equals(KeyCode.DOWN)) {
			button.setLayoutY(button.getLayoutY() + 5);
		}else if (event.getCode().equals(KeyCode.LEFT)) {
			button.setLayoutX(button.getLayoutX() - 5);
			((ImageView) button.getGraphic()).setImage(new Image(getClass().getResourceAsStream("/spritLeft.gif")));
		}else if (event.getCode().equals(KeyCode.RIGHT)) {
			button.setLayoutX(button.getLayoutX() + 5);
			((ImageView) button.getGraphic()).setImage(new Image(getClass().getResourceAsStream("/spritRigth.gif")));
		}
		//		button.requestFocus();
	}

}
