package com.project.dogwalkfriend.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Notice {
	private int NT_no;			// 공지 게시글 번호
	private String NT_title;	// 제목
	private String NT_content;	// 내용
	private Date NT_regDate;	// 작성일
	private int NT_readCnt;		// 조회 수
	private String NT_del;		// 삭제 여부
	private int MB_no;
	
	// paging용
	private int startRow;
	private int endRow;
	
	// 검색용
	private String search;
	private String keyword;
}