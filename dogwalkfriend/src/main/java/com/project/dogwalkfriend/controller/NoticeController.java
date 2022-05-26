package com.project.dogwalkfriend.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dogwalkfriend.model.Notice;
import com.project.dogwalkfriend.service.NoticeService;
import com.project.dogwalkfriend.service.PageBean;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	@RequestMapping("noticeList")
	public String noticeList(Model model, Notice notice, String pageNum) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -3); // 3일간 보이기
		String nowday = simpleDate.format(cal.getTime());
		// 처음 notice에는 null로 받아 오고, startRow, endRow 보내 주기 위한 용도
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10;	// 한 화면에 보여주는 게시글 개수
		int total = ns.getNtTotal(notice);
		int startRow = (currentPage -1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		notice.setStartRow(startRow);
		notice.setEndRow(endRow);
		List<Notice> noticeList = ns.noticeList(notice);
		int num = total - startRow + 1;
		PageBean pb = new PageBean(currentPage, rowPerPage, total);
		
		String[] title = {"제목", "내용", "제목+내용"};	// 작성자는 관리자뿐이므로 제외
		model.addAttribute("nowday", nowday);
		model.addAttribute("title", title);	// 검색 기능
		model.addAttribute("pb", pb);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("num", num);
		return "notice/noticeList";
	}
	
	@RequestMapping("noticeView")
	public String noticeView(int NT_num, String pageNum, Model model) {
		Notice notice = ns.select(NT_num);
		model.addAttribute("notice", notice);
		model.addAttribute("pageNum", pageNum);
		return "notice/noticeView";
	}
}