<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="icon" href="<c:url value='/resources/image/favicon.ico'/>">
		
		<title>서가 앤 북</title>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/home.css'/>" rel="stylesheet">
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		
		<header>
			<jsp:include page="commonPages/headerNav.jsp" />
			<jsp:include page="commonPages/topBanner.jsp" />
		</header>
		
		<div class="container top-container">
			<h1>서평</h1>
			<div class="row">
				<c:forEach var="review" items="${reviews}">
					<div class="col-sm-3">
						<h3>${review.title }</h3>
						<p>
							${review.content}
						</p>
					</div>
				</c:forEach>
			</div>
			
			<hr>
			
			<h1>책</h1>
			<div class="row">
				<c:forEach var="book" items="${books}">
					<div class="col-sm-3">
						<h3>${book.title}</h3>
						<p>
							${book.introduction}
						</p>
					</div>
				</c:forEach>
			</div>
			
			<hr>
			
			<h1>질문</h1>
			<div class="row">
				<c:forEach var="question" items="${questions}">
					<div class="col-sm-3">
						<h3>${question.title}</h3>
						<p>
							${question.content}
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="mastfoot">
			<p>
				Constructed by 
				<a href="https://github.com/chunglee-test/SeogaAndBook">Chungjung Lee</a><br>
				Cover template for <a href="http://getbootstrap.com">Bootstrap</a>,
				by <a href="https://twitter.com/mdo">@mdo</a>.
			</p>
		</div>
		
		
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
		
	</body>
</html>
























