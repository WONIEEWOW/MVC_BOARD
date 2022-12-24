<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%-- EL 에서 표기 방식(날짜 등)을 변경하려면 fmt(format) 라이브러리 필요  --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 CSS 가져오기 -->
<link href="css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 세션 아이디가 null 이 아닐 경우 메인페이지로 돌려보내기 -->
	<header>
		<!-- Login, Join 링크 표시 영역(inc/top.jsp 페이지 삽입) -->
		<jsp:include page="/inc/top.jsp"></jsp:include>
	</header>
	<h1>로그인</h1>
	<form action="MemberLoginPro.me" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required" size="20"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="passwd" required="required" size="20"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href=''">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>













