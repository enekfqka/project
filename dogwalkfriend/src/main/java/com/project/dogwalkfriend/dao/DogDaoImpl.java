package com.project.dogwalkfriend.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dogwalkfriend.model.Dog;

@Repository
public class DogDaoImpl implements DogDao {
	@Autowired
	private SqlSessionTemplate sst;

	// 리스트
	@Override
	public List<Dog> list(int MB_no) {
		return sst.selectList("dogns.list", MB_no);
	}

	// 반려견 상세 정보
	@Override
	public Dog select(int DOG_no) {
		return sst.selectOne("dogns.select", DOG_no);
	}

	// 반려견 정보 입력
	@Override
	public int insert(Dog dog) {
		return sst.insert("dogns.insert", dog);
	}

	// 회원 탈퇴 시 반려견 정보 삭제
	@Override
	public int deleteAll(int MB_no) {
		return sst.update("dogns.deleteAll", MB_no);
	}
	
	// 관리자 - 반려견 목록
	@Override
	public List<Dog> dogAllList(Dog dog) {
		return sst.selectList("dogns.dogAllList", dog);
	}
}
