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
		
		<title>서가 앤 북 - 질문게시판</title>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/questionHome.css'/>" rel="stylesheet">
		
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
						<h1 class="text-center">질문게시판</h1>
			
						<label class="text-left">게시글 수: ${totalCount}</label>
			
						<a class="btn btn-primary pull-right" href="write">글쓰기</a>
			
						<table class="table table-inverse table-striped table-hover">
							<tr>
								<th>글 번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>등록일</th>
							</tr>
							<c:forEach var="question" items="${questions}">
								<tr class="tr-content">
									<td>
										${question.questionNum}
									</td>
									<td>
										<a href="read?questionNum=${question.questionNum}">
											<c:out value="${question.title}" />
										</a>
									</td>
									<td>
										<c:out value="${question.memberName}" />
									</td>
									<td>
										${question.views}
									</td>
									<td>
										${question.indate}
									</td>
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
										<option value="title" <c:if test="${param.searchOption == 'title'}">selected</c:if>>제목</option>
										<option value="author" <c:if test="${param.searchOption == 'author'}">selected</c:if>>작성자</option>
										<option value="content" <c:if test="${param.searchOption == 'content'}">selected</c:if>>글 내용</option>
										<option value="titleAndContent" <c:if test="${param.searchOption == 'titleAndContent'}">selected</c:if>>제목+글 내용</option>
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
		<script type="text/javascript" src="<c:url value='/resources/js/questionHome.js'/>"></script>
		
	</body>
</html>






















