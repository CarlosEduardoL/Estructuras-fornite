/**
 * 
 */
package utilites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ZeroN
 *
 */
public class PlayerGeneratos {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("nameGenerator"))); 
		String[] names = new String[714];
		String name;
		int i = 0;
		while ((name = reader.readLine()) != null) {
			name = name.trim();
			names[i] = name;
			i++;
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("PlayerData.txt")));
		for (int j = 0; j < 10000; j++) {
			
			writer.write(names[(int) (Math.random() * names.length)] +"_"+names[(int) (Math.random() * names.length)] + " "+ 						//NickName
							(int)(Math.random() * 10000) +" "+	//kills
							(int)(Math.random()* 600)+ " "+ 		//ping
							(int)(Math.random() * 10) +" "+ 	//head shoots
							(int)(Math.random() * 5000) +" " + 	//deads
							Math.random() +" "+ 				// accuracy
							Math.random()*120 + 	" "+				// averangeSurvivalTime
							(int)(Math.random()* 10000)+ " " + 	// played games
							(int)(Math.random() * 10) +" "+ 	// times in top ten
							(int)(Math.random() * 10000));		// time played
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}

}
