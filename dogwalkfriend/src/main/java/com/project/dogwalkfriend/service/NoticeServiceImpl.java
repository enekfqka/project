package com.project.dogwalkfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dogwalkfriend.dao.NoticeDao;
import com.project.dogwalkfriend.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao nd;
	
	@Override
	public int getNtTotal(Notice notice) {
		return nd.getNtTotal(notice);
	}

	@Override
	public List<Notice> noticeList(Notice notice) {
		return nd.noticeList(notice);
	}

	@Override
	public Notice select(int num) {
		return nd.select(num);
	}

	@Override
	public List<Notice> noticeAllList(Notice notice) {
		return nd.noticeAllList(notice);
	}

}
