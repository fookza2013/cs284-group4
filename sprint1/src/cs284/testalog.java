

package cs284;


	import static org.junit.Assert.*;

	import org.junit.Test;



	public class testalog {

		@Test
		public void test() {
			assertFalse(Usercheck.userPassCheck ("gunnngun", "nitivit"));
		}
		@Test
		public void test2() {
			assertFalse(Usercheck.userPassCheck ("gungun", "nitivsddfdgit"));
		}
		@Test
		public void test3() {
			assertFalse(Usercheck.userPassCheck ("gungfdfdfdun", "nffitivit"));
		}
		@Test
		public void test4() {
			assertFalse(Usercheck.userPassCheck ("", ""));
		}
		@Test
		public void test5() {
			assertFalse(Usercheck.userPassCheck ("gungun", ""));
		}
		@Test
		public void test6() {
			assertFalse(Usercheck.userPassCheck ("", "nitivit"));
		}
		@Test
		public void test7() {
			assertFalse(Usercheck.userPassCheck ("gungun", "t1"));
		}
		@Test
		public void test8() {
			assertFalse(Usercheck.userPassCheck ("t", "nitivit"));
		}
		@Test
		public void test9() {
			assertTrue(Usercheck.userPassCheck ("gungun", "nitivit"));
		}
	}

