<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/dogwalkfriend/resources/bootstrap/css/style.css">
</head>
<body>
	<div id="dropMenu">
			<ul class="myMenu">
				<li class="menu1"><a href="adminWkList.do">친구 구함</a></li>
				<li class="menu2"><a href="adminFdList.do">친구 내역</a></li>
				<li class="menu3"><a href="adminMbList.do">회원 관리</a></li>
				<li class="menu4"><a href="adminRvList.do">후기 게시판</a></li>
				<li class="menu5"><a href="adminFreeList.do">자유 게시판</a></li>
				<li class="menu6"><a href="adminNoticeList.do">고객센터</a>
					<ul class="menu6_s submenu">
						<li><a href="adminNoticeList.do">공지 사항</a></li>
						<li><a href="adminQnaList.do">문의 내역</a></li>
					</ul></li>
			</ul>
	</div>
</body>
</html>