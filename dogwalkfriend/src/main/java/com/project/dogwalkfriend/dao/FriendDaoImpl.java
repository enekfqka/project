package com.project.dogwalkfriend.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dogwalkfriend.model.Friend;

@Repository
public class FriendDaoImpl implements FriendDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int getTotalMyFd(Friend friend) {
		return sst.selectOne("friendns.getTotalMyFd", friend);
	}

	@Override
	public List<Friend> myFdList(Friend friend) {
		return sst.selectList("friendns.myFdList", friend);
	}

	@Override
	public List<Friend> friendList(Friend friend) {
		return sst.selectList("friendns.friendList", friend);
	}

	@Override
	public Friend selectFd(Friend friend) {
		return sst.selectOne("friendns.selectFd", friend);
	}

	@Override
	public int insert(Friend friend) {
		return sst.insert("friend.insert", friend);
	}

	@Override
	public int delete(Friend friend) {
		return sst.delete("friendns.delete", friend);
	}

	@Override
	public int updateAccept(Friend friend) {
		return sst.update("friendns.updateAccept", friend);
	}

	@Override
	public int updateRefuse(Friend friend) {
		return sst.update("friendns.updateRefuse", friend);
	}

	@Override
	public int updateAllRefuse(int WK_no) {
		return sst.update("friendns.updateAllRefuse", WK_no);
	}

	@Override
	public Friend selectWk(int FD_no) {
		return sst.selectOne("friendns.selectWk", FD_no);
	}

	@Override
	public List<Friend> fdAllList(Friend friend) {
		return sst.selectList("friendns.fdAllList", friend);
	}
}
