<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%-- EL 에서 표기 방식(날짜 등)을 변경하려면 fmt(format) 라이브러리 필요  --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<script>
	function confirm_logout() {
		// Confirm Dialog 를 활용하여 "로그아웃 하시겠습니까?" 질문 처리
		let result = confirm("로그아웃 하시겠습니까?");
		
		// 선택된 결과값이 true 일 경우 logout.jsp 페이지로 이동
		if(result) {
			location.href = "MemberLogout.me";
		}
	}

</script>
<div id="member_area" >
	<a href="./">Home</a> 

<c:choose>
    <c:when test="${sId eq null }">
		| <a href="MemberLoginForm.me">Login</a> 
		| <a href="MemberJoinForm.me">Join</a>
    </c:when>
    <c:otherwise>
    	| ${sId }님
    	| <a href="javascript:confirm_logout()">Logout</a>
   		<c:if test="${sId eq 'admin' }">
	 	| <a href="MemberList.me">MemberList</a>
	 	</c:if>
	 </c:otherwise>
</c:choose>

</div>

