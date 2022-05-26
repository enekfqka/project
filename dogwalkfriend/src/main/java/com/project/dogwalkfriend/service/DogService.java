package com.project.dogwalkfriend.service;

import java.util.List;

import com.project.dogwalkfriend.model.Dog;

public interface DogService {
	List<Dog> list(int MB_no);	// 리스트
	Dog select(int DOG_no);		// 반려견 상세 정보
	int insert(Dog dog);		// 반려견 정보 입력
	int deleteAll(int MB_no);	// 회원 탈퇴 시 반려견 정보 삭제
	
	List<Dog> dogAllList(Dog dog); // 관리자 - 반려견 목록

}
