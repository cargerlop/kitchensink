package com.challenge.kitchensink.util;

import java.util.Comparator;

import com.challenge.kitchensink.model.Member;

public class SortByNameComparator implements Comparator<Member>{

	@Override
	public int compare(Member member, Member anotherMember) {
		// sort all member by name
		if(member.getName() == null)
			return -1;
		else if(member.getName() == null)
			return 1;
		return member.getName().compareToIgnoreCase (anotherMember.getName());
			
	}

}
