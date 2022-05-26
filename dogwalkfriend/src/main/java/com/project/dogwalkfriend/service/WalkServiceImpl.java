package com.project.dogwalkfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dogwalkfriend.dao.WalkDao;
import com.project.dogwalkfriend.model.Walk;

@Service
public class WalkServiceImpl implements WalkService {
	@Autowired
	private WalkDao wd;
	
	@Override
	public int insert(Walk walk) {
		return wd.insert(walk);
	}

	@Override
	public List<Walk> wkList(Walk walk) {
		return wd.wkList(walk);
	}
	
	@Override
	public int getTotal(Walk walk) {
		return wd.getTotal(walk);
	}

	@Override
	public int getMaxNum() {
		return wd.getMaxNum();
	}

	@Override
	public Walk select(int WK_no) {
		return wd.select(WK_no);
	}

	@Override
	public int update(Walk walk) {
		return wd.update(walk);
	}

	@Override
	public int delete(int WK_no) {
		return wd.delete(WK_no);
	}

	@Override
	public int updatePersonNow(int WK_no) {
		return wd.updatePersonNow(WK_no);
	}

	@Override
	public int getTotalMyFd(Walk walk) {
		return wd.getTotalMyFd(walk);
	}

	@Override
	public List<Walk> myWalkList(Walk walk) {
		return wd.myWalkList(walk);
	}

	@Override
	public List<Walk> wkAllList(Walk walk) {
		return wd.wkAllList(walk);
	}
}
