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
		<link href="<c:url value='/resources/css/reviewWrite.css'/>" rel="stylesheet">
		
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
							<h1 class="cover-heading">서평 작성</h1>
							
							<div class="form-group has-feedback">
								<label for="publisher-selection" class="sr-only">책</label>
								<select class="form-control" id="book-selection" name="isbn13" required>
									<option selected disabled>책 선택</option>
									<c:choose>
										<c:when test="${books.size() == 0}">
											<option disabled>책 정보가 없습니다. 등록 먼저!</option>
										</c:when>
										<c:otherwise>
											<c:forEach var="book" items="${books}">
												<option value="${book.isbn13}">
													${book.title}
												</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							
							<div class="form-group has-feedback">
								<label id="label-title" for="inputTitle" class="input-label">글 제목</label> 
								<input type="text" id="inputTitle" name="title"
									class="form-control" required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
							</div>
							
							<div class="form-group has-feedback">
								<label for="inputContent" class="input-label">내용</label> 
								<textarea class="form-control" rows=7 id="inputContent" name="content" 
									required></textarea>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
							</div>
							
							<div class="form-group btns">
								<button class="btn btn-primary" type="submit">
									서평 등록
								</button>
								<a href="../home" class="btn btn-default">돌아가기</a>
							</div>
							
						</form>
					</div>
					
					<div class="mastfoot">
						<div class="inner">
							<span id="test"></span>
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
		<script type="text/javascript" src="<c:url value='/resources/js/reviewWrite.js'/>"></script>
		
	</body>
</html>


























