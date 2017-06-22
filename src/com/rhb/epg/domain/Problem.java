package com.rhb.epg.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.jdon.annotation.Model;
import com.jdon.annotation.model.Inject;
import com.rhb.epg.event.publisher.ProblemEvent;
import com.rhb.epg.util.Constant;
import com.rhb.epg.util.LinearEquations;
import com.rhb.epg.util.Tool;

@Model
public class Problem {
	private String id;
	private Set tags;  	// 标签：归一、归总、和差、和倍...
	private int level = 0; 		// 题目难度：0 - basic, 1 - there is one curve， 2 - there are two curve...
	private int errors = 0; 	// 该题错了几次
	private int cases = 0;  	// 该题出现了几次
	private Map<String,String> templates;  // 试题模版
	private String define; 	// 模版中变量的定义
	private String matrix;
	
	@Inject
	public ProblemEvent domainEvent;
	
	public Problem(){
		super();
		this.id = null;
		this.tags = new HashSet();
		this.templates = new HashMap<String, String>();
		this.define = null;
		this.matrix = null;
	}
	
	public void testResult(int cases, int errors){
		System.out.println("Problem.testResult...");
		this.cases = this.cases + cases;
		this.errors = this.errors + errors;
		domainEvent.save(this);
		domainEvent.occur("save",this);
	}

	
	/*
	 * index = -1 表示随机调取模版
	 */
	public Map<String,String> getQuestionAndAnswer(String templateKey){
		Map<String,String> qa = new HashMap();
		String question = templates.get(templateKey);
		
		String matri = matrix;
		if(question != null){
			Map<String,String> defineMap = getDefineMap(define);
			Iterator i = defineMap.keySet().iterator();
			while(i.hasNext()){
				String key = (String)i.next();	
				String val = Tool.eval(defineMap.get(key));
				question = question.replaceAll(key, val);
				if(matri != null){
					matri = matri.replaceAll(key, val);
				}
			}		
		}
		qa.put("Q", "("+id+")" + question);
		//qa.put("A", matrix);
		qa.put("A", getAnswer(matri));
		
		return qa;
	}
	
	private String getAnswer(String matri){
		StringBuffer answer = new StringBuffer();
		String[] ssss = matri.split(";");
		List<double[]> l = new ArrayList();
		for(String sss : ssss){
			String[] ss = sss.split(",");
			double[] d = new double[ss.length];
			int i=0;
			for(String s : ss){
				d[i++] = Double.parseDouble(s);
			}
			l.add(d);
		}
		LinearEquations le = new LinearEquations(l);
		double[] result = le.result();
		for(int i=1; i<result.length; i++){
			answer.append(result[i]);
			answer.append(",");
		}
		return answer.toString();
	}
	
	private Map<String,String> getDefineMap(String define){
		Map<String,String> defineMap = new HashMap();
		if(define!=null && define.length()>0){
			String[] defines = define.split(",");
			for(String s : defines){
				//System.out.println("s=" + s);
				String[] ss = s.split("=");
				String key = ss[0];
				String value = getValue(ss[1]);
				if(value.indexOf("#<") != -1){
					for(String k : defineMap.keySet()){
						value = value.replaceAll(k, defineMap.get(k));
					}				
				}
				//System.out.println("key=" + key);
				//System.out.println("value=" + value);
				defineMap.put(key, value);
			}
		}
		return defineMap;
		
	}
	
	private String getValue(String str){
		String value = null;
		if(str.startsWith("r<")){
			String s = Tool.subString(str,"r<|>");
			Random r = new Random();
			if(Tool.isNum(s)){
				int i = r.nextInt(Integer.parseInt(s));
				value = Integer.toString(i);
			}if("person".equals(s)){
				int i = r.nextInt(Constant.persons.length);
				value = Constant.persons[i];
			}if("thing".equals(s)){
				int i = r.nextInt(Constant.things.length);
				value = Constant.things[i];
			}
		}else{
			value = str;
		}
		return value;
	}


	public Map<String, String> getTemplates() {
		return templates;
	}

	public void setTemplates(Map<String, String> templates) {
		this.templates = templates;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getErrors() {
		return errors;
	}

	public void setErrors(int errors) {
		this.errors = errors;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}


	public String getDefine() {
		return define;
	}

	public void setDefine(String define) {
		this.define = define;
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set getTags() {
		return tags;
	}

	public void setTags(Set tags) {
		this.tags = tags;
	}

	

}
