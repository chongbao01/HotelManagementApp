package assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUser {
	User user = new User("Chow","VIP",false); 

	@Test
	public void testGetName() {
		String ER = "Chow";
		String AR = user.getName();
		assertEquals(ER,AR);
	}

	@Test
	public void testSetName() {
		user.setName("Tan");
		assertEquals("Tan",user.getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetNameFail() {
		user.setName("");
	}
	
	@Test
	public void testGetRewardStatus() {
		Boolean AR = user.getRewardStatus();
		Boolean ER = false;
		assertEquals(AR,ER);
	}

	@Test
	public void testSetRewardStatus() {
		user.setRewardStatus(true);
		assertTrue(user.getRewardStatus());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetRewardStatusFail() {
		user.setRewardStatus(null);
	}

	@Test
	public void testGetMemberType() {
		String AR = user.getMemberType();
		String ER = "VIP";
		assertEquals(AR,ER);
	}
	
	@Test
	public void testSetMemberType() {
		user.setMemberType("NORMAL");
		assertEquals(user.getMemberType(),"NORMAL");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetMemberTypeFail() {
		user.setMemberType("USER");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(user.getName(),"Chow");
		assertEquals(user.getMemberType(),"VIP");
		assertEquals(user.getRewardStatus(),false);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorFail() {
		user = new User("","ABC",null);
	}
	
}
