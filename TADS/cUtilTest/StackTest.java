/**
 * 
 */
package cUtilTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cUtil.CStack;
import cUtil.Stack;
import cUtil.StackException;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
class StackTest {
	
	Stack<Integer> stack;

	@BeforeEach
	void setUp() {
		stack = new CStack<Integer>();
	}

	@Test
	void PushPoptest() {
		setUp();
		Integer[] arr = new Integer[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10000);
			stack.push(arr[i]);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			try {
				if (!arr[i].equals(stack.pop())) {
					fail("it doesn't work");
				}
			} catch (StackException e) {
				fail("it doesn't work");
			}
		}
	}
	
	@Test
	void isEmptyTest() {
		setUp();
		assertTrue(stack.isEmpty());
		stack.push(5);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void exceptionTest() {
		setUp();
		try {
			stack.pop();
			fail("it doesn't work");
		} catch (StackException e) {
		}
		
		try {
			stack.top();
			fail("it doesn't work");
		} catch (StackException e) {
		}
	}

}
