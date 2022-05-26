package com.project.dogwalkfriend.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Friend {
	private int FD_no;			// 신청 번호
	private String FD_confirm;	// 신청 여부
	private String FD_mConfirm;	// 신청 여부
	private int MB_no;			// 회원 번호
	private int WK_no;			// 구함 게시글 번호
	
	// 조인용 (작성자 신청 내역에서 사용)
	private String MB_nick;		// 별명
	private String MB_gender;	// 성별
	
	// 조인용 (지원자 신청 내역에서 사용)
	private Date WK_startDate;	// 날짜
	private String WK_time;		// 시간
	private String WK_loc;		// 지역
	
	private int MB_noOw;		// 작성자 번호
	private String MB_nickOw;	// 작성자 닉네임	
	
	// paging용
	private int startRow;
	private int endRow;

	// 검색용
	private String search;
	private String keyword;
}