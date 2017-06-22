package com.rhb.epg.event.publisher;

import com.jdon.annotation.Introduce;
import com.jdon.annotation.model.Send;
import com.jdon.domain.message.DomainMessage;
import com.rhb.epg.domain.Problem;

@Introduce("message")
public class ProblemEvent {
	@Send("save")
	public DomainMessage save(Problem problem){
		System.out.println("ProblemEvent.save...");
		return new DomainMessage(problem);
	}
	
	@Send("occur")
	public DomainMessage occur(String send,Object arg){
		
		return new DomainMessage(send);
	}
}
