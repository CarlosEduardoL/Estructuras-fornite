package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cUtil.CHashTable;
import cUtil.CList;
import cUtil.Map;
import cUtil.SCHeap;

public class Game {
	
	public final static double PROSKILL = 40;
	public final static double GOODPING = 200;
	
	private Ranking ranking;
	private Map<String, String> developers;
	private SCHeap<Player> heapPros;
	private SCHeap<Player> heapProsWithLag;
	private SCHeap<Player> heapNoobs;
	private SCHeap<Player> heapNoobsWithLag;
	private CList<Match> matches;
	
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
	}
	
	public void initRanking() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("PlayerData.txt")));
		String temp;
		ranking = new Ranking();
		while((temp = reader.readLine()) != null) {
			String[] data = temp.split(" ");
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
	
	public void sortRanking() {
		ranking.sort();
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
	
	public void addPlayer(Player newPlayer) {
		
		if(newPlayer.getPing() <= GOODPING && newPlayer.getSkill()>=PROSKILL) {
			heapPros.add(newPlayer);
		}else if(newPlayer.getPing() > GOODPING && newPlayer.getSkill()>PROSKILL) {
			heapProsWithLag.add(newPlayer);
		}else if(newPlayer.getPing() > GOODPING && newPlayer.getSkill()<PROSKILL) {
			heapNoobs.add(newPlayer);
		}else {
			heapNoobsWithLag.add(newPlayer);
		}
	}
	
	public void breakMatches() {
		Player[] temp = new Player[100];
		for (int i = 1; i < heapPros.size(); i++) {
			if(i%100 == 0) {
				matches.add(new Match(temp));
			}else {
				
				temp[i-1] = heapPros.getElement(i);
			}
		}
		
		for (int i = 1; i < heapProsWithLag.size(); i++) {
			if(i%100 == 0) {
				matches.add(new Match(temp));
			}else {
				
				temp[i-1] = heapProsWithLag.getElement(i);
			}
		}
		
		for (int i = 1; i < heapNoobs.size(); i++) {
			if(i%100 == 0) {
				matches.add(new Match(temp));
			}else {
				
				temp[i-1] = heapNoobs.getElement(i);
			}
		}
		
		for (int i = 1; i < heapNoobsWithLag.size(); i++) {
			if(i%100 == 0) {
				matches.add(new Match(temp));
			}else {
				
				temp[i-1] = heapNoobsWithLag.getElement(i);
			}
		}
	}
	
}