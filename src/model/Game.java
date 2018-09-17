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
			player += temp + "-";
		}
		
		ranking = new Ranking();
		String[] players = player.split("-");
		
		for (int i = 0; i < players.length; i++) {
			String[] data = players[i].split(" ");
			Player p = new Player(data[0]);
			p.setKills(Integer.parseInt(data[1]));
			p.setPing(Integer.parseInt(data[2]));
			p.setHeadShoots(Integer.parseInt(data[3]));
			p.setDeads(Integer.parseInt(data[4]));
			p.setAccuracy(Double.parseDouble(data[5]));
			p.setAverageSurvivalTime(Double.parseDouble(data[6]));
			p.setPlayedGames(Integer.parseInt(data[7]));
			p.setTimesInTopTen(Integer.parseInt(data[8]));
			p.setTimePlayed(Integer.parseInt(data[9]));
			ranking.addPlayer(p);
		}
		
		
	}

	public Ranking getRanking() {
		return ranking;
	}
}