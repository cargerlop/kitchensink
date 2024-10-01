package com.challenge.kitchensink.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.kitchensink.model.Member;

public interface MemberRepository extends MongoRepository<Member, Long>{
	
	Member findByEmail(String email);

}
