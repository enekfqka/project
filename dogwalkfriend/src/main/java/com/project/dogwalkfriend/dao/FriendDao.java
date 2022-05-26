package com.project.dogwalkfriend.dao;

import java.util.List;

import com.project.dogwalkfriend.model.Friend;

public interface FriendDao {
	int getTotalMyFd(Friend friend);		// 예약 내역에서 페이징을 위해 지원자가 지원한 글의 개수
	List<Friend> myFdList(Friend friend);	// 예약 내역에서 지원자가 지원한 글 리스트
	
	List<Friend> friendList(Friend friend);
	Friend selectFd(Friend friend);
	int insert(Friend friend);
	int delete(Friend friend);
	int updateAccept(Friend friend);
	int updateRefuse(Friend friend);
	int updateAllRefuse(int WK_no);
	
	Friend selectWk(int FD_no);
	
	List<Friend> fdAllList(Friend friend);	// 관리자 - 친구 내역 목록
	
}
