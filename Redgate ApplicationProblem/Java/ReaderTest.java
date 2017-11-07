package com.redgate.development.tests.readers;

import static org.junit.Assert.*;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ReaderTest {

	
	@Test
	public void normalFunctionality()
	{
		// Assume this list is from 'stream'
		ArrayList<String> list = new ArrayList<String>();
		list.add("i");
		list.add("am");
		list.add("i");
		
		assertEquals("[i=2, am=1]", Reader.print(list).toString());
		
		// Add more words to 'stream'
		list.add("hello");
		list.add("world");
		list.add("hello");
		
		assertEquals("[hello=2, i=2, am=1, world=1]", Reader.print(list).toString());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void nullStringsTest()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add(null);
		list.add(null);
		list.add(null);
		thrown.expect(NullPointerException.class);
		Reader.print(list).toString();
	}
	
	@Test
	public void digitTest()
	{
		// Ensure you can enter chars that are displayed as digits
		ArrayList<String> list = new ArrayList<String>();
		list.add("12");
		list.add("12");
		list.add("hello");
		assertEquals("[12=2, hello=1]", Reader.print(list).toString());
		
	}
	
	@Test
	public void longStringTest()
	{
		// Ensure reader still functions if you add strings with a lot of chars
		ArrayList<String> list = new ArrayList<String>();
		list.add("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		list.add("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		list.add("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		assertEquals("[HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH=3]", Reader.print(list).toString());
	}
	
	@Test
	public void endOfStreamExceptionTest() throws EOFException 
	{
		// Ensures that eventually stream must throw EOF Exception
		SimpleCharacterReader stream = new SimpleCharacterReader();
		while(true){
			char c = Reader.getReader(stream);
			thrown.expect(EOFException.class);
		}
	}
	
	@Test
	public void nullStreamTest() throws EOFException
	{
		// Ensure NullPointerException is thrown if you try use a null stream
		SimpleCharacterReader stream = new SimpleCharacterReader();
		stream = null;
		thrown.expect(NullPointerException.class);
		Reader.count(stream);
	}

}
