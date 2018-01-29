<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="<c:url value='/resources/css/topBanner.css'/>" rel="stylesheet" type="text/css">
	</head>
	<body>
		<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
		
		<div class="container ">
			<%-- <img class="col-2 logo" src="<c:url value='/resources/image/logo.jpg'/>" alt="logo"> --%>
			<c:if test="${sessionScope.loginId != null}">
				<label class="">안녕하세요 ${sessionScope.loginId} 회원님</label>
				<a class="btn btn-sm btn-primary" href="${myContextPath}/member/update">회원 정보 수정</a>
				<a class="btn btn-sm btn-info" href="${myContextPath}/member/logout">로그아웃</a>
			</c:if>
			
		</div>
		
	</body>
</html>