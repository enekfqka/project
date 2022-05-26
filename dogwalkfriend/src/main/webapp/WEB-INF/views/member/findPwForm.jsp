<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<style type="text/css">
td, th {
    padding: 14px 0px;	
}

#idBtn {
	margin-top: 30px;
}
</style>
</head>
<body>
<div class="" align="center">
	<h2 class="title">비밀번호 찾기</h2>
	<form action="findPwResult.do" method="post">
		<table>  
			<tr>
				<td class="">
					<input type="text" name="MB_name" required="required" autofocus="autofocus" placeholder="이름" class="">
				</td>
			</tr>
			<!-- 아이디 찾기 후 비밀번호를 찾으면 값이 자동으로 넘어옴 -->
			<c:if test="${MB_id != null }">
			<tr>		
				<td class="">
					<input type="text" name="MB_id" id="email" required="required" value="${MB_id }" class="">
				</td>
			</tr>
			</c:if>
			<c:if test="${MB_id == null }">
			<tr>
				<td class="">
					<input type="text" name="MB_id" id="email" required="required" placeholder="아이디" class="">
				</td>
			</tr>  
			</c:if>
			
			<tr>
				<td class="">
					<input type="submit" value="비밀번호 찾기" class="btn_large" id="idBtn">
				</td>
			</tr>
		</table>
		<a href="findIdForm.do" class="">아이디 찾기</a>
		&nbsp; | &nbsp;
		<a href="joinForm.do" class="">회원가입</a>
		&nbsp; | &nbsp;
		<a href="loginForm.do" class="">로그인</a>
	</form>
</div>
</body>
</html>