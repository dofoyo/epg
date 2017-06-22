package test.com.rhb.epg.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import com.rhb.epg.domain.Problem;

public class ProblemTest {
	@Test
	public void test(){
		Problem p = new Problem();
		Map<String,String> templates = new HashMap();
		templates.put("001", "#<name1>和#<name2>合计有#<b>#<thing1>，#<name1>是#<name2>的#<a>倍，他们各有多少#<thing1>？");
		p.setTemplates(templates);
		p.setDefine("#<name1>=r<person>,#<name2>=r<person>,#<thing1>=r<thing>,#<a>=r<10>,#<c>=r<100>,#<b>=(#<a>+1)*#<c>");
		p.setMatrix("1,1,#<b>;1,-#<a>,0");
		
		Map<String, String> qa = p.getQuestionAndAnswer("001");
		
		System.out.println("Q: " + qa.get("Q"));
		System.out.println("A: " + qa.get("A"));
		/*
		for(double d : answer){
			System.out.println(d);
		}
		*/
	}
	
	//@Test
	public void test2(){
		String s = "小明和小王合计有20本书，小明是小王的#<a>倍，他们各有多少本书？";
		String ss = s.replaceAll("#<a>", "10");
		System.out.println(ss);
	}
	
	//@Test
	public void test3(){
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
		String s = "2";
		try {
			System.out.println(jse.eval(s));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void test4(){
		String s = "{1,2,3}";
		System.out.println(s.substring(1, s.length()-1));
	}
	
	
}
