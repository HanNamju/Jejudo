<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>ReviewWrite</title>
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
         <link href="css/dataTables.bootstrap4.hyun.css" rel="stylesheet">
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
    <body class="scroll-assist">
        <a id="top"></a>
        <div class="loader"></div>
     
        <!-- nav -->
        <!--end of modal-container-->
       
        <div class="main-container transition--fade" style="display:flex; justify-content: space-around;"  >
            <section class="col-md-10"> 
                    <h1 style="font-weight: bold;">자유게시판</h1>
                    <hr>
                    <h5>작성자${board.writer}날짜 ${board.regDate}조회수${board.cnt}</h5>
                    <hr>
					<div style="display: flex; justify-content: flex-end;">
					<div><a class="btn" href="/updateBoard.do?seq=${board.seq}">수정</a></div>
					<div><a class="btn" href="/deleteBoard.do?seq=${board.seq}">삭제</a></div>
					</div>

                    <div style="border-radius: 10px; padding: 15%; border: 1px solid rgba(0, 0, 0, .2);">
					<img src="upload/${fileList.originalFileName}">
					<br>
					${board.content}
                        
                    </div>
                    <!--end of row-->
                    
                    <div class="row">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>댓글</th>
                                        </tr>
                                    </thead>

                                    <tfoot>
                                        <tr>
                                            
                                            <th></th>
                                        </tr>
                                    </tfoot>
                                    <!--여기부터 1 찍어야함 위에는 바닥부분 설정-->
                                    <tbody>
                                    	<c:forEach var="member" items="${MemberList }" varStatus="status">
                                        <tr>
                                            <th>댓글<br><br>  </th>
                                        </tr>
                                       
                                        </c:forEach>
                                        
                                         
                                        
                                       
                                    </tbody>
                                </table>

                            </div>
                            
                        </div>
                        </div>
                            <!--end of blog comments-->
                            
                            <form class="item__addtocart">
                                <div style="padding-bottom: 20px; padding-top: 30px;">
                                    <span>댓글란</span>
                                </div>
                                <textarea type="text" name="quantity" placeholder="로그인 후 댓글을 남기실 수 있습니다." 
                                style="resize: none; height: 180px; border-radius: 0%; width: 70%;"  ></textarea>
                                <div class="row"></div> 
                                <div class="col-md-7"></div>
                                <div class="col-md-2"><button style="text-align: center; margin-top: -22px; width: 75%;" type="submit" class="btn btn--primary">저장</button>
                                </div>
                                <div class="col-md-4">
                                </div>    
                            </form>
                            
                        </div>
                    </div>
                    <div></div>
                    <hr>
                    <div></div>
                    <div class="pagination-container">
                        <ul class="pagination">
                            <li>
                                <a href="#">
                                    <span>&larr;</span>
                                </a>
                            </li>
                            <li class="active">
                                <a href="#">1</a>
                            </li>
                            <li>
                                <a href="#">2</a>
                            </li>
                            <li>
                                <a href="#">3</a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>&rarr;</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--end of container-->
                
            </section>
            
          <!-- footer -->

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