package com.project.dogwalkfriend.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dogwalkfriend.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sst;

	// 로그인
	@Override
	public Member select(String MB_id) {
		return sst.selectOne("memberns.select", MB_id);
	}
	
	// 닉네임 중복 체크
	@Override
	public Member selectNick(String MB_nick) {
		return sst.selectOne("memberns.selectNick", MB_nick);
	}

	// 마이 페이지에서 닉네임 중복 체크
	@Override
	public Member selectMyNick(Member member) {
		return sst.selectOne("memberns.selectMyNick", member);
	}

	// 회원 가입
	@Override
	public int insert(Member member) {
		return sst.insert("memberns.insert", member);
	}

	// 아이디 찾기
	@Override
	public Member selectFindId(Member member) {
		return sst.selectOne("memberns.selectFindId", member);
	}

	// 비밀번호 찾기
	@Override
	public Member selectFindPw(Member member) {
		return sst.selectOne("memberns.selectFindPw", member);
	}

	// 회원 정보 수정
	@Override
	public int update(Member member) {
		return sst.update("memberns.update", member);
	}

	// 비밀번호 변경
	@Override
	public int updatePw(Member member) {
		return sst.update("memberns.updatePw", member);
	}

	// 회원 탈퇴
	@Override
	public int delete(String MB_id) {
		return sst.update("memberns.delete", MB_id);
	}

	// 프로필 상세
	@Override
	public Member selectNo(int MB_no) {
		return sst.selectOne("memberns.selectNo", MB_no);
	}
}
