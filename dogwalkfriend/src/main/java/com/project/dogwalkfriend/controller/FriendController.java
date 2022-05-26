package com.project.dogwalkfriend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dogwalkfriend.model.Friend;
import com.project.dogwalkfriend.model.Member;
import com.project.dogwalkfriend.model.Walk;
import com.project.dogwalkfriend.service.FriendService;
import com.project.dogwalkfriend.service.MemberService;
import com.project.dogwalkfriend.service.PageBean;
import com.project.dogwalkfriend.service.WalkService;

@Controller
public class FriendController {
	@Autowired
	private FriendService fs;
	@Autowired
	private MemberService ms;
	@Autowired
	private WalkService ws;
	
	// 예약 내역에서 작성자 본인이 작성한 글들을 확인
	@RequestMapping("ownerList")
	public String ownerList(Walk walk, String pageNum, Model model, HttpSession session) {
		String MB_id = (String) session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		int MB_no = member.getMB_no();
		walk.setMB_no(MB_no);
		
		// 페이징
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10; // 한 화면에 보이는 게시글 수
		int total = ws.getTotalMyFd(walk);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		
		walk.setStartRow(startRow);
		walk.setEndRow(endRow);
		List<Walk> myWalkList = ws.myWalkList(walk);
		int num = total - startRow + 1;
		PageBean pb = new PageBean(currentPage, rowPerPage, total);
		String[] title = {"산책일", "장소"};
		
		model.addAttribute("title", title);
		model.addAttribute("pb", pb);
		model.addAttribute("myWalkList", myWalkList);
		model.addAttribute("num", num);
		return "friend/ownerList";
	}
	
	// 예약 내역에서 지원자로서 지원했던 글들을 확인
	@RequestMapping("applicantList")
	public String applicantList(Friend friend, String pageNum, Model model, HttpSession session) {
		String MB_id = (String) session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		int MB_no = member.getMB_no();
		friend.setMB_no(MB_no);
		
		// 페이징
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10; // 한 화면에 보이는 게시글 수
		int total = fs.getTotalMyFd(friend);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		
		friend.setStartRow(startRow);
		friend.setEndRow(endRow);
		List<Friend> myFdList = fs.myFdList(friend);
		for (Friend fd : myFdList) {
			int WK_no = fd.getWK_no(); 				// 신청 테이블에서 내가 신청한 게시글의 번호
			Walk walk = ws.select(WK_no);			// 가져온 게시글 번호로 게시글의 정보
			int MB_noOw = walk.getMB_no();			// 게시글 정보에서 작성자의 번호
			Member member2 = ms.selectNo(MB_noOw);	// 게시글 작성자의 번호로 작성자의 정보
			fd.setMB_noOw(member2.getMB_no());		// 가져온 정보를 이용해서 객체 적용
			fd.setMB_nickOw(member2.getMB_nick());	// 가져온 정보를 이용해서 객체 적용
			fd.setMB_no(MB_no);	// 지원자의 번호를 재설정
		}
		
		int num = total - startRow + 1;
		PageBean pb = new PageBean(currentPage, rowPerPage, total);
		String[] title = {"산책일", "장소"};
		model.addAttribute("title", title);
		model.addAttribute("pb", pb);
		model.addAttribute("myFdList", myFdList);
		model.addAttribute("num", num);
		
		return "friend/applicantList";
	}
}
