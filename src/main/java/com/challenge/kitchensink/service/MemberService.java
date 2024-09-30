package com.challenge.kitchensink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.kitchensink.model.Member;
import com.challenge.kitchensink.repository.MemberRepository;

@Service
public class MemberService implements IMemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<com.challenge.kitchensink.model.Member> findAll() {
		return (List<Member>) memberRepository.findAll();
	}

	@Override
	public com.challenge.kitchensink.model.Member findById(Long id) {
		return memberRepository.findById(id).orElseThrow();
	}

	@Override
	public void save(com.challenge.kitchensink.model.Member member) {
		validateMember(member);
		memberRepository.save(member);
	}

	private void validateMember(Member member) {
		//TODO apply member validations
	}
}
