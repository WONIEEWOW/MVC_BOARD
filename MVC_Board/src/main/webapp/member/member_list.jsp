<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%-- EL 에서 표기 방식(날짜 등)을 변경하려면 fmt(format) 라이브러리 필요  --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<!-- 외부 CSS 가져오기 -->
<link href="css/default.css" rel="stylesheet" type="text/css">
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<!-- 외부 CSS 가져오기 -->
<link href="css/default.css" rel="stylesheet" type="text/css">
<style type="text/css">
	#listForm {
		width: 1024px;
		max-height: 610px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 1024px;
	}
	
	#tr_top {
		background: orange;
		text-align: center;
	}
	
	table td {
		text-align: center;
	}
	
	#subject {
		text-align: left;
		padding-left: 20px;
	}
	
	#pageList {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#emptyArea {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#buttonArea {
		margin: auto;
		width: 1024px;
		text-align: right;
		margin-top: 10px;
	}
	
	a {
		text-decoration: none;
	}
</style>
<script>
	function confirm_delete(id) {
		// Confirm Dialog 를 활용하여 "회원탈퇴 하시겠습니까?" 질문 처리
		let result = confirm("회원 탈퇴 하시겠습니까?");
		
		// 선택된 결과값이 true 일 경우 페이지로 이동
		if(result) {
			location.href = "MemberDelete.me?id="+id;
		}
	}

</script>
</head>
<body>
	<header>
	<!-- Login, Join 링크 표시 영역 -->
	<jsp:include page="/inc/top.jsp"></jsp:include>
	</header>
	<!-- 게시판 리스트 -->
	<section id="listForm">
	<h2>회원목록</h2>

	<table>
		<tr id="tr_top">
			<td width="100px">이름</td>
			<td width="50px">성별</td>
			<td width="150px">이메일</td>
			<td width="150px">아이디</td>
			<td width="100px">패스워드</td>
			<td width="100px">가입일자</td>
			<td width="200px">비고</td>
		</tr>
		<!-- JSTL 과 EL 활용하여 글목록 표시 작업 반복 -->
		<c:forEach var="member" items="${memberList }">
		<tr height="50">
			<td width="100px">${member.name }</td>
			<td>${member.gender }</td>
			<td width="150px">${member.email }</td>
			<td width="150px">${member.id }</td>
			<td width="100px">${member.passwd }</td>
			<td><fmt:formatDate value="${member.date }" pattern="yy-MM-dd" /></td>
			<td>
			<input type="button" value="회원탈퇴" onclick="javascript:confirm_delete('${member.id }')">
			</td>
		</tr>
		</c:forEach>	
	</table>
	</section>

</body>
</html>













