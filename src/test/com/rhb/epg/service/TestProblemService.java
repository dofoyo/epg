package test.com.rhb.epg.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.jdon.controller.AppUtil;
import com.rhb.epg.domain.Problem;
import com.rhb.epg.service.ProblemCommandService;
import com.rhb.epg.service.ProblemQueryService;

public class TestProblemService {
	static final AppUtil au = new AppUtil();
	static final ProblemCommandService pc = (ProblemCommandService)au.getComponentInstance("problemCommandService");
	static final ProblemQueryService pq = (ProblemQueryService)au.getComponentInstance("problemQueryService");

	@Test
	public void testCreateFindDelete(){
		create();
		//Problem problem = ps.getProblem("001");
		//problem.testResult(2, 1);
		
		//delete();
		
		//pc.update("001", 2, 1);
		find();
		
	}

	private void find(){
		try {
			Thread.sleep(3000); //目的是等待event的执行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list = pq.getProblems();
		for(String s : list){
			System.out.println(s);
		}
	}
	
	private void delete(){
		pc.delete("001");
	}
	
	private void create(){
		String id = "001";
		String tag = "qqq";
		Set tags = new HashSet();
		tags.add(tag);
		String template = "eeeeeeeeeeeeeeeeee";
		Map<String,String> templates = new HashMap();
		templates.put("002",template);
		String define = "";
		String matrix = "1,0";
		pc.create(id, 0,tags, templates, define, matrix);
	}
	
	
}
