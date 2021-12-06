<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>관리자 | 카테고리 리스트</title>
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

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="css/dataTables.bootstrap4.min.css" rel="stylesheet">
<style>
a {
	color: black;
}

.switch {
	position: relative;
	display: inline-block;
	width: 60px;
	height: 34px;
}

/* Hide default HTML checkbox */
.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

/* The slider */
.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 26px;
	width: 26px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196F3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}
/*dele-btn*/
#dele-btn {
	padding: 0.3rem 1rem;
	background-color: #ccc;
	text-align: center;
	margin-top: 0.4rem;
}

#dele-btn {
	margin-left: 0.4rem;
}

#dele-btn:hover {
	background-color: #d4a451;
	transition: 0.7s;
}
/* Rounded sliders */
.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}

/* check button start 체크버튼 옵션*/
input[type="checkbox"] {
	display: none;
}

.label__on-off {
	overflow: hidden;
	position: relative;
	display: inline-block;
	width: 58px;
	height: 26px;
	-webkit-border-radius: 13px;
	-moz-border-radius: 13px;
	border-radius: 13px;
	background-color: #0bba82;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	-webkit-transition: all .3s;
	-moz-transition: all .3s;
	-ms-transition: all .3s;
	-o-transition: all .3s;
	transition: all .3s;
}

.label__on-off>* {
	vertical-align: middle;
	-webkit-transition: all .3s;
	-moz-transition: all .3s;
	-ms-transition: all .3s;
	-o-transition: all .3s;
	transition: all .3s;
	font-size: 14px;
}

.label__on-off .marble {
	position: absolute;
	top: 1px;
	left: 1px;
	display: block;
	width: 24px;
	height: 24px;
	background-color: #fff;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	-webkit-box-shadow: 0 0 10px rgba(0, 0, 0, .3);
	-moz-box-shadow: 0 0 10px rgba(0, 0, 0, .3);
	box-shadow: 0 0 10px rgba(0, 0, 0, .3);
}

.label__on-off .on {
	display: none;
	padding-left: 12px;
}

.label__on-off .off {
	padding-left: 30px;
	line-height: 25px;
}

.input__on-off:checked+.label__on-off {
	background-color: #ed4956;
}

.input__on-off:checked+.label__on-off .on {
	display: inline-block;
}

.input__on-off:checked+.label__on-off .off {
	display: none;
}

.input__on-off:checked+.label__on-off .marble {
	left: 33px;
}

/* check button end*/
</style>

