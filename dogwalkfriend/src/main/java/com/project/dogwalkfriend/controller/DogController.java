package com.project.dogwalkfriend.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dogwalkfriend.model.Dog;
import com.project.dogwalkfriend.model.Member;
import com.project.dogwalkfriend.service.DogService;
import com.project.dogwalkfriend.service.MemberService;

@Controller
public class DogController {
	@Autowired
	private DogService ds;
	@Autowired
	private MemberService ms;
	
	// 반려견 리스트로 이동
	@RequestMapping("dogList")
	public String dogList(HttpSession session, Model model) {
		String MB_id = (String) session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		int MB_no = member.getMB_no();
		List<Dog> dogList = ds.list(MB_no);
		model.addAttribute("dogList", dogList);
		return "mypage/dogList";
	}
	
	// 반려견 정보 입력
	@RequestMapping("dogInsert")
	public String dogInsert(Dog dog, Model model, HttpSession session) throws IOException {
		// 회원 정보 등록
		int result = 0;
		Dog dog2 = ds.select(dog.getDOG_no());
		if (dog2 == null) {
			// 사진을 리소스 폴더에 저장하기 위한 로직
			String fileName1 = dog.getFile().getOriginalFilename();
			UUID uuid = UUID.randomUUID(); // 파일 이름이 겹치지 않게 하기 위함
			String fileName = uuid+"_"+fileName1;
			
			// 파일을 리소스 폴더에 저장
			String real = session.getServletContext().getRealPath("/resources/dogphoto");
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(dog.getFile().getBytes());
			fos.close();
			
			// 정보 등록
			dog.setDOG_photo(fileName);
			result = ds.insert(dog);
		} else {
			result = -1;
		}
		model.addAttribute("result", result);
		return "mypage/dogInsert";
	}
	
	// 반려견 상세 정보
	@RequestMapping("dogView")
	public String dogView(int DOG_no, Model model) {
		Dog dog = ds.select(DOG_no);
		model.addAttribute("dog", dog);
		return "mypage/dogView";
	}
	
}
