package com.project.dogwalkfriend.dao;

import java.util.List;

import com.project.dogwalkfriend.model.Notice;

public interface NoticeDao {
	int getNtTotal(Notice notice);
	List<Notice> noticeList(Notice notice);
	Notice select(int num);
	
	List<Notice> noticeAllList(Notice notice);	// 관리자 - 공지 사항 목록

}
