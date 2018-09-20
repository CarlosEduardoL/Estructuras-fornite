package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cUtil.CHashTable;
import cUtil.Map;

public class Game {
	
	Ranking ranking;
	Map<String, String> developers;
	
	/**
	 * @throws IOException 
	 * 
	 */
	public Game() throws IOException {
		developers = new CHashTable<String, String>(4);
		developers.set("CARLOS", "CARLOS");
		developers.set("SANTIAGO", "SANTIAGO");
		developers.set("NELSON", "NELSON");
		developers.set("SARA", "SARA");
		
		
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
		
		reader.close();
		
	}
	
	public boolean checkDeveloper(String name,String pass) {
		boolean isDeveloper = false;
		if (developers.get(name) != null) {
			isDeveloper = developers.get(name).equals(pass);
		}
		return isDeveloper;
	}

	public Ranking getRanking() {
		return ranking;
	}
}