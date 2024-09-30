package com.challenge.kitchensink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.kitchensink.model.Member;
import com.challenge.kitchensink.service.IMemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private IMemberService memberService;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerMember(@RequestBody Member member) {
		memberService.save(member);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllMember(){
		return ResponseEntity.ok(memberService.findAll());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(memberService.findById(id));
	}
	
}
