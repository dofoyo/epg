package test.com.rhb.epg.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SimpleTest {

	@Test
	public void test(){
		
		for(int i=0; i<30; i++){
			System.out.println(doit());
		
		}
	}
	
	
	private String doit(){
		List<Integer> list = new ArrayList<Integer>();
		boolean flag = true;
		int[] a = {0,0};
		int[] b = {0,0};
		while(flag){
			a[0] = (int) (Math.random()*100);
			a[1] = (int) (Math.random()*100);
			Arrays.sort(a);
			b[0] = a[0]%10;
			b[1] = a[1]%10;
			
			if(b[1]!=0 && b[0]+b[1]>10 && b[0] > b[1]){
				flag = false;
			}
		}
		
		list.add(a[0]);
		list.add(a[1]);
	
		String jj = Math.random()>0.5 ? "＋" : "－";
		
		if(jj.equals("+")){
			Collections.shuffle(list);
		}
		
		return list.get(1) + jj + list.get(0);
		
	}
	
}
