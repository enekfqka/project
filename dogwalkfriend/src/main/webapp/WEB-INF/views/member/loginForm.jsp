<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td, th {
    padding: 14px 0px;
}
   	
#loginBtn {
	margin-top: 30px;
	margin-bottom: 30px;
}
</style>
</head>
<body>
<div class=""  align="center">
	<h2 class="title">로그인</h2>
	<form action="login.do?prevUrl=${prevUrl }" method="post">
		<table>  
			<tr>
				<td class="">
					<input type="text" name="MB_id" required="required" autofocus="autofocus" placeholder="아이디" class="">
				</td>
			<tr>
				<td class="">
					<input type="password" name="MB_pw" required="required" placeholder="비밀번호" class="">
				</td>
			<tr>
			<tr>
				<td class="">
					<input type="submit" value="로그인" class="btn_large" id="loginBtn">
				</td>
			</tr>  
		</table>
		
		<a href="findIdForm.do" class="">아이디 찾기</a>
		&nbsp; | &nbsp;
		<a href="findPwForm.do" class="">비밀번호 찾기</a>
	</form>
</div>  
</body>
</html>