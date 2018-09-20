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
import sun.nio.cs.ext.MacArabic;

/**
 * @author Santiago Chasqui
 *
 */
public class GameTest {
	
	private Match match;
	@BeforeEach
	void setupStage1() {
		match = new Match();
	}
	

	@Test
	void testStandardDeviation() {
		setupStage1();
		
		int[] pings = {10, 32, 24, 26, 40, 30};
		double prueba = match.standardDeviation(pings);
		System.out.println(prueba);
		
	}
}
