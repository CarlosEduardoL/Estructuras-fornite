package cUtilTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cUtil.CQueue;
import cUtil.EmptyQueueExeption;
import cUtil.Queue;

/**
 * 
 * @author Santiago Chasqui
 *
 */
class CQueueTest {
	
	Queue<Integer> myQueue;
	@BeforeEach
	void setupStage1() {
		myQueue = new CQueue<>();
		
	}

	@Test
	void testEnqueue() throws EmptyQueueExeption {
		setupStage1();
		Integer tempPrimero;
		
		Queue<Integer> auxiliarQueue = new CQueue<>();
		
		for (int i = 0; i < 500; i++) {
			
			auxiliarQueue.enqueue(i);
			//Testing that no matter what gets into the queue, the first element is the last in get out
			myQueue.enqueue(i);
			tempPrimero = myQueue.dequeue();
			assertTrue(tempPrimero == 0);
			myQueue.enqueue(tempPrimero);
			
			
			
//			arrayTest[i]= myQueue.dequeue();
//			myQueue.enqueue(i);
//			assertTrue(arrayTest[arrayTest.length-1] == i);
		}
		
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
	}

}
