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
		
		<title>서가 앤 북 - 책 등록</title>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/bookEnter.css'/>" rel="stylesheet">
		
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
						<h1 class="cover-heading">도서 등록</h1>
						
						<a href="../author/enter" class="btn btn-sm btn-primary">
							작가 등록
						</a>
						<a href="../publish/enter" class="btn btn-sm btn-primary">
							출판사 등록
						</a>
						
						<form class="form-signin" id="book-form" data-toggle="validator">
							<div class="form-group has-feedback">
								<label for="inputIsbn13" class="sr-only">ISBN13</label> 
								<input type="text" id="inputIsbn13" name="isbn13" data-remote="checkIsbn13Duplicate"
									class="form-control" placeholder="ISBN13" pattern="^[0-9]{13}$"
									required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<div id="help-block-id" class="help-block with-errors"></div>
							</div>
							
							<div class="form-group has-feedback">
								<label for="inputTitle" class="sr-only">제목</label>
								<input type="text" id="inputTitle" name="title" 
									class="form-control" placeholder="제목" 
									required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<div class="help-block with-errors"></div>
							</div>
							
							<div class="form-group has-feedback">
								<label for="inputIntro" class="sr-only">소개</label>
								<input type="text" id="inputIntro" name="introduction" 
									class="form-control" placeholder="소개" 
									required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<div class="help-block with-errors"></div>
							</div>
							
							<div class="form-group has-feedback">
								<label for="category-selection" class="sr-only">카테고리</label>
								<select class="form-control" id="category-selection" name="categoryNum" required>
									<option selected disabled>카테고리 선택</option>
									<c:choose>
										<c:when test="${categories.size() == 0}">
											<option disabled>카테고리 정보가 없습니다. 등록 먼저!</option>
										</c:when>
										<c:otherwise>
											<c:forEach var="category" items="${categories}">
												<option value="${category.categoryNum}" 
													<c:if test="${category.parentNum == 0}">disabled</c:if>>
													${category.name}
												</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							
							<div class="form-group has-feedback">
								<label for="publisher-selection" class="sr-only">출판사</label>
								<select class="form-control" id="publisher-selection" name="publisherNum" required>
									<option selected disabled>출판사 선택</option>
									<c:choose>
										<c:when test="${publishers.size() == 0}">
											<option disabled>출판사 정보가 없습니다. 등록 먼저!</option>
										</c:when>
										<c:otherwise>
											<c:forEach var="publisher" items="${publishers}">
												<option value="${publisher.publisherNum}">
													${publisher.name}
												</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							
							<div class="form-group has-feedback">
								<label for="publisher-selection" class="sr-only">작가</label>
								<select class="form-control" id="author-selection" name="authorNum" required>
									<option selected disabled>작가 선택</option>
									<c:choose>
										<c:when test="${authors.size() == 0}">
											<option disabled>작가 정보가 없습니다. 등록 먼저!</option>
										</c:when>
										<c:otherwise>
											<c:forEach var="author" items="${authors}">
												<option value="${author.authorNum}">
													${author.name}
												</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							
							<div class="form-group">
								<button class="btn btn-lg btn-primary" type="submit">
									도서 등록
								</button>
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
		<script type="text/javascript" src="<c:url value='/resources/js/bookEnter.js'/>"></script>
		
	</body>
</html>






























