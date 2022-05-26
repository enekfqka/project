package com.project.dogwalkfriend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dogwalkfriend.model.Dog;
import com.project.dogwalkfriend.model.Friend;
import com.project.dogwalkfriend.model.Member;
import com.project.dogwalkfriend.model.Notice;
import com.project.dogwalkfriend.model.Walk;
import com.project.dogwalkfriend.service.DogService;
import com.project.dogwalkfriend.service.FriendService;
import com.project.dogwalkfriend.service.MemberService;
import com.project.dogwalkfriend.service.NoticeService;
import com.project.dogwalkfriend.service.WalkService;

@Controller
public class HomeController {
	@Autowired
	private DogService ds;
	@Autowired
	private FriendService fs;
	@Autowired
	private MemberService ms;
	@Autowired
	private NoticeService ns;
	@Autowired
	private WalkService ws;
	
	@RequestMapping("main")
	public String main() {
		return "main/main";
	}
	
	@RequestMapping("adminMain")
	public String adminMain(Dog dog, Friend friend, Notice notice, Walk walk, Model model) {
		// 친구 구함 목록
		List<Walk> wkAllList = ws.wkAllList(walk);
		
		// 친구 내역 목록
		List<Friend> fdAllList = fs.fdAllList(friend);
		for (Friend fd : fdAllList) {
			int WK_no = fd.getWK_no();
			Walk walk1 = ws.select(WK_no);
			int MB_noOw = walk1.getMB_no();
			Member member = ms.selectNo(MB_noOw);
			fd.setMB_nickOw(member.getMB_nick());
			Member memberDB = ms.selectNo(fd.getMB_no());
			fd.setMB_nick(memberDB.getMB_nick());
		}
		
		// 반려견 목록
		List<Dog> dogAllList = ds.dogAllList(dog);
		
		// 공지 사항 목록
		List<Notice> noticeAllList = ns.noticeAllList(notice);
		
		return "admin/adminMain";
	}
	
}
