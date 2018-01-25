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
						<h1 class="cover-heading">회원 가입</h1>
						
						<form class="form-signin" id="signin-form" data-toggle="validator">
							
							<div class="form-group has-feedback">
								<label for="inputId" class="sr-only">아이디</label> 
								<input type="text" id="inputId" pattern="^[_A-z0-9]" 
									class="form-control" placeholder="아이디" 
									required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<span class="help-block">(*) 아이디는 영어와 숫자로만!</span>
								<div class="help-block with-errors"></div>
							</div>
							
							<div class="form-group has-feedback">
								<label for="inputPassword" class="sr-only">비밀번호</label>
								<input type="password" id="inputPassword" pattern="^[_A-z0-9]" 
									class="form-control has-warning" placeholder="비밀번호" 
									required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<span class="help-block">(*) 비밀번호는 영어와 숫자로만!</span>
								<div class="help-block with-errors"></div>
							</div>
							
							<div class="form-group has-feedback">
								<label for="inputPasswordCheck" class="sr-only">비밀번호 확인</label>
								<input type="password" id="inputPasswordCheck" class="form-control"
									placeholder="비밀번호 확인" data-match="#inputPassword" 
									data-match-error="비밀번호가 일치하지 않습니다!" required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<div class="help-block with-errors"></div>
							</div>
							
							<div class="form-group has-success has-feedback">
								<label for="inputEmail" class="sr-only">이메일</label> 
								<input type="email" id="inputEmail" class="form-control"
									placeholder="이메일 주소" data-error="잘못된 이메일 주소입니다." required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<div class="help-block with-errors"></div>
							</div>
							
							<button class="btn btn-lg btn-primary" type="submit">
								회원 가입
							</button>
							
							<a href="../" class="btn btn-lg btn-primary">
								돌아가기
							</a>
							
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
		
		
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
		
		<!-- jQuery -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js'/>"></script>
		
		<!-- Bootstrap Validator -->
		<script type="text/javascript" src="<c:url value='/resources/js/validator.min.js'/>"></script>
		
		<!-- Custom javascript -->
		<script type="text/javascript" src="<c:url value='/resources/js/memberJoin.js'/>"></script>
		
	</body>
</html>