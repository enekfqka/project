package com.project.dogwalkfriend.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Walk {
	private int WK_no;			// 구함 게시글 번호
	private String WK_title;	// 제목
	private Date WK_regDate;	// 작성일
	private Date WK_startDate;	// 날짜
	private String WK_time;		// 시간
	private String WK_loc;		// 지역
	private int WK_personNum;	// 총 인원 수
	private int WK_personNow;	// 신청 완료된 인원 수
	private String WK_content;	// 내용
	private int WK_readCnt;		// 조회 수
	private String WK_del;		// 삭제 여부
	private int MB_no;			// 회원 번호(작성자)
	
	// 조인용
	private String MB_nick;
	private String FD_confirm;
	private String FD_mConfirm;
	private int MB_noAp;			// 회원 번호(지원자)
	
	// paging용
	private int startRow;
	private int endRow;
	
	// 검색용
	private String search;
	private String keyword;
}