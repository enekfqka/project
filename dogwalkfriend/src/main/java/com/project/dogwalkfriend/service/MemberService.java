package com.project.dogwalkfriend.service;

import com.project.dogwalkfriend.model.Member;

public interface MemberService {
	Member select(String MB_id);		// 아이디 중복 체크, 로그인
	Member selectNick(String MB_nick);	// 닉네임 중복 체크
	Member selectMyNick(Member member);	// 마이 페이지에서 닉네임 중복 체크
	int insert(Member member);			// 회원 가입
	Member selectFindId(Member member);	// 아이디 찾기
	Member selectFindPw(Member member);	// 비밀번호 찾기
	int update(Member member);			// 회원 정보 수정
	int updatePw(Member member);		// 비밀번호 변경
	int delete(String mB_id);			// 회원 탈퇴
	Member selectNo(int MB_no);		// 프로필 상세
}
