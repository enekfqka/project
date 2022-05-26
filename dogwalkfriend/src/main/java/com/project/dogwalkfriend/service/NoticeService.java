package com.project.dogwalkfriend.service;

import java.util.List;

import com.project.dogwalkfriend.model.Notice;

public interface NoticeService {
	int getNtTotal(Notice notice);			// 공지 사항 개수
	List<Notice> noticeList(Notice notice);	// 공지 사항 리스트
	Notice select(int NT_no);				// 공지 사항 선택
	
	List<Notice> noticeAllList(Notice notice); // 관리자 - 공지 사항 목록

}