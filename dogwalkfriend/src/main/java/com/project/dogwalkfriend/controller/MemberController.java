package com.project.dogwalkfriend.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dogwalkfriend.model.Member;
import com.project.dogwalkfriend.service.DogService;
import com.project.dogwalkfriend.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private DogService ds;
	@Autowired
	private JavaMailSender jMailSender;
	
	// 회원 가입 폼으로
	@RequestMapping("joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	// 아이디 중복 체크
	@RequestMapping(value = "idChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String idChk(String MB_id) {
		String msg = "";
		Member member = ms.select(MB_id);
		if (member == null) {
			msg = "사용 가능한 아이디입니다.";
		} else {
			msg = "이미 사용 중인 아이디입니다.";
		}
		return msg;
	}
	
	// 닉네임 중복 체크
	@RequestMapping(value = "nickChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String nickChk(String MB_nick) {
		String msg = "";
		Member member = ms.selectNick(MB_nick);
		if (member == null) {
			msg = "사용 가능한 닉네임입니다.";
		} else {
			msg = "이미 사용 중인 닉네임입니다.";
		}
		return msg;
	}
	
	// 마이 페이지에서 닉네임 중복 체크
	@RequestMapping(value = "myNickChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String myNickChk(Member member) {
		String msg = "";
		Member member2 = ms.selectMyNick(member);
		if (member2 != null) {
			msg = "사용 가능한 닉네임입니다.";
		} else {
			Member member3 = ms.selectNick(member.getMB_nick());
			if (member3 == null) {
				msg = "사용 가능한 닉네임입니다.";
			} else {
				msg = "이미 사용 중인 닉네임입니다.";
			}
		}
		return msg;
	}
	
	// 회원 가입
	@RequestMapping("join")
	public String join(Member member, Model model) {
		int result = 0;
		Member member2 = ms.select(member.getMB_id());
		if (member2 == null) {
			result = ms.insert(member);
		} else {
			result = -1;
		}
		model.addAttribute("result", result);
		return "member/joinResult";
	}
	
	// 로그인 폼으로
	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest request, Model model) {
		String prevUrl = request.getHeader("Referer");
		prevUrl = prevUrl.substring(28);
		model.addAttribute("prevUrl", prevUrl);
		return "member/loginForm";
	}
	
	// 로그인
	@RequestMapping("login")
	public String login(String prevUrl, Member member, Model model, HttpSession session) {
		Member memberDB = ms.select(member.getMB_id());
		int result = 0;
		if (memberDB == null) {
			result = -1;
		} else if (memberDB.getMB_del().equals("Y"))
			result = -1;
		else if (memberDB.getMB_pw().equals(member.getMB_pw())) {
			result = 1;
			session.setAttribute("MB_id", member.getMB_id());
			session.setAttribute("MB_no", memberDB.getMB_no());
			session.setAttribute("MB_nick", memberDB.getMB_nick());
		}
		model.addAttribute("result", result);
		model.addAttribute("prevUrl", prevUrl);
		return "member/loginResult";
	}
	
	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	
	// 아이디 찾기 폼으로
	@RequestMapping("findIdForm")
	public String findIdForm() {
		return "member/findIdForm";
	}
	
	// 아이디 찾기
	@RequestMapping("findId")
	public String findId(Member member, Model model) {
		int result = 0;
		Member member2 = ms.selectFindId(member);
		if (member2 != null) {
			result = 1;
			model.addAttribute("member", member2);
		} else {
			result = -1;
		}
		model.addAttribute("result", result);
		return "member/findId";
	}
	
	// 비밀번호 찾기 폼으로
	@RequestMapping("findPwForm")
	public String findPwForm(String MB_id, Model model) {
		// 아이디 찾기 후 비밀번호를 찾으면 값이 자동으로 넘어가게 하기 위함
		model.addAttribute("MB_id", MB_id);
		return "member/findPwForm";
	}
	
	// 비밀번호 찾기
	@RequestMapping("findPw")
	public String findPw(Member member, Model model) {
		int result = 0;
		Member member2 = ms.selectFindPw(member);
		if (member2 != null) {
			// 아이디가 존재 할 때 결과 값 1을 반영
			result = 1;
			model.addAttribute("member", member2);
			
			// 난수 생성
			String msg = "";
			String code = "";
			Random random = new Random();
			for(int i = 0; i < 3; i++) {
				int index = random.nextInt(25) + 65; //A~Z까지 랜덤 알파벳 생성
				code += (char)index;
			}
			int numIndex = random.nextInt(9999) + 1000; //4자리 랜덤 정수 생성
			code += numIndex;		
			msg = code;  //메시지 내용 함수입력
					
			MimeMessage mm = jMailSender.createMimeMessage();
			try {
				MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "utf-8");
				mmh.setSubject("임시 비밀번호입니다.");
				mmh.setText("임시 비밀번호 : " + msg);
				mmh.setTo(member.getMB_id());
				mmh.setFrom("email@email.com");
				jMailSender.send(mm);
				
				// 이메일이 성공적으로 보내졌으면 멤버 비밀번호를 변경
				member.setMB_pw(msg);
				int resultUpdatePw = ms.updatePw(member);
				model.addAttribute("resultUpdatePw", resultUpdatePw);
				
			} catch (Exception e) {
				result = 0;
				model.addAttribute("msg", e.getMessage());
			}		
		} else {
			result = -1;
		}
		model.addAttribute("result", result);
		return "member/findPw";
	}
	
	// 마이 페이지 메인으로
	@RequestMapping("myMain")
	public String myMain(Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		model.addAttribute("member", member);
		return "mypage/myMain";
	}
	
	// 마이 페이지 정보 수정 폼으로
	@RequestMapping("updateForm")
	public String updateForm(Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		model.addAttribute("member", member);
		return "mypage/updateForm";
	}
	
	// 마이 페이지 정보 수정
	@RequestMapping("update")
	public String updateResult(Member member, Model model){
		int result = ms.update(member);
		model.addAttribute("member", member);
		model.addAttribute("result", result);
		return "mypage/update";
	}
	
	// 비밀번호 변경 폼으로
	@RequestMapping("updatePwForm")
	public String updatePwForm(Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		model.addAttribute("member", member);
		return "mypage/updatePwForm";
	}
	
	// 비밀번호 변경
	@RequestMapping("updatePw")
	public String updatePw(Member member, Model model) {
		int result = ms.updatePw(member);
		model.addAttribute("result", result);
		return "mypage/updatePw";
	}
	
	// 마이 페이지 회원 탈퇴
	@RequestMapping("delete")
	public String delete(Model model, HttpSession session) {
		String MB_id = (String)session.getAttribute("MB_id");
		Member member = ms.select(MB_id);
		int MB_no = member.getMB_no();
		
		int result = ms.delete(MB_id);
		if (result == 1) {
			session.invalidate();
			int resultDog = ds.deleteAll(MB_no);
			model.addAttribute("resultDog", resultDog);
		}
		model.addAttribute("result", result);
		return "mypage/delete";  
	}
	
	// 프로필 상세 보기
	@RequestMapping("profileView")
	public String profileView(String MB_nick, HttpSession session, Model model) {
		int result = 0;		
		Member member = ms.selectNick(MB_nick); // 선택한 계정의 정보를 가져옴
		if (member.getMB_del() == "Y") { // 회원 탈퇴 처리 되어 있는지 확인
			result = 0; // 회원 탈퇴 처리가 되어 있음
		} else {
			result = 1; // 회원 탈퇴 처리가 안 되어 있을 경우
		}
		model.addAttribute("result", result); // 회원 탈퇴 여부 확인
		model.addAttribute("member", member); // 프로필에서 회원정보 입력하기 위해서
		return "nolayout/profileView";
	}
}
