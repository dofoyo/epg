package com.rhb.epg.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.jdon.annotation.Service;
import com.rhb.epg.domain.Problem;
import com.rhb.epg.repository.ProblemRepository;
import com.rhb.epg.util.PojoMapper;

@Service("problemQueryService")
public class ProblemQueryServiceImp implements ProblemQueryService {
	private final ProblemRepository repository;

	public ProblemQueryServiceImp(ProblemRepository repository){
		super();
		this.repository = repository;
	}
	
	@Override
	public Map<String, String> getQuestionAndAnswer(String id, String templateKey) {
		Problem problem = (Problem)repository.getProblem(id);
		if(templateKey==null){
			templateKey = getRandomTemplateKey(problem.getTemplates());
		}
		return problem.getQuestionAndAnswer(templateKey);
	}

	@Override
	public List<Map<String,String>> getQuestionAndAnswers() {
		List<Map<String,String>> list = new ArrayList();
		List<Problem> problems = repository.getProblems();
		for(Problem problem : problems){
			String templateKey = getRandomTemplateKey(problem.getTemplates());
			list.add(problem.getQuestionAndAnswer(templateKey));
		}
		return list;
	}
	
	private String getRandomTemplateKey(Map<String,String> templates){
		String key = null;
		Random r = new Random();
		int i = r.nextInt(templates.size());
		Iterator it = templates.keySet().iterator();
		for(int j=0; j<=i && it.hasNext(); j++){
			key = (String)it.next();
		}
		return key;
	}

	@Override
	public List<String> getProblems() {
		List<String> list = new ArrayList();
		List<Problem> problems = repository.getProblems();
		for(Problem problem : problems){
			String s = PojoMapper.toJson(problem, false);
			list.add(s);
		}
		return list;
	}
	
	

}
