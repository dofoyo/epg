package com.rhb.epg.service;

import java.util.List;
import java.util.Map;

public interface ProblemQueryService {
	public Map<String,String> getQuestionAndAnswer(String id, String templateKey);
	public List<Map<String,String>> getQuestionAndAnswers();
	public List<String> getProblems();
}
