package com.challenge.kitchensink.service;

import java.util.List;

import com.challenge.kitchensink.model.Member;

public interface IMemberService {
	
	public Member findById(Long id);
	
	public void register(Member member);
	
	public List<Member> findAllOrderedByName();
	
}
