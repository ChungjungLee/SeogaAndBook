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
		<link href="<c:url value='/resources/css/reviewRead.css'/>" rel="stylesheet">
		
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
						<h1 class="text-center">서평 읽기</h1>
						<table class="table">
							<tr>
								<th>
									ISBN13
								</th>
								<td>
									${review.isbn13}
								</td>
							</tr>
							<tr>
								<th>
									책 제목
								</th>
								<td>
									<c:out value="${review.bookTitle}" />
								</td>
							</tr>
							<tr>
								<th>
									작가
								</th>
								<td>
									<c:out value="${review.authorName}" />
								</td>
							</tr>
							<tr>
								<th>
									출판사
								</th>
								<td>
									<c:out value="${review.publisherName}" />
								</td>
							</tr>
							<tr>
								<th>
									서평 작성자
								</th>
								<td>
									<c:out value="${review.memberName}" />
								</td>
							</tr>
							<tr>
								<th>
									서평 제목
								</th>
								<td>
									<c:out value="${review.title}" />
								</td>
							</tr>
							<tr>
								<th>
									작성일
								</th>
								<td>
									${review.indate}
								</td>
							</tr>
							<tr>
								<th>
									조회수
								</th>
								<td>
									${review.views}
								</td>
							</tr>
							<tr>
								<th>
									서평 내용
								</th>
								<td id="content">
									${review.content}
								</td>
							</tr>
						</table>
						<div class="text-center">
							<c:choose>
								<c:when test="${review.memberName == sessionScope.loginId}">
									<a class="btn btn-primary" href="update?reviewNum=${review.reviewNum}">수정</a>
									<a class="btn btn-danger" href="delete?reviewNum=${review.reviewNum}">삭제</a>
								</c:when>
							</c:choose>
							<a class="btn btn-default" href="home">목록보기</a>
						</div>
						
					</div> <!-- inner cover -->
					
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
		
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
		
		<!-- Bootstrap Validator -->
		<script type="text/javascript" src="<c:url value='/resources/js/validator.js'/>"></script>
		
		<!-- Custom javascript -->
		<script type="text/javascript" src="<c:url value='/resources/js/reviewRead.js'/>"></script>
		
	</body>
</html>
