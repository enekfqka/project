<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 && resultAp > 0 && resultVh > 0 }">
		<script type="text/javascript">
			alert("드라이버 승인을 반려하였습니다");
			location.href = "adminPermitList.do?pageNum=${pageNum}";
		</script>
	</c:if>
	<c:if test="${result == 0 && resultAp == 0 && resultVh == 0 }">
		<script type="text/javascript">
			alert("드라이버 승인 반려에 실패하였습니다");
			history.back();
		</script>
	</c:if>
</body>
</html>