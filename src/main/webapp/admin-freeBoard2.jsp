<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="ko">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/socicon.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/iconsmind.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/interface-icons.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/lightbox.min.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/theme.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href='https://fonts.googleapis.com/css?family=Lora:400,400italic,700%7CMontserrat:400,700' rel='stylesheet' type='text/css'>
        
        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet">

    <title>Table #1</title>
    <style>
      h1,h2,h3,h4,h5,h6,p,div,li,th,tr{
                font-family: 'Noto Sans KR', sans-serif;
                    }
                    
                    p{
                    font-weight: medium;
                    }
            h5{
            font-weight: medium
            }
            
    </style>
  </head>
  <body>
  

  <div class="content">
    
    <div class="container">
    <h3>${userName }</h3>
      <h1 style="font-weight: bold;">자유게시판</h1><br>
      <div style="width: 100%; border-radius: 10px; border: 1px solid rgba(0, 0, 0, .5) ">
        <ul style="text-align: center; margin:1em; ">
          <h5>본 게시판은 누구나 자유롭게 의견을 게시할 수 있으며, 게시된 의견에 대하여는 답변을 하지 않습니다.</h5>
          <h5>시정 관련 건의사항 또는 답변을 원하는 민원사무 등은 1577-1577 를 이용하시기 바랍니다.</h5>
         
        </ul>
        
      </div>
      <div style="margin-top: 30px; " class="table-responsive card-body">
        <table id="dataTable" class="table custom-table">
          <thead>
            <tr>
              <th></th>
              <th scope="col"><p>번호</p></th>
              <th scope="col"><p>제목</p></th>
              <th scope="col"><p>글쓴이</p></th>
              <th scope="col"><p>날짜</p></th>
              <th scope="col"><p>조회 수</p></th>
              <th scope="col"><p>버튼</p></th>
              
            </tr>
          </thead>
          <tbody>
          <c:forEach var="board" items="${ boardList}">
            <tr>
              <th></th>
              
              <td><p>${board.seq}</p></td>
              <td ><a href="getBoard.do?seq=${board.seq }"><p>${board.title}</p></a></td>
              <td><p>${board.writer}</p></td>
              <td><p>${board.regDate}</p></td>
              <td><p>${board.cnt}</p></td>
              <td><a href="getBoard.do?seq=${board.seq }">
					<button  style="padding: 10px;" type="" class="btn btn-dark"
							id="btnList admin_id">&nbsp수정&nbsp</button>
							</a></td>
							
							
			</c:forEach>
           </tbody>
</table>
</div>
<div class="row">
  <div class="col-10"></div>
  <div class="col-2">
  <button style="width: 90%; font-size: 200px;" class="btn btn-primary" onclick="location.href='admin-write2.jsp?${Member.mId}'" >글 쓰기</button>
  </div>
</div>
</div> 

  </div>
 

    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap4.min.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    
 <script src="js/demo/datatables-demo.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>