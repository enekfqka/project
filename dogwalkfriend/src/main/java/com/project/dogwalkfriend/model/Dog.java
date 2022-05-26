package com.project.dogwalkfriend.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Dog {
	private int DOG_no;			// 강아지 번호
	private String DOG_breed;	// 종류
	private String DOG_name;	// 이름
	private String DOG_gender;	// 성별
	private int DOG_age;		// 나이
	private String DOG_size;	// 크기
	private String DOG_photo;	// 사진
	private int MB_no;			// 주인 번호
	
	// 업로드
	private MultipartFile file;
}