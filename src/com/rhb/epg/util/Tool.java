package com.rhb.epg.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Tool {
	public static String eval(String script){
		Object obj = null;
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
		
		try {
			obj = jse.eval(script);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			obj = script;
		}
		return obj.toString();
	}

	
	public static boolean isNum(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	}

	public static String subString(String str, String regexp){
		List<String> list = new ArrayList();

		if(str == null || regexp==null || "".equals(regexp.trim())){
			return null;
		}
		String findRegexp = regexp.replace("|", ".*?");
		boolean replace = regexp.indexOf("|")==-1 ? false : true;
		//System.out.println("findRegexp=" + findRegexp);
		Pattern pt = Pattern.compile(findRegexp);
		Matcher mt = pt.matcher(str);
		while (mt.find()){
			if(replace){
				list.add(mt.group().replaceAll(regexp, ""));				
			}else{
				list.add(mt.group());
			}
		}
		
		if(list!=null && list.size()>0){
			for(String s : list){
				//System.out.println("s=" + s);
			}
				
			return list.get(0);
		}else{
			return null;
		}
	}


}
