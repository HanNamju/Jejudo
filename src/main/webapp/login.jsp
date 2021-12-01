<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- spring:message="메시지 키값" -->
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Random Jeju | Login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/socicon.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/iconsmind.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/interface-icons.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/lightbox.min.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/theme.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,400italic,700%7CMontserrat:400,700'
	rel='stylesheet' type='text/css'>
</head>
<body class="scroll-assist">
	<a id="top"></a>
	<div class="loader"></div>

	<!--  Header 인클루드  -->
	<jsp:include page="Header_2.jsp" />

	<div class="modal-container search-modal" data-modal-id="search-form">
		<div class="modal-content bg-white imagebg" data-width="100%"
			data-height="100%">
			<div class="pos-vertical-center clearfix">
				<div
					class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 text-center">
					
					
					<form class="clearfix" action="login.do" method="post">
						<div class="input-with-icon">
							<i class="icon-Magnifi-Glass2 icon icon--sm"></i> <input
								type="search" name="query"
								placeholder="Type your search and hit enter" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--end of modal-content-->
	</div>
	<!--end of modal-container-->
	<div class="main-container transition--fade">
		<section class="height-100 cover cover-8">
			<div class="col-md-7 col-sm-5">
				<div class="background-image-holder">
					<img alt="image" src="img/login_img.png" />
				</div>
			</div>
			<div class="col-md-5 col-sm-7 bg--white text-center">
				<div class="pos-vertical-center">
					<img class="rdjj_logo" alt="Pillar" src="img/logo_demo_dark.png"
						style="width: 200px; margin-bottom: 0;" />
					<p class="lead"></p>
					<div class="text-left">
					
					
						<form action="login.do" method="post">
							<div class="row">
								<div class="col-sm-12">
									<div class="input-with-icon">

										<i class="icon icon-Male-2"></i> <input type="text" name="mId"
											placeholder="아이디를 입력하세요." />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="input-with-icon">

										<i class="icon icon-Security-Check"></i> <input
											type="password" name="mPassword" placeholder="비밀번호를 입력하세요." />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 text-center">
									<div class="input-checkbox">
										<div class="inner"></div>
										<input type="checkbox" />
									</div>
									<span class="type--fine-print">아이디 기억하기</span>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<button type="submit" class="btn"
										style="background-color: rgba(166, 208, 205, 0.8); border-style: none;">로그인</button>
								</div>
							</div>
						
							
							<div class="row text-center">
								<p class="type--fine-print" style="text-decoration: none;">

									<a href="join.jsp" style="text-decoration: none;">회원가입</a>&emsp;&emsp;&emsp;

									<a href="findaccount.do" style="text-decoration: none;">아이디
										| 비밀번호 찾기</a>
								</p>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>


		<!-- <<<<< footer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-->
		<jsp:include page="tail.jsp" />

		<!-- <<<<< end footer end >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-->


	</div>
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/isotope.min.js"></script>
	<script src="js/ytplayer.min.js"></script>
	<script src="js/easypiechart.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/lightbox.min.js"></script>
	<script src="js/twitterfetcher.min.js"></script>
	<script src="js/smooth-scroll.min.js"></script>
	<script src="js/scrollreveal.min.js"></script>
	<script src="js/parallax.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>