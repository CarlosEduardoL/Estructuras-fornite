package cUtilTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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
		
		Integer[] arrayTest = new Integer[500];
		
		assertTrue(myQueue.isEmpty());
		
		//tempSize is the size of the queue before any dequeue
		int tempSize = myQueue.getSize();
		
		//Enqueuing all elements
		for (int i = 0; i < 500; i++) {
			
			myQueue.enqueue(i);
			//Testing the front is always the same, no matter what gets int
			assertEquals((int)myQueue.front(), 0);
			//Assigning the same elements to an array to test later FIFO
			arrayTest[i] = i;
			
			assertEquals(myQueue.getSize(), tempSize+i+1);
			
		}
		
		for (int i = 0; i <500; i++) {
			Integer temp = myQueue.dequeue();	
			
			//Testing FIFO
			assertEquals(arrayTest[i] , temp);
			
		}

		
	}
	
	@Test
	void testIsEmpty() {
		
		setupStage1();
		assertTrue(myQueue.isEmpty());
		
		for (int i = 0; i < 1000; i++) {
			myQueue.enqueue(i);
			assertFalse(myQueue.isEmpty());
		}
	}
	
	@Test
	void testDequeue() throws EmptyQueueExeption {
		
		setupStage1();
		
		Integer[] arrayTest = new Integer[500];
		//Enqueuing all elements
		for (int i = 0; i < 500; i++) {
			
			myQueue.enqueue(i);
			//Assigning the same elements to an array to test later FIFO
			arrayTest[i] = i;
		}
		
		//tempSize is the size of the queue before any dequeue
		int tempSize = myQueue.getSize();
		for (int i = 0; i <500; i++) {
			Integer temp = myQueue.dequeue();	
			
			//Testing FIFO
			assertEquals(arrayTest[i] , temp);
			//Testing whether length of the queue decreases when we dequeue an element
			assertEquals(myQueue.getSize() , tempSize-1 - i);
			

		}
	}
	
}