</head>
<body class="scroll-assist">


	<section>
		<div style="margin-left: 0px;"
			class="col-md-3 col-md-offset-1 hidden-sm hidden-xs">
			<div class="sidebar">
				<div class="sidebar__widget">
					<h6>Search Site</h6>
					<hr>
					<form method="post">
						<div class="input-with-icon">
							<i class="icon-Magnifi-Glass2"></i> <input type="search"
								placeholder="Type Here" />
						</div>
					</form>
				</div>
				<!--end widget-->

				<div class="sidebar__widget">
					<h6>Categories</h6>
					<ul class="link-list">
						<li><a href="#"> 설정 </a></li>
						<li><a href="getMemberList.do"> 회원관리 </a></li>
						<li><a href="getPlaceAllList.do"> 장소관리 </a></li>
					</ul>
					<hr>

				</div>
				<!--end widget-->
				<div class="sidebar__widget">
					<h6>Tags</h6>
					<hr>
					<ul class="tag-cloud">
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Business </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Tourism </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Life </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Startup </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Design </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Tech </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Style </span>
						</a></li>
						<li><a href="#" class="btn btn--sm btn--square"> <span
								class="btn__text"> Environment </span>
						</a></li>
					</ul>
				</div>
				<!--end widget-->
				<div class="sidebar__widget">
					<h6>About Us</h6>
					<hr>
					<p>We're a digital focussed collective working with individuals
						and businesses to establish rich, engaging online presences.</p>
				</div>
				<!--end widget-->
			</div>
		</div>
		<!--여기서부터 목록 start-->
		<!-- Begin Page Content -->
		<div style="margin-left: -40px;" class="container-fluid">

			<!-- Page Heading -->
			<h1 class="h3 mb-2 text-gray-800">장소 관리 페이지</h1>
			</p>
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<div class="card-header py-3"
						style="display: flex; justify-content: space-between;">
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false" style="backgroundcolor: white">
								장소</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item"
									href="getPlaceList.do?pCategory=cafe">카페</a></li>
								<li><a class="dropdown-item"
									href="getPlaceList.do?pCategory=tourlist">관광지</a></li>
								<li><a class="dropdown-item"
									href="getPlaceList.do?pCategory=restaurant">음식점</a></li>
								<li><a class="dropdown-item"
									href="getPlaceList.do?pCategory=rooms">숙소</a></li>
							</ul>
						</div>

						<div>
							<h2 class="m-0 font-weight-bold"
								style="color: rgba(0, 0, 0, .6);"></h2>
						</div>


						<div style="text-align: right; margin-right: 80px;">
							<a href="admin-CafeEnrollment.jsp"><img
								src="img/등록하기-배경제거.png" alt=""
								style="width: 200px; height: 100px;"></a>
						</div>

					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>방향</th>
										<th>이름</th>
										<th>주소</th>
										<th>전화번호</th>
										<th>정보</th>
										<th>관리자권한</th>
									</tr>
								</thead>

								<tfoot>
									<tr>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</tfoot>
								<!--여기부터 1 찍어야함 위에는 바닥부분 설정-->
								<tbody>
									<c:forEach var="List" items="${ placeList}">
										<tr>
											<th>${List.pArea}</th>
											<th>${List.pName}</th>
											<th>${List.pAddress}</th>
											<th>${List.pTell}</th>
											<th>${List.pInfo}</th>
											<th>
												<div style="display: flex;">

													<div>
														<input id="dele-btn"
															onclick="location.href='getPlace.do?pSeq=${List.pSeq }'"
															type="submit" class="btn btn-primary" value="수정">
													</div>
												</div>
											</th>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
	</section>
	<footer class="bg--dark footer-4">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-4">
					<img alt="logo" class="logo" src="img/logo-light.png" />
					<p>
						<em>Digital Design Melbourne</em>
					</p>
					<ul class="footer__navigation">
						<li><a href="#"> <span>About Us</span>
						</a></li>
						<li><a href="#"> <span>Services</span>
						</a></li>
						<li><a href="#"> <span>Selected Work</span>
						</a></li>
						<li><a href="#"> <span>Get In Touch</span>
						</a></li>
						<li><a href="#"> <span>Careers</span>
						</a></li>
					</ul>
				</div>
				<div class="col-md-4 col-sm-8">
					<h6>Recent News</h6>
					<div class="twitter-feed">
						<div class="tweets-feed" data-feed-name="mrareweb" data-amount="2"></div>
					</div>
				</div>
				<div class="col-md-4 col-md-offset-1 col-sm-12">
					<h6>Subscribe</h6>
					<p>Get monthly updates and free resources.</p>
					<form class="form--merge form--no-labels"
						action="http://mrareco.createsend.com/t/d/s/kieth/" method="post"
						id="subForm" data-error="Please fill all fields correctly."
						data-success="Thanks for signing up! Please check your inbox for confirmation email.">
						<p>
							<label for="fieldEmail">Email Address</label> <br /> <input
								class="col-md-8 col-sm-6 validate-required validate-email"
								id="fieldEmail" name="cm-kieth-kieth" type="email" required />
						</p>
						<p>
							<button type="submit">Go</button>
						</p>
					</form>
					<h6>Connect with Us</h6>
					<ul class="social-list">
						<li><a href="#"> <i class="socicon-twitter"></i>
						</a></li>
						<li><a href="#"> <i class="socicon-dribbble"></i>
						</a></li>
						<li><a href="#"> <i class="socicon-vimeo"></i>
						</a></li>
						<li><a href="#"> <i class="socicon-instagram"></i>
						</a></li>
						<li><a href="#"> <i class="socicon-spotify"></i>
						</a></li>
						<li><a href="#"> <i class="socicon-behance"></i>
						</a></li>
					</ul>
				</div>
			</div>
			<!--end of row-->
		</div>
		<!--end of container-->
		<div class="footer__lower">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 text-center-xs">
						<span class="type--fine-print">&copy; Copyright <span
							class="update-year">2016</span> Medium Rare - All Rights Reserved
						</span>
					</div>
					<div class="col-sm-6 text-right text-center-xs">
						<a href="#top" class="inner-link top-link"> <i
							class="interface-up-open-big"></i>
						</a>
					</div>
				</div>
				<!--end of row-->
			</div>
			<!--end of container-->
		</div>
	</footer>
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
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>
</body>
</html>