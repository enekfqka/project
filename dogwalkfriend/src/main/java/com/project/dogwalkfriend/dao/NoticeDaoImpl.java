package com.project.dogwalkfriend.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dogwalkfriend.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int getNtTotal(Notice notice) {
		return sst.selectOne("noticens.getNtTotal", notice);
	}

	@Override
	public List<Notice> noticeList(Notice notice) {
		return sst.selectList("noticens.noticeList", notice);
	}

	@Override
	public Notice select(int num) {
		return sst.selectOne("noticens.select", num);
	}

	@Override
	public List<Notice> noticeAllList(Notice notice) {
		return sst.selectList("noticens.noticeAllList", notice);
	}
	
}
