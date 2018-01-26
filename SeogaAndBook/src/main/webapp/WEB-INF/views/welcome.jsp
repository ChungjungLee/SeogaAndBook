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
		
		<title>서가 앤 북 - 대문</title>
		
		<!-- Bootstrap -->
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="<c:url value='/resources/css/welcome.css'/>" rel="stylesheet">
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		
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
				
					<div class="masthead clearfix">
						<div class="inner">
							<h3 class="masthead-brand">서가 앤 북</h3>
							<nav>
								<ul class="nav masthead-nav">
									<li class="active"><a href="home">메인으로</a></li>
									<li><a href="#">서가 앤 북이란?</a></li>
									<li><a href="member/join">회원 가입</a></li>
								</ul>
							</nav>
						</div>
					</div>
					
					<div class="inner cover">
						<h1 class="cover-heading">서평을 공유해 주세요</h1>
						<h5 class="cover-heading">
							<a href="member/join">회원으로 등록</a>하시면 서가 앤 북을 이용하실 수 있습니다.
						</h5>
						
						<form class="form-signin">
							<label for="inputId" class="sr-only">아이디</label> 
							<input type="text" id="inputId" class="form-control"
								placeholder="아이디" required autofocus>
							
							<label for="inputPassword" class="sr-only">비밀번호</label>
							<input type="password" id="inputPassword" class="form-control"
								placeholder="비밀번호" required>
							
							<!-- 
							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me">
									로그인 유지
								</label>
							</div>
							 -->
							
							<button class="btn btn-lg btn-primary" type="submit">
								로그인
							</button>
							
						</form>
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
	
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
		
	</body>
</html>