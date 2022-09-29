package com.niv.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;;

@TestMethodOrder(OrderAnnotation.class)
public class TestEmployee {

	//test methods
	@Test
	@Order(1)
	@Tag("prod")
	public void testSave() {
		System.out.println("HELLO");
	}
	
	@Test
	@Order(3)
	@Tag("dev")
	public void testDelete() {
		System.out.println("HELLO-DELETE");
	}
	
	@Test
	@Order(2)
	@Tag("dev")
	public void testUpdate() {
		System.out.println("HELLO-UPDATE");
	}
}
