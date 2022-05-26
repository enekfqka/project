<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/dogwalkfriend/resources/bootstrap/css/style.css">
</head> 
<body>
<div id="dropMenu">
	<ul class="myMenu">
		<li class="menu1"><a href="wkList.do">친구 구함</a></li>
		<li class="menu2"><a href="ownerList.do">친구 내역</a>
			<ul class="menu2_s submenu">
				<li><a href="ownerList.do">작성자</a></li>
				<li><a href="applicantList.do">지원자</a></li>
			</ul>
		</li>
		<li class="menu3"><a href="reviewList.do">후기 게시판</a></li>
		<li class="menu4"><a href="freeList.do">자유 게시판</a></li>
		<li class="menu5"><a href="myMain.do">마이페이지</a>
			<ul class="menu5_s submenu">
				<li><a href="myMain.do">내 정보</a></li>
				<li><a href="dogList.do">반려견 정보</a></li>
				<li><a href="updatePwForm.do">비밀번호 변경</a></li>
			</ul>
		</li>   
		<li class="menu6"><a href="noticeList.do">고객센터</a>
			<ul class="menu6_s submenu">
				<li><a href="noticeList.do">공지사항</a></li>
				<li><a href="qnaList.do">문의내역</a></li>
				<li><a href="qnaWriteForm.do?num=0&pageNum=1">1:1 문의하기</a></li>
			</ul>
		</li>
	</ul>
</div>
</body>
</html>