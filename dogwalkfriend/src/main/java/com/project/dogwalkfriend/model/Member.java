package com.project.dogwalkfriend.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private int MB_no;				// 회원 번호
	private String MB_id;			// 아이디
	private String MB_pw;			// 비밀번호
	private String MB_name;			// 이름
	private String MB_nick;			// 닉네임
	private String MB_tel;			// 전화번호
	private String MB_gender;		// 성별
	private String MB_loc;			// 지역
	private Date MB_regDate;		// 가입일
//	private String MB_ownerConfirm;	// 주인 여부
	private String MB_del;			// 탈퇴 여부
	
	// paging용
	private int startRow;
	private int endRow;
	
	// 검색용
	private String search;
	private String keyword;
}