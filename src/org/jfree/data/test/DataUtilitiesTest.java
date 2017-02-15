package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {

	private Mockery mockingContext;
	private Values2D values;
	private double maxValDouble = Double.MAX_VALUE;
	private double minValDouble = Double.MIN_VALUE;

	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount(); 
				will(returnValue(8));      

				one(values).getColumnCount(); 
				will(returnValue(8));     
				
				/**********************************/
				/* *** UNUSED ROWS & COLUMNS *** */
				/*********************************/
				
				//These values should remain as Zero
				one(values).getValue(0, 1);     
				will(returnValue(0));     
				one(values).getValue(1, 1);  
				will(returnValue(0));
				
				
				/***********************************************/
				/* *** COLUMNS FOR COLUMN TESTING (GURVIR) *** */
				/***********************************************/

				// Zero Test (Columns)
				one(values).getValue(0, 2);
				will(returnValue(0));
				one(values).getValue(1, 2);
				will(returnValue(0));
				one(values).getValue(2, 2);     
				will(returnValue(0));     
				one(values).getValue(3, 2);  
				will(returnValue(0)); 
				one(values).getValue(4, 2);     
				will(returnValue(0));     
				one(values).getValue(5, 2);  
				will(returnValue(0)); 
				one(values).getValue(6, 2);     
				will(returnValue(0));     
				one(values).getValue(7, 2);  
				will(returnValue(0)); 
				
				// Max Values Tests (Columns)
				one(values).getValue(0, 3);
				will(returnValue(maxValDouble));
				one(values).getValue(1, 3);
				will(returnValue(0));
				one(values).getValue(2, 3);     
				will(returnValue(0));     
				one(values).getValue(3, 3);  
				will(returnValue(0)); 
				one(values).getValue(4, 3);     
				will(returnValue(0));     
				one(values).getValue(5, 3);  
				will(returnValue(0)); 
				one(values).getValue(6, 3);     
				will(returnValue(0));     
				one(values).getValue(7, 3);  
				will(returnValue(0)); 
				
				one(values).getValue(0, 4);
				will(returnValue(Math.floor(maxValDouble/2)));
				one(values).getValue(1, 4);
				will(returnValue(Math.floor(maxValDouble/2)));
				one(values).getValue(2, 4);     
				will(returnValue(0));     
				one(values).getValue(3, 4);  
				will(returnValue(0)); 
				one(values).getValue(4, 4);     
				will(returnValue(0));     
				one(values).getValue(5, 4);  
				will(returnValue(0)); 
				one(values).getValue(6, 4);     
				will(returnValue(0));     
				one(values).getValue(7, 4);  
				will(returnValue(0)); 
				
				// Min Values Tests (Columns)
				one(values).getValue(0, 5);
				will(returnValue(minValDouble));
				one(values).getValue(1, 5);
				will(returnValue(0));
				one(values).getValue(2, 5);     
				will(returnValue(0));     
				one(values).getValue(3, 5);  
				will(returnValue(0)); 
				one(values).getValue(4, 5);     
				will(returnValue(0));     
				one(values).getValue(5, 5);  
				will(returnValue(0)); 
				one(values).getValue(6, 5);     
				will(returnValue(0));     
				one(values).getValue(7, 5);  
				will(returnValue(0)); 
				
				one(values).getValue(0, 6);
				will(returnValue(Math.ceil(minValDouble/2)));
				one(values).getValue(1, 6);
				will(returnValue(Math.ceil(minValDouble/2)));
				one(values).getValue(2, 6);     
				will(returnValue(0));     
				one(values).getValue(3, 6);  
				will(returnValue(0)); 
				one(values).getValue(4, 6);     
				will(returnValue(0));     
				one(values).getValue(5, 6);  
				will(returnValue(0)); 
				one(values).getValue(6, 6);     
				will(returnValue(0));     
				one(values).getValue(7, 6);  
				will(returnValue(0)); 
				
				one(values).getValue(0, 7);
				will(returnValue(-1));
				one(values).getValue(1, 7);
				will(returnValue(1));
				one(values).getValue(2, 7);     
				will(returnValue(2.5));     
				one(values).getValue(3, 7);  
				will(returnValue(7.0)); 
				one(values).getValue(4, 7);     
				will(returnValue(0));     
				one(values).getValue(5, 7);  
				will(returnValue(0.5)); 
				one(values).getValue(6, 7);     
				will(returnValue(0));     
				one(values).getValue(7, 7);  
				will(returnValue(0)); 
				
				
				
				/*****************************************/
				/* *** ROWS FOR ROW TESTING (ANGELA) *** */
				/*****************************************/
				
				one(values).getValue(2, 0); 
				will(returnValue(4.2));     
				one(values).getValue(2, 1); 
				will(returnValue(7.8));    
				
				one(values).getValue(3, 0);
				will(returnValue(0));
				one(values).getValue(3, 1);
				will(returnValue(0));
				
				one(values).getValue(4, 0);     
				will(returnValue(maxValDouble)); 
				one(values).getValue(4, 1);     
				will(returnValue(0)); 
				
				one(values).getValue(5, 0);     
				will(returnValue(maxValDouble/2)); 
				one(values).getValue(5, 1);     
				will(returnValue(maxValDouble/2)); 
				
				one(values).getValue(6, 0);     
				will(returnValue(minValDouble)); 
				one(values).getValue(6, 1);     
				will(returnValue(0)); 
				
				one(values).getValue(7, 0);     
				will(returnValue(minValDouble/2)); 
				one(values).getValue(7, 1);     
				will(returnValue(minValDouble/2)); 
				
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		mockingContext = null;
		values = null;
	}

	/*
	 * CALCULATECOLUMNTOTAL()
	 */
	
	@Test
	public void calculateColumnTotalNominalTest() {
		double result = DataUtilities.calculateColumnTotal(values, 7);
		assertEquals(result, 10.0, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalFalseNominalTest() {
		try {
			DataUtilities.calculateColumnTotal(values, 15);
			fail();
		}
		catch(Error e){
			assertTrue(true);
		}
	}
	
	@Test
	public void calculateColumnTotalZeroTest() {
		double result = DataUtilities.calculateColumnTotal(values, 2);
		assertEquals(result, 0, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalMaximumTest1() {		
		double result = DataUtilities.calculateColumnTotal(values, 3);
		assertEquals(result, maxValDouble, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalMaximumTest2() {
		double result = DataUtilities.calculateColumnTotal(values, 4);
		assertEquals(result, maxValDouble, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalMinimumTest1() {		
		double result = DataUtilities.calculateColumnTotal(values, 5);
		assertEquals(result, minValDouble, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalMinimumTest2() {
		double result = DataUtilities.calculateColumnTotal(values, 6);
		assertEquals(result, minValDouble, .000000001d);
	}
	
	
	
	/*
	 * CALCULATEROWTOTAL()
	 * calculateRowTotal(Values2D data, int row) - Angela
	 */
	
	@Test
	public void calculateRowTotalNominalTest() {
		double result = DataUtilities.calculateRowTotal(values, 2);
		assertEquals(12.0, result, .000000001d);
	}
	
	
	@Test
	public void calculateRowTotalFalseNominalTest() {
		try {
			DataUtilities.calculateRowTotal(values, 0 /*Placeholder - What do I put here?*/);
			fail();
		}
		catch(Error e){
			assertTrue(true);
		}
	}
	
	@Test
	public void calculateRowTotalZeroTest() {
		double result = DataUtilities.calculateRowTotal(values, 3);
		assertEquals(0, result, .000000001d);
	}
	
	
	@Test
	public void calculateRowTotalMaximumTest1() {		
		double result = DataUtilities.calculateRowTotal(values, 4);
		assertEquals(maxValDouble, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalMaximumTest2() {
		double result = DataUtilities.calculateRowTotal(values, 5);
		assertEquals(maxValDouble, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalMinimumTest1() {		
		double result = DataUtilities.calculateRowTotal(values, 6);
		assertEquals(minValDouble, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalMinimumTest2() {		
		double result = DataUtilities.calculateRowTotal(values, 7);
		assertEquals(minValDouble, result, .000000001d);
	}
	
	/*
	 * CREATENUMBERARRAY()
	 */
	
	@Test
	public void createNumberArrayNominalTest() {
		double[] doubleArray = {0, 1, 2, 3, 4};
		Number[] numArray = DataUtilities.createNumberArray(doubleArray);
		
		assertEquals(doubleArray.length, numArray.length);
		assertEquals(doubleArray[0], numArray[0]);
		assertEquals(doubleArray[1], numArray[1]);
		assertEquals(doubleArray[2], numArray[2]);
		assertEquals(doubleArray[3], numArray[3]);
		assertEquals(doubleArray[4], numArray[4]);
	}
	
	@Test
	public void createNumberArrayFalseNominalTest() {
		double[] doubleArray = {0, 1, 2, 3, 4};
		Number[] numArray = DataUtilities.createNumberArray(doubleArray);
		
		Number[] numFalseArray = {4, 3, 2, 1, 0};
		
		assertEquals(false, numFalseArray == numArray);
		
	}
	
	@Test
	public void createNumberArrayZeroTest() {
		double[] doubleArray = {0.0, 0.0, 0.0, 0.0, 0.0};
		Number[] numArray = DataUtilities.createNumberArray(doubleArray);
		
		for (int i = 0; i < doubleArray.length; i++)
			assertEquals((double)0.0, numArray[i]);
	}
	
	@Test
	public void createNumberArrayMaximumTest() {
		double[] doubleArray = {0.0, maxValDouble/2, maxValDouble, maxValDouble};
		Number[] numArray = DataUtilities.createNumberArray(doubleArray);
		
		assertEquals(doubleArray[0], numArray[0]);
		assertEquals(doubleArray[1], numArray[1]);
		assertEquals(doubleArray[2], numArray[2]);
		assertEquals(doubleArray[3], numArray[3]);
	}
	
	@Test
	public void createNumberArrayMinimumTest() {
		double[] doubleArray = {0.0, -1.0, minValDouble/2, minValDouble, minValDouble};
		Number[] numArray = DataUtilities.createNumberArray(doubleArray);
		
		assertEquals(doubleArray[0], numArray[0]);
		assertEquals(doubleArray[1], numArray[1]);
		assertEquals(doubleArray[2], numArray[2]);
		assertEquals(doubleArray[3], numArray[3]);
		assertEquals(doubleArray[4], numArray[4]);
	}
}
