package com.rhb.epg.service;

import java.util.Map;
import java.util.Set;

import com.jdon.annotation.Service;
import com.jdon.annotation.pointcut.Around;
import com.rhb.epg.domain.Problem;
import com.rhb.epg.repository.ProblemRepository;

@Service("problemCommandService")
public class ProblemCommandServiceImpl implements ProblemCommandService {
	private final ProblemRepository repository;
	
	public ProblemCommandServiceImpl(ProblemRepository repository){
		super();
		this.repository = repository;
	}
	
	@Override
	public void create(String id,int level, Set tags, Map<String,String> templates,
			String define, String matrix) {
		System.out.println("ProblemCommandServiceImpl.create...");
		Problem problem = repository.create(id);
		problem.setLevel(level);
		problem.setTags(tags);
		problem.setTemplates(templates);
		problem.setDefine(define);
		problem.setMatrix(matrix);
		repository.update(problem);
	}

	@Override
	public void delete(String id) {
		System.out.println("ProblemCommandServiceImpl.delete...");
		repository.delete(id);
	}

	@Override
	public Problem getProblem(String id) {
		return (Problem)this.repository.getProblem(id);
	}

	@Override
	public void update(String id, int cases, int errors) {
		Problem problem = repository.getProblem(id);
		if(problem != null)
			problem.testResult(cases, errors);
		//repository.update(problem);
		
	}

}
