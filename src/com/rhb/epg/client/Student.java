package com.rhb.epg.client;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jdon.controller.AppUtil;
import com.rhb.epg.service.ProblemQueryService;

public class Student {
	static final AppUtil au = new AppUtil();
	static final ProblemQueryService pq = (ProblemQueryService)au.getComponentInstance("problemQueryService");

	@Test
	public void study(){
		List<Map<String,String>> questionAndAnswers = pq.getQuestionAndAnswers();
		for(Map<String, String> qa : questionAndAnswers){
			System.out.println("Q: " + qa.get("Q"));
			System.out.println("A: " + qa.get("A"));
			System.out.println("---------------------------");
		}
	}
	
}

