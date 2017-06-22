package test.com.rhb.epg.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.rhb.epg.util.LinearEquations;

public class LinearEquationsTest {

	//@Test
	public void test1(){
		double[] d1 = {1,20};
		List<double[]> list= new ArrayList();
		list.add(d1);
		LinearEquations  le = new LinearEquations(list);		
	}
	
	@Test
	public void test2(){
		double[] d1 = {1,1,294};
		double[] d2 = {1,-5,0};
		List<double[]> list= new ArrayList();
		list.add(d1);
		list.add(d2);
		LinearEquations  le = new LinearEquations(list);		
	}
	
	
}
