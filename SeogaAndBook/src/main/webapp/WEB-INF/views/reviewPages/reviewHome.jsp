<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="icon" href="<c:url value='/resources/image/favicon.ico'/>">
		
		<title>서가 앤 북 - 서평게시판</title>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/reviewHome.css'/>" rel="stylesheet">
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<header>
			<jsp:include page="../commonPages/headerNav.jsp" />
			<jsp:include page="../commonPages/topBanner.jsp" />
		</header>
		
		<div class="site-wrapper">
			<div class="site-wrapper-inner">
				<div class="cover-container">
					<div class="inner cover">
						<h1 class="text-center">서평게시판</h1>
			
						<label class="text-left">게시글 수: ${totalCount}</label>
			
						<a class="btn btn-primary pull-right" href="write">서평작성</a>
			
						<table class="table table-inverse table-striped table-hover">
							<tr>
								<th rowspan=2>글 번호</th>
								<th>작성자</th>
								<th>서평제목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
							<tr>
								<th>ISBN13</th>
								<th>책 제목</th>
								<th>작가</th>
								<th>출판사</th>
							</tr>
							<c:forEach var="review" items="${reviews}">
								<tr class="tr-content">
									<th rowspan=2>${review.reviewNum}</th>
									<th><c:out value="${review.memberName}" /></th>
									<th><a href="read?reviewNum=${review.reviewNum}"><c:out value="${review.title}" /></a></th>
									<th>${review.indate}</th>
									<th>${review.views}</th>
								</tr>
								<tr>
									<th>${review.isbn13}</th>
									<th><c:out value="${review.bookTitle}" /></th>
									<th><c:out value="${review.authorName}" /></th>
									<th><c:out value="${review.publisherName}" /></th>
								</tr>
							</c:forEach>
						</table>
						
						<nav class="paging-bar" aria-label="Page navigation">
							<ul class="pagination">
								<c:if test="${navi.startPageGroup > 1}">
									<li>
										<a href="javascript:search(${navi.startPageGroup - 1})">이전 </a>
									</li>
								</c:if>
								<c:forEach var="p" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
									<c:choose>
										<c:when test="${currentPage == p}">
											<li class="active">
												<span>${p}</span>
											</li>
										</c:when>
										<c:otherwise>
											<li>
												<a href="javascript:search(${p})"><span>${p}</span></a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${navi.endPageGroup < navi.totalPageCount}">
									<li>
										<a href="javascript:search(${navi.endPageGroup + 1})">다음 </a>
									</li>
								</c:if>
							</ul>
						</nav>
						
						<div class="searchbar">
							<!-- 이 폼은 get 방식을 이용 -->
							<form id="searchForm" action="home" method="GET">
								<div class="form-inline">
									<select class="form-control" name="searchOption">
										<option value="title" <c:if test="${param.searchOption == 'title'}">selected</c:if>>책</option>
										<option value="author" <c:if test="${param.searchOption == 'author'}">selected</c:if>>작성자</option>
									</select>
									<input type="text" class="form-control" name="searchText" value="${param.searchText}"> 
									
									<input type="button" id="search-btn" class="btn btn-default" value="검색">
									<input type="hidden" id="pageNum" name="pageNum">
								</div>
							</form>
						</div>
						
						<div class="mastfoot">
							<div class="inner">
								<p>
									Constructed by 
									<a href="https://github.com/chunglee-test/SeogaAndBook">Chungjung Lee</a><br>
									Cover template for <a href="http://getbootstrap.com">Bootstrap</a>,
									by <a href="https://twitter.com/mdo">@mdo</a>.
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
		
		<!-- Custom javascript -->
		<script type="text/javascript" src="<c:url value='/resources/js/reviewHome.js'/>"></script>
		
	</body>
</html>






















