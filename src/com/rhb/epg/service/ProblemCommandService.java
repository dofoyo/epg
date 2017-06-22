package com.rhb.epg.service;

import java.util.Map;
import java.util.Set;

import com.rhb.epg.domain.Problem;

public interface ProblemCommandService {
	public void create(String id,int level, Set tags,Map<String,String> templates, String define, String matrix);
	public void update(String id, int cases, int errors);
	public void delete(String id);
	public Problem getProblem(String id);
}
