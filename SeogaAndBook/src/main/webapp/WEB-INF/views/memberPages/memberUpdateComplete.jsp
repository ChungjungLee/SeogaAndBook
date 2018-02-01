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
		
		<title>서가 앤 북 - 회원가입</title>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/memberJoin.css'/>" rel="stylesheet">
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		
	</head>
	<body>
		
		<div class="site-wrapper">
			<div class="site-wrapper-inner">
				<div class="cover-container">
					<div class="inner cover">
						<h1 class="cover-heading">회원 수정이 완료되었습니다.</h1>
						
						<a href="../home" class="btn btn-lg btn-primary">
							돌아가기
						</a>
					</div>
					
					<div class="mastfoot">
						<div class="inner">
							<p>
								Constructed by 
								<a href="https://github.com/chunglee-test/SeogaAndBook">Chungjung Lee</a> 
							</p>
							<p>
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
		<script type="text/javascript" src="<c:url value='/resources/js/memberJoin.js'/>"></script>
		
	</body>
</html>