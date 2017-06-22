package com.rhb.epg.repository;

import java.util.List;

import com.rhb.epg.domain.Problem;

public interface ProblemRepository {
	public abstract Problem create(String id);
	public abstract void update(Problem problem);
	public abstract void delete(String id);
	public abstract Problem getProblem(String id);
	public abstract List<Problem> getProblems();
}
