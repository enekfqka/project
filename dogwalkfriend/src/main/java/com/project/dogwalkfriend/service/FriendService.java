package com.project.dogwalkfriend.service;

import java.util.List;

import com.project.dogwalkfriend.model.Friend;

public interface FriendService {
	int getTotalMyFd(Friend friend);		// 예약 내역에서 페이징을 위해 지원자가 지원한 글의 개수
	List<Friend> myFdList(Friend friend);	// 예약 내역에서 지원자가 지원한 글 리스트
	
	List<Friend> friendList(Friend friend);
	Friend selectFd(Friend friend);		// 신청 중복 방지
	int insert(Friend friend);			// 매칭 게시글 상세 신청 버튼 클릭
	int delete(Friend friend);			// 매칭 대기 상태인 지원자가 지원 취소 버튼 클릭
	int updateAccept(Friend friend);	// 작성자 수락 버튼
	int updateRefuse(Friend friend);	// 작성자 거절 버튼
	int updateAllRefuse(int WK_no);		// 게시글 매칭 완료 시 기존에 신청된 수락 버튼 거절로 변경
	
	Friend selectWk(int FD_no);
	
	List<Friend> fdAllList(Friend friend); // 관리자 - 친구 내역 목록

}
