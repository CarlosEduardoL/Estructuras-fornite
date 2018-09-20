/**
 * 
 */
package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cUtil.CQueue;
import cUtil.EmptyQueueExeption;
import model.Match;
import model.Player;
import sun.nio.cs.ext.MacArabic;

/**
 * @author Santiago Chasqui
 *
 */
public class GameTest {
	
	private Match match;
	@BeforeEach
	void setupStage1() {
		Player[] temp = new Player[1];
		match = new Match(temp) ;
	}
	

	@Test
	void testStandardDeviation() {
		setupStage1();
		
		int[] pings = {10, 12, 14, 15, 17, 18,18,24};
		double prueba = match.standardDeviation(pings);
		System.out.println(prueba);
		
	}
}
