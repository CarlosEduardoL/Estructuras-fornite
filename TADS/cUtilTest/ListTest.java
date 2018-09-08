package cUtilTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cUtil.CList;
import cUtil.List;
import cUtil.SuperList;

class ListTest {

	List<Integer> list;

	@BeforeEach
	void setUp1() {
		list = new SuperList<Integer>();
	}

	@BeforeEach
	void setUp2(){
		Integer[] arr = {5,4,6};
		list = new SuperList<Integer>(arr);
	}

	@Test
	void constructorTest1() {
		setUp1();
		if (!list.isEmpty()) {
			fail("it does not work");
		}

	}

	@Test
	void constructorTest2() {
		setUp2();
		if (list.isEmpty() && list.size() != 3) {
			fail("it does not work");
		}
	}

	@Test
	void constructorTest3() {
		setUp2();
		if (!list.equals(new CList<Integer>(list))) {
			fail("it does not work");
		}
	}

	@Test
	void removetest() {
		try {
			setUp2();
			list.remove(1);
			Integer[] arr = {5,6};
			for (int i = 0; i < arr.length; i++) {
				if (!arr[i].equals(list.get(i))) {
					fail("it doesn't work");
				}
			}
		} catch (Exception e) {
			fail("it doesn't work");
		}
	}

	@Test
	void addTest() {
		setUp1();
		Integer[] arr = new Integer[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10000);
			list.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals(list.get(i))) {
				fail("it doesn't work");
			}
		}
	}

}
