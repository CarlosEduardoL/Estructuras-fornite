/**
 * 
 */
package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cUtil.CQueue;
import cUtil.EmptyQueueExeption;
import model.Game;
import model.Match;
import model.Player;
import sun.nio.cs.ext.MacArabic;

/**
 * @author Santiago Chasqui
 *
 */
public class GameTest {
	
	private Game game;
	@BeforeEach
	void setupStage1() {
		try {
			game = new Game();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	void testStandardDeviation() {
		setupStage1();
		
		try {
			game.initRanking();
			game.extractPlayersFromRanking();
			Player[] temp = game.getRanking().getRanking();
			
			System.out.println(game.getMatches().get(0).toString());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
