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
					<a class="navbar-brand" href="${myContextPath}">서가 앤 북</a>
				</div>
				
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						
						<li id="headerNav-book"><a href="${myContextPath}/book/home">도서</a></li>
						<li id="headerNav-review"><a href="${myContextPath}/review/home">서평</a></li>
						<li id="headerNav-question"><a href="${myContextPath}/question/home">질문</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" 
								role="button" aria-expanded="false">
								카테고리
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-header"><a href="${myContextPath}/book/home?cateNum=1">문학</a></li>
								<li><a href="${myContextPath}/book/home?cateNum=3">시</a></li>
								<li><a href="${myContextPath}/book/home?cateNum=4">소설</a></li>
								<li class="divider"></li>
								<li class="dropdown-header"><a href="${myContextPath}/book/home?cateNum=2">비문학</a></li>
								<li><a href="${myContextPath}/book/home?cateNum=5">수필</a></li>
								<li><a href="${myContextPath}/book/home?cateNum=6">에세이</a></li>
							</ul>
							<%-- <ul class="dropdown-menu" role="menu">
								<li class="dropdown-header">분류</li>
								<li><a href="${myContextPath}/book/home?searchOption=author">작가별</a></li>
								<li><a href="${myContextPath}/book/home?searchOption=publisher">출판사별</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">장르별</li>
								<li class="dropdown-header"><a href="${myContextPath}/book/home?searchOption=category&cateNum=1">문학</a></li>
								<li><a href="${myContextPath}/book/home?searchOption=category&cateNum=3">시</a></li>
								<li><a href="${myContextPath}/book/home?searchOption=category&cateNum=4">소설</a></li>
								<li class="dropdown-header"><a href="${myContextPath}/book/home?searchOption=category&cateNum=2">비문학</a></li>
								<li><a href="${myContextPath}/book/home?searchOption=category&cateNum=5">수필</a></li>
								<li><a href="${myContextPath}/book/home?searchOption=category&cateNum=6">에세이</a></li>
							</ul> --%>
						</li>
					</ul>
					
					<!-- <form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" placeholder="검색명" class="form-control">
						</div>
						<button type="submit" class="btn btn-primary">검색</button>
					</form> -->
				</div>
			</div>
		</nav>
		
	</body>
</html>