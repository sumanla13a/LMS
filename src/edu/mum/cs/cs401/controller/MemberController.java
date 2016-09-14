package edu.mum.cs.cs401.controller;

import java.util.Collection;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.Member;

public class MemberController {
	private static MemberController instance = new MemberController();
	
	private DataAccess<String, Member> dataAccess = new DataAccessImpl<String, Member>();
	
	private MemberController() {}
	
	public static MemberController getInstance() {return instance;}
	
	public Member addNewMember(Member member) {
		return dataAccess.add(member.getId(), member);
	}
	
	public Member getMemberById(String id) {
		return dataAccess.get(id);
	}
	
	public Collection<Member> getAll() {
		return dataAccess.get();
	}
}
