package com.project.dogwalkfriend.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dogwalkfriend.model.Walk;

@Repository
public class WalkDaoImpl implements WalkDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int insert(Walk walk) {
		return sst.insert("walkns.insert", walk);
	}

	@Override
	public List<Walk> wkList(Walk walk) {
		return sst.selectList("walkns.wkList", walk);
	}

	@Override
	public int getTotal(Walk walk) {
		return sst.selectOne("walkns.getTotal", walk);
	}

	@Override
	public int getMaxNum() {
		return sst.selectOne("walkns.getMaxNum");
	}

	@Override
	public Walk select(int WK_no) {
		return sst.selectOne("walkns.select", WK_no);
	}

	@Override
	public int update(Walk walk) {
		return sst.update("walkns.update", walk);
	}

	@Override
	public int delete(int WK_no) {
		return sst.update("walkns.delete", WK_no);
	}

	@Override
	public int updatePersonNow(int WK_no) {
		return sst.update("walkns.updatePersonNow", WK_no);
	}

	@Override
	public int getTotalMyFd(Walk walk) {
		return sst.selectOne("walkns.getTotalMyFd", walk);
	}

	@Override
	public List<Walk> myWalkList(Walk walk) {
		return sst.selectList("walkns.myWalkList", walk);
	}

	@Override
	public List<Walk> wkAllList(Walk walk) {
		return sst.selectList("walkns.wkAllList", walk);
	}
}
