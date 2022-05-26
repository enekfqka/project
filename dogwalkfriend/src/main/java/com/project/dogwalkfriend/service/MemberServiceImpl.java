package com.project.dogwalkfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dogwalkfriend.dao.MemberDao;
import com.project.dogwalkfriend.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	// 아이디 중복 체크, 로그인
	@Override
	public Member select(String MB_id) {
		return md.select(MB_id);
	}

	// 닉네임 중복 체크
	@Override
	public Member selectNick(String MB_nick) {
		return md.selectNick(MB_nick);
	}

	// 마이 페이지에서 닉네임 중복 체크
	@Override
	public Member selectMyNick(Member member) {
		return md.selectMyNick(member);
	}

	// 회원 가입
	@Override
	public int insert(Member member) {
		return md.insert(member);
	}

	// 아이디 찾기
	@Override
	public Member selectFindId(Member member) {
		return md.selectFindId(member);
	}

	// 비밀번호 찾기
	@Override
	public Member selectFindPw(Member member) {
		return md.selectFindPw(member);
	}

	// 회원 정보 수정
	@Override
	public int update(Member member) {
		return md.update(member);
	}

	// 비밀번호 변경
	@Override
	public int updatePw(Member member) {
		return md.updatePw(member);
	}

	// 회원 탈퇴
	@Override
	public int delete(String MB_id) {
		return md.delete(MB_id);
	}

	// 프로필 상세
	@Override
	public Member selectNo(int MB_no) {
		return md.selectNo(MB_no);
	}
}
