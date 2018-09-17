package application;
	
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
			
			
			Game g = new Game();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Ranking.fxml"));
			Scene scene = new Scene(root,889,549);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Player[] ps = g.getRanking().getRanking(); 
			TextArea t = (TextArea) root.lookup("#area");
			
			for (int i = 1; i < ps.length; i++) {
				if (ps[i]!=null) {
					t.setText(t.getText() + i + ") " + ps[i].getNickName() + "           Skill:" + ps[i].getSkill() + "\n" );
				}
			}
			
//			BufferedReader reader = new BufferedReader(new FileReader(new File("PlayerData.txt")));
//			String name = "";
//			String temp;
//			while((temp = reader.readLine()) != null) {
//				name += temp + " ";
//			}
//			
//			String[] names = name.split(" ");
//			for (int i = 0; i < names.length; i+=2) {
//				System.out.println(
//						names[i] +" "+ 						//NickName
//						(int)(Math.random() * 100000) +" "+	//kills
//						(int)(Math.random()* 600)+ " "+ 		//ping
//						(int)(Math.random() * 10) +" "+ 	//head shoots
//						(int)(Math.random() * 10) +" " + 	//deads
//						Math.random() +" "+ 				// accuracy
//						Math.random()*120 + 	" "+				// averangeSurvivalTime
//						(int)(Math.random()* 10000)+ " " + 	// played games
//						(int)(Math.random() * 10) +" "+ 	// times in top ten
//						(int)(Math.random() * 10000) );		// time played
//			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
