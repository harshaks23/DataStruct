

import static org.junit.Assert.*;

import org.junit.Test;

public class Verify {

	@Test
	public void test() {
		
		
		System.out.println("test cses for checking  fairness" );
		FairPQ<Student> verify1 = new FairPQ<Student>();FairPQ<Student> verify2 = new FairPQ<Student> (11, new ByName());
			verify1.add(new Student("harsha 6.0"));
		verify1.add(new Student("eshwar 5.2"));
		verify1.add(new Student("shobha 5.4"));
		verify1.add(new Student("shiva 4.6"));
		verify1.add(new Student("kshea 8.2"));
		
		
		assertEquals("shiva  4.6", verify1.remove().toString());
		assertEquals("eshwar  5.2", verify1.remove().toString());
		assertEquals("shobha  5.4", verify1.remove().toString());
		assertEquals("harsha  6.0", verify1.remove().toString());
		assertEquals("kshea  8.2", verify1.remove().toString());
			
		

		
		
	
	}

	@Test 
	public void test2()
	{FairPQ<Student> verify2 = new FairPQ<Student> (11, new ByName());
	

		verify2.add(new Student("e 4.0"));
		verify2.add(new Student("d 3.9"));
		verify2.add(new Student("c 3.8"));
		verify2.add(new Student("b 3.7"));
		verify2.add(new Student("a 3.6"));

		assertEquals("a  3.6", verify2.remove().toString());
		assertEquals("b  3.7", verify2.remove().toString());
				assertEquals("c  3.8", verify2.remove().toString());
		assertEquals("d  3.9", verify2.remove().toString());
		assertEquals("e  4.0", verify2.remove().toString());
		
	}
}
