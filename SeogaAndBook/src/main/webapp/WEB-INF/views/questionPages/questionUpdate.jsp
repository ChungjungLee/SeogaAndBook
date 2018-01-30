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
		<link href="<c:url value='/resources/css/questionUpdate.css'/>" rel="stylesheet">
		
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
						<form class="form-signin" id="question-form" data-toggle="validator" 
							enctype="multipart/form-data">
							<h1 class="cover-heading">질문 글 수정</h1>
							
							<div class="form-group">
								<label for="title" class="input-label">글 제목</label>
								<input type="text" class="form-control" id="title" 
									value="${board.title}">
							</div>
							
							<div class="form-group">
								<label for="context" class="input-label">내용</label>
								<textarea class="form-control" rows="5" id="context">${board.content}</textarea>
							</div>
							
							파일 
							<%-- 
							<c:forEach var="attachment" items="${attachmentList}">
								<div id="file_${attachment.attachmentnum}" class="file">
									<input type="text" id="file_name_${attachment.attachmentnum}"
											class="file_name" value="${attachment.originalfile}" readonly>
								
									<div class="file_input_div">
										<input type="button" class="file_input_button" value="파일 변경"/>
										<input type="file" class="file_input_hidden" name="uploads"
												onchange="javascript:fileEdit(${attachment.attachmentnum}, this.value)" />
									</div>
									
									<input type="button" value="파일 삭제" onclick="javascript:fileDelete(${attachment.attachmentnum})">
									<br>
								</div>
								
								<input type="hidden" name="attachmentnums" value="${attachment.attachmentnum }">
							</c:forEach> --%>
							<!-- <input type="button" value="파일 추가" onclick="javascript:fileAdd()"> -->
							
							<hr>
							<input type="submit" value="글 수정" formaction="update">
							<input type="hidden" id="boardnum" name="boardnum" value="${board.boardnum}">
							<input type="hidden" id="deletenums" name="deletenums" value="">
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
		<script type="text/javascript" src="<c:url value='/resources/js/questionUpdate.js'/>"></script>
		
	</body>
</html>