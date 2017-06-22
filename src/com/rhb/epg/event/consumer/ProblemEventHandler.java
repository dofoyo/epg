package com.rhb.epg.event.consumer;

import com.jdon.annotation.Component;
import com.jdon.annotation.model.OnEvent;
import com.rhb.epg.domain.Problem;
import com.rhb.epg.repository.ProblemRepository;

@Component
public class ProblemEventHandler {
	
	ProblemRepository repository;
	
	public ProblemEventHandler(ProblemRepository repository){
		super();
		this.repository = repository;
	}
	
	
	@OnEvent("save")
	public void save(Problem problem){
		System.out.println("ProblemEventHandler.save...");
		repository.update(problem);
	}
	
	@OnEvent("occur")
	public void handler(String str){
		System.out.println("I have get a message when the domianevent has occur. the message is '" + str + "'.");
	}

}
