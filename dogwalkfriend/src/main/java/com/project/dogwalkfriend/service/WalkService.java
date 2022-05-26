package com.project.dogwalkfriend.service;

import java.util.List;

import com.project.dogwalkfriend.model.Walk;

public interface WalkService {
	int insert(Walk walk);			// 게시글 작성
	List<Walk> wkList(Walk walk);	// 리스트
	int getTotal(Walk walk);
	int getMaxNum();
	Walk select(int WK_no);			// 상세
	int update(Walk walk);			// 게시글 수정
	int delete(int WK_no);			// 게시글 삭제
	int updatePersonNow(int WK_no);	// 매칭 완료된 인원 수 + 1
	
	int getTotalMyFd(Walk walk);		// 예약 내역에서 페이징을 위해 작성자가 올린 글의 개수 
	List<Walk> myWalkList(Walk walk);	// 예약 내역에서 작성자가 올린 글 리스트
	
	List<Walk> wkAllList(Walk walk); // 관리자 - 친구 구함 목록

}
