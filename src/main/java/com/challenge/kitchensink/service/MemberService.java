package com.challenge.kitchensink.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.kitchensink.model.Member;
import com.challenge.kitchensink.repository.MemberRepository;
import com.challenge.kitchensink.util.SortByNameComparator;

@Service
public class MemberService implements IMemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public com.challenge.kitchensink.model.Member findById(Long id) {
		return memberRepository.findById(id).orElseThrow();
	}

	@Override
	public void register(com.challenge.kitchensink.model.Member member) {
		try {
			validateMember(member);
			memberRepository.save(member);
		}catch(Exception e) {
			System.out.println("Error creating Member: "+e.getMessage());
		}
	}
	
	@Override
	public List<Member> findAllOrderedByName(){
		List<Member> members = memberRepository.findAll();
		Collections.sort(members, new SortByNameComparator());
		return members;
	}
	
	
	/*
	 * Auxiliar Methods
	 * */
	private void validateMember(Member member) throws Exception{
        // Check the uniqueness of the email address
        if (emailAlreadyExists(member.getEmail())) {
            throw new Exception("Unique Email Violation");
        }
	}
	
	private Boolean emailAlreadyExists(String email) {
		Member member = null;
		try {
			member  = memberRepository.findByEmail(email);
		} catch (Exception e) {
			System.out.println("::emailAlreadyExists error: "+e.getMessage());
		}
		return member != null;
	}
}
