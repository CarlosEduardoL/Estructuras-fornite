package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	
	Ranking ranking;
	
	/**
	 * @throws IOException 
	 * 
	 */
	public Game() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("PlayerData.txt")));
		String player = "";
		String temp;
		while((temp = reader.readLine()) != null) {
			player += temp + " ";
		}
		
		String[] players = player.split(" ");
		
		ranking = new Ranking();
	}
}