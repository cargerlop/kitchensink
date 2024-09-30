package com.challenge.kitchensink.service;

import java.util.List;

import com.challenge.kitchensink.model.Member;

public interface IMemberService {

	public List<Member> findAll();
	
	public Member findById(Long id);
	
	public void save(Member member);
	
}
