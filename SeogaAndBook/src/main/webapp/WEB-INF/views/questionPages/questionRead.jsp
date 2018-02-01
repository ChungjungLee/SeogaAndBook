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
		<link href="<c:url value='/resources/css/questionRead.css'/>" rel="stylesheet">
		
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
						<h1 class="text-center">글 읽기</h1>
			
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
								<td id="content">
									${question.content}
								</td>
							</tr>
							<%-- <c:if test="${attachmentList != null && attachmentListSize != 0}">
								<tr>
									<th class="info">
										파일첨부
									</th>
									<td>
										<c:forEach var="attachment" items="${attachmentList}">
												<a href="download?attachmentnum=${attachment.attachmentnum}">
													${attachment.originalfile}
												</a> <br>
										</c:forEach>
									</td>
								</tr>
							</c:if> --%>
						</table>
						<div class="text-center">
							<c:choose>
								<c:when test="${question.memberName == sessionScope.loginId}">
									<a class="btn btn-primary" href="update?questionNum=${question.questionNum}">수정</a>
									<a class="btn btn-danger" href="delete?questionNum=${question.questionNum}">삭제</a>
								</c:when>
								<c:otherwise>
									<a class="btn btn-warning" href="enterAnswer?questionNum=${question.questionNum}">답변달기</a>
								</c:otherwise>
							</c:choose>
							<a class="btn btn-default" href="home">목록보기</a>
						</div>
						
						<div class="reply-table">
							<table class="table table-condensed">
								<c:choose>
									<c:when test="${answers == null}">
										<tr>
											<td>답변이 아직 없습니다. 답변을 달아주세요!</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="answer" items="${answers}">
											<tr>
												<th>
													<c:out value="${answer.memberName}"/>
												</th>
												<td>
													<c:out value="${answer.content}"/>
												</td>
												<td class="text-center col-sm-1 " >
													<c:if test="${answer.memberName == sessionScope.loginId}">
														<a href="updateAnswer?questionNum=${question.questionNum}&answerNum=${answer.answerNum}" class="btn btn-default btn-xs">
															수정
														</a>
													</c:if>
												</td>
												<td class="text-center col-sm-1">
													<c:if test="${answer.memberName == sessionScope.loginId}">
														<a href="deleteAnswer?questionNum=${question.questionNum}&answerNum=${answer.answerNum}" class="btn btn-default btn-xs">
															삭제
														</a>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
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
		<script type="text/javascript" src="<c:url value='/resources/js/questionRead.js'/>"></script>
		
	</body>
</html>
