<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<body>
		<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
		
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">메뉴</span> 
						<span class="icon-bar"></span>
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="./">서가 앤 북</a>
				</div>
				
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="#">도서 등록</a></li>
						<li><a href="#about">서평 모음</a></li>
						<li><a href="#contact">질문 게시판</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" 
								role="button" aria-expanded="false">
								카테고리
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-header">장르별</li>
								<li><a href="#">소설</a></li>
								<li><a href="#">시/에세이</a></li>
								<li><a href="#">자기계발</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">주제별</li>
								<li><a href="#">인문</a></li>
								<li><a href="#">역사/문화</a></li>
								<li><a href="#">과학</a></li>
								<li><a href="#">기술/공학</a></li>
							</ul>
						</li>
					</ul>
					
					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" placeholder="검색명" class="form-control">
						</div>
						<button type="submit" class="btn btn-primary">검색</button>
					</form>
				</div>
			</div>
		</nav>
		
		<!-- 
		<nav class="navbar navbar-default">
			<div class="container-fulid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${myContextPath}">홈으로</a>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<a href="${myContextPath}/customer/join">회원가입<span class="sr-only"></span></a>
					</li>
					<li>
						<a href="${myContextPath}/customer/login">로그인<span class="sr-only"></span></a>
					</li>
				</ul>
			</div>
		</nav>
		 -->
	</body>
</html>