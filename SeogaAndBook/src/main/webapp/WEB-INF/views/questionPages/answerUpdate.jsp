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
		<link href="<c:url value='/resources/css/answerWrite.css'/>" rel="stylesheet">
		
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
						<h1 class="cover-heading">답변 글 수정</h1>
						
						<h5>질문</h5>
						<table class="table">
							<tr>
								<th>
									작성자
								</th>
								<td>
									<c:out value="${question.memberName}" />
								</td>
							</tr>
							<tr>
								<th>
									작성일
								</th>
								<td>
									${question.indate}
								</td>
							</tr>
							<tr>
								<th>
									조회수
								</th>
								<td>
									${question.views}
								</td>
							</tr>
							<tr>
								<th>
									제목
								</th>
								<td>
									<c:out value="${question.title}" />
								</td>
							</tr>
							<tr>
								<th>
									내용
								</th>
								<td>
									<c:out value="${question.content}" />
								</td>
							</tr>
						</table>
							
						<form class="form-signin" id="answer-form" data-toggle="validator">
							<div class="form-group has-feedback">
								<label for="inputContent" class="input-label">답변 내용</label> 
								<textarea class="form-control" rows=7 id="inputContent" name="content" 
									required>${answer.content}</textarea>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
							</div>
							
							<div class="form-group form-btn">
								<input type="hidden" name="answerNum" value="${answer.answerNum}">
								<input type="hidden" name="memberNum" value="${answer.memberNum}">
								<input type="hidden" name="questionNum" value="${question.questionNum}">
								<button class="btn btn-primary" type="submit">
									답변 수정
								</button>
								<a href="read?questionNum=${question.questionNum}" 
									class="btn btn-default">돌아가기</a>
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
		<script type="text/javascript" src="<c:url value='/resources/js/answerUpdate.js'/>"></script>
		
	</body>
</html>


























