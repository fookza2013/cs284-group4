package cs284;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRegister {

	@Test
	public void test() {
		assertFalse(cs284.Register.userPassCheck ("gunnngun", "nitivit","cs1"));
	}
	@Test
	public void test2() {
		assertFalse(cs284.Register.userPassCheck ("gungun", "nitivsddfdgit","cs1"));
	}
	@Test
	public void test3() {
		assertFalse(cs284.Register.userPassCheck ("", "",""));
	}
	@Test
	public void test4() {
		assertFalse(cs284.Register.userPassCheck ("", "","cs1"));
	}
	@Test
	public void test5() {
		assertFalse(cs284.Register.userPassCheck ("", "nitivit",""));
	}
	@Test
	public void test6() {
		assertFalse(cs284.Register.userPassCheck ("gungun", "",""));
	}
	@Test
	public void test7() {
		assertFalse(cs284.Register.userPassCheck ("", "t1","c1"));
	}
	@Test
	public void test8() {
		assertFalse(cs284.Register.userPassCheck ("t", "","c1"));
	}
	@Test
	public void test9() {
		assertFalse(cs284.Register.userPassCheck ("gungun", "nitivit",""));
	}
	public void test10() {
		assertFalse(cs284.Register.userPassCheck ("gungun", "","c1"));
	}
}

