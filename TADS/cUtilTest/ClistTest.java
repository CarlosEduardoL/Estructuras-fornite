package cUtilTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cUtil.CList;
import cUtil.List;

class ClistTest {
	
	CList<Integer> list;

	@BeforeEach
	void setUp1() throws Exception {
		list = new CList<Integer>();
	}
	
	@BeforeEach
	void setUp2() throws Exception {
		Integer[] arr = {5,4,6};
		list = new CList<Integer>(arr);
	}

	@Test
	void constructorTest1() {
		try {
			setUp1();
			if (!list.isEmpty()) {
				fail("it does not work");
			}
		} catch (Exception e) {
			fail("it does not work");
		}
		
	}
	
	@Test
	void constructorTest2() {
		try {
			setUp2();
			if (list.isEmpty() && list.size() != 3) {
				fail("it does not work");
			}
		} catch (Exception e) {
			fail("it does not work");
		}	
	}
	
	@Test
	void constructorTest3() {
		try {
			setUp2();
			if (!list.equals(new CList(list))) {
				fail("it does not work");
			}
		} catch (Exception e) {
			fail("it does not work");
		}
	}
	
	@Test
	void removetest() {
		try {
			setUp2();
			list.remove(1);
		} catch (Exception e) {
			fail("it does not work");
		}
	}

}
