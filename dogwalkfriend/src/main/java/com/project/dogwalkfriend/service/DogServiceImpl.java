package com.project.dogwalkfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dogwalkfriend.dao.DogDao;
import com.project.dogwalkfriend.model.Dog;

@Service
public class DogServiceImpl implements DogService {
	@Autowired
	private DogDao dd;

	// 리스트
	@Override
	public List<Dog> list(int MB_no) {
		return dd.list(MB_no);
	}

	// 반려견 상세 정보
	@Override
	public Dog select(int DOG_no) {
		return dd.select(DOG_no);
	}

	// 반려견 정보 입력
	@Override
	public int insert(Dog dog) {
		return dd.insert(dog);
	}

	// 회원 탈퇴 시 반려견 정보 삭제
	@Override
	public int deleteAll(int MB_no) {
		return dd.deleteAll(MB_no);
	}

	@Override
	public List<Dog> dogAllList(Dog dog) {
		return dd.dogAllList(dog);
	}
}
