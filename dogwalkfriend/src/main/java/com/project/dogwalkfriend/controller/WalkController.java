package com.project.dogwalkfriend.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class WalkController {
	@Autowired
	private WalkService ws;
	@Autowired
	private MemberService ms;
	@Autowired
	private FriendService fs;
	
	// 리스트
	@RequestMapping("wkList")
	public String wkList(Walk walk, String pageNum, Model model) {
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 6; // 한 화면에 보여주는 게시글 갯수
		int total = ws.getTotal(walk);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		walk.setStartRow(startRow);
		walk.setEndRow(endRow);
		List<Walk> wkList = ws.wkList(walk);
		int WK_no = total - startRow + 1;
		PageBean pb = new PageBean(currentPage, rowPerPage, total);
		model.addAttribute("WK_no", WK_no);
		model.addAttribute("walk", walk);
		model.addAttribute("pb", pb);
		model.addAttribute("wkList", wkList);
		return "walk/wkList";
	}
	
	// 게시글 작성 폼
	@RequestMapping("wkWriteForm")
	public String wkWriteForm(int WK_no, Member member, String pageNum, Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id");
		member = ms.select(MB_id);
		// 출발일 설정 시 현재 날짜보다 이전 날짜 X
		Calendar now_date1 = Calendar.getInstance(); // 현재 날짜
		Calendar now_time1 = Calendar.getInstance(); // 현재 시간
		// 출발일이 오늘, 시간이 현재 시간 이전으로 X
		// now_time을 현재 시간 +1 최소 1시간 여유가 생김
		now_time1.set(Calendar.HOUR_OF_DAY, now_time1.get(Calendar.HOUR_OF_DAY) + 1);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm"); 		// 시간 형식
		Date now_date = now_date1.getTime();
		Date now_time = now_time1.getTime();
		model.addAttribute("now_date", sdf1.format(now_date));
		model.addAttribute("now_time", sdf2.format(now_time));
		model.addAttribute("member", member);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkWriteForm";
	}
	
	// 게시글 작성 결과
	@RequestMapping("wkWrite")
	public String wkWrite(Walk walk, String pageNum, Model model) {
		int number = ws.getMaxNum();
		walk.setWK_no(number);
		int result = ws.insert(walk);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkWrite";
	}
	
	// 리스트 상세
	@RequestMapping("wkView")
	public String wkView(int WK_no, String pageNum, Model model, HttpSession session) {
		Friend friend = new Friend();
		friend.setWK_no(WK_no);
		List<Friend> friendList = fs.friendList(friend);
		String MB_id = (String) session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		Walk walk = ws.select(WK_no);
		Member memberDB = null;
		
		//신청 취소 버튼용
		Friend friend2 = new Friend();
		friend2.setWK_no(WK_no);
		friend2.setMB_no(member.getMB_no());
		friend2 = fs.selectFd(friend2);
		model.addAttribute("friend2", friend2);
		
		model.addAttribute("memberDB", memberDB);
		model.addAttribute("friendList", friendList);
		model.addAttribute("member", member);
		model.addAttribute("walk", walk);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkView";
	}
	
	// 게시글 수정 (작성한 회원만 가능)
	@RequestMapping("wkUpdateForm")
	public String wkUpdateForm(int WK_no, Member member, String pageNum, Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id");
		member = ms.select(MB_id);
		Walk walk = ws.select(WK_no);
		// 출발일 설정 시 현재 날짜보다 이전 날짜 X
		Calendar now_date1 = Calendar.getInstance(); // 현재 날짜
		Calendar now_time1 = Calendar.getInstance(); // 현재 시간
		// 출발일이 오늘, 시간이 현재 시간 이전으로 X
		// now_time을 현재 시간 +1 최소 1시간 여유가 생김
		now_time1.set(Calendar.HOUR_OF_DAY, now_time1.get(Calendar.HOUR_OF_DAY) + 1);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm"); 		// 시간 형식
		Date now_date = now_date1.getTime();
		Date now_time = now_time1.getTime();
		model.addAttribute("now_date", sdf1.format(now_date));
		model.addAttribute("now_time", sdf2.format(now_time));
		model.addAttribute("member", member);
		model.addAttribute("walk", walk);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkUpdateForm";
	}
	
	// 게시글 수정 결과
	@RequestMapping("wkUpdate")
	public String wkUpdate(Walk walk, String pageNum, Model model) {
		int result = ws.update(walk);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkUpdate";
	}
	
	// 게시글 삭제
	@RequestMapping("wkDeleteForm")
	public String wkDeleteForm(int WK_no, String pageNum, Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id"); // session에 저장된 MB_id를 통해 MB_pw 정보 받기
		Member member = ms.select(MB_id);
		Walk walk = ws.select(WK_no);
		model.addAttribute("member", member); // 게시글 삭제 시 회원 비밀번호 검사 후 삭제
		model.addAttribute("walk", walk);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkDeleteForm";
	}
	
	// 게시글 삭제 결과
	@RequestMapping("wkDelete")
	public String wkDelete(int WK_no, String pageNum, Model model) {
		int result = ws.delete(WK_no);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkDelete";
	}
	
	// 신청 버튼 클릭 시
	@RequestMapping("wkRequest")
	public String wkRequest(int WK_no, int MB_no, String pageNum, Model model) {
		int result = 0;
		Friend friend = new Friend();
		friend.setWK_no(WK_no);
		friend.setMB_no(MB_no);
		// 중복 클릭 방지
		Friend friend2 = fs.selectFd(friend);
		if (friend2 != null) {
			result = -1;				// 신청한 정보가 존재
		} else {
			result = fs.insert(friend);	// 신청 성공/실패
		}
		model.addAttribute("WK_no", WK_no);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "walk/wkRequest";
	}
	
	// 신청 취소 버튼
	@RequestMapping("wkCancelRequest")
	public String wkCancelRequest(int WK_no, int MB_no, String pageNum, Model model) {
		Friend friend = new Friend();
		friend.setWK_no(WK_no);
		friend.setMB_no(MB_no);
		int result = fs.delete(friend);
		model.addAttribute("result", result);
		model.addAttribute("WK_no", WK_no);
		return "walk/wkCancelRequest";
	}
	
	// 작성자 로그인 >> 매칭 여부 "수락" 버튼 클릭 시
	@RequestMapping("wkAccept")
	public String wkAccept(int WK_no, int MB_no, Model model) {
		Friend friend = new Friend();
		friend.setWK_no(WK_no);
		friend.setMB_no(MB_no);
		int result = fs.updateAccept(friend);
		// 작성자가 수락을 해서 신청자가 매칭 완료 상태가 될 때마다 WK_personNow에 +1
		int addNum = ws.updatePersonNow(WK_no);
		// 게시글 매칭 완료 시 기존에 신청된 수락 버튼을 거절로 변경 (매칭 완료된 인원 수가 총 인원 수와 일치할 때 '매칭 대기'였던 상태를 '거절'로 변경)
		Walk walk = ws.select(WK_no);
		if (walk.getWK_personNow() == walk.getWK_personNum()) {
			int allRefuse = fs.updateAllRefuse(WK_no);
		}
		model.addAttribute("result", result);
		model.addAttribute("WK_no", WK_no);
		return "walk/wkAccept";
	}
	
	
	// 작성자 로그인 >> 매칭 여부 "거절" 버튼 클릭 시
	@RequestMapping("wkRefuse")
	public String wkRefuse(int WK_no, int MB_no, Model model) {
		Friend friend = new Friend();
		friend.setWK_no(WK_no);
		friend.setMB_no(MB_no);
		int result = fs.updateRefuse(friend);
		model.addAttribute("result", result);
		model.addAttribute("WK_no", WK_no);
		return "walk/wkRefuse";
	}
}
