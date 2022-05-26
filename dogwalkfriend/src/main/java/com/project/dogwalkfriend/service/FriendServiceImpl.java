package com.project.dogwalkfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dogwalkfriend.dao.FriendDao;
import com.project.dogwalkfriend.model.Friend;

@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendDao fd;

	@Override
	public int getTotalMyFd(Friend friend) {
		return fd.getTotalMyFd(friend);
	}

	@Override
	public List<Friend> myFdList(Friend friend) {
		return fd.myFdList(friend);
	}

	@Override
	public List<Friend> friendList(Friend friend) {
		return fd.friendList(friend);
	}

	@Override
	public Friend selectFd(Friend friend) {
		return fd.selectFd(friend);
	}

	@Override
	public int insert(Friend friend) {
		return fd.insert(friend);
	}

	@Override
	public int delete(Friend friend) {
		return fd.delete(friend);
	}

	@Override
	public int updateAccept(Friend friend) {
		return fd.updateAccept(friend);
	}

	@Override
	public int updateRefuse(Friend friend) {
		return fd.updateRefuse(friend);
	}

	@Override
	public int updateAllRefuse(int WK_no) {
		return fd.updateAllRefuse(WK_no);
	}

	@Override
	public Friend selectWk(int FD_no) {
		return fd.selectWk(FD_no);
	}

	@Override
	public List<Friend> fdAllList(Friend friend) {
		return fd.fdAllList(friend);
	}
}
