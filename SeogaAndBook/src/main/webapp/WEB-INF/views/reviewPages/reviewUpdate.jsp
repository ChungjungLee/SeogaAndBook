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
		
		<title>서가 앤 북 - 질문게시판</title>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/reviewUpdate.css'/>" rel="stylesheet">
		
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
						
						<form class="form-signin" id="review-form" data-toggle="validator">
							<h1 class="cover-heading">서평 수정</h1>
							
							<div class="form-group">
								<label for="title" class="input-label">서평 제목</label>
								<input type="text" class="form-control" id="title"
									name="title" value="${review.title}">
							</div>
							
							<div class="form-group">
								<label for="content" class="input-label">내용</label>
								<textarea class="form-control" rows="5" id="content" name="content">${review.content}</textarea>
							</div>
							
							<div class="form-group form-btns">
								<button class="btn btn-primary" type="submit">
									서평 수정
								</button>
								<a href="read?reviewNum=${review.reviewNum}" class="btn btn-default">돌아가기</a>
								<input type="hidden" id="reviewNum" name="reviewNum" value="${review.reviewNum}">
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
		
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
		
		<!-- Bootstrap Validator -->
		<script type="text/javascript" src="<c:url value='/resources/js/validator.js'/>"></script>
		
		<!-- Custom javascript -->
		<script type="text/javascript" src="<c:url value='/resources/js/reviewUpdate.js'/>"></script>
		
	</body>
</html>