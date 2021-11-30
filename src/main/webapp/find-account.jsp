<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>Random Jeju | Find Account</title>
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
    </head>
    <body class="scroll-assist">
        <a id="top"></a>
        <div class="loader"></div>
        
        <!--  Header 인클루드  -->

	<jsp:include page="Header_2.jsp" />
       
<!-- <<<<< 아이디 / 비밀번호 찾기 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  -->
<section class="masonry-contained">
    <div class="container">
        <div class="row">
            <div class="masonry">
                <div class="masonry__filters text-center" data-filter-all-text=""></div>
                <div class="masonry__container masonry--animate">


                    <div class="col-sm-12 masonry__item" data-masonry-filter="아이디 찾기">
                        
                            <div class="card card--horizontal card-3">
                                <div class="card__image col-sm-3 col-md-4">
                                    <div class="background-image-holder">
                                        <img alt="Pic" src="img/pch_img_3.jpg" />
                                    </div>
                                </div>
                                <div class="card__body col-sm-9 col-md-8 boxed boxed--lg bg--white">
                                    <div class="card__title">
                                     <!-- form 영역-->   
                                     <form action="findId.do" method="post" name="idfindform" >
                                        <div class="row">

                                            <div class="col-sm-12" style="margin-bottom: 80px; text-align: center;">                                                                                                   
                                                <h2 style="color: rgba(130, 127, 123, 0.8) ;">아이디 찾기</h2>
                                            </div>

                                            <div class="col-sm-12" style="margin-bottom: 40px;">
                                                <div class="input-with-icon">  
                                                    <input type="text" name="mName" placeholder="이름을 입력하세요." />
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-sm-12"style="margin-bottom: 40px;">
                                                <div class="input-with-icon"> 
                                                    <input type="text" name="mEmail" placeholder="email을 입력하세요" />
                                                </div>
                                            </div>
                                        </div>  
                                        
                                        <div class="row">
                                            <div class="col-sm-12"style="margin-bottom: 80px;">
                                                <div class="input-with-icon">    
                                                    <input type="password" name="mPassword" placeholder="비밀번호를 입력하세요." />
                                                </div>
                                            </div>
                                        </div>  
                                                                          
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <button type="submit" class="btn" style="background-color: rgba(166, 208, 205, 0.8); border-style: none;"><span style="color: white; font-size: 20px;">아이디 찾기</span></button>
                                            </div>
                                        </div>
                                        
                                        <!-- 이름과 전화번호가 일치하지 않을 때-->
										<c:if test="${check == 1}">
											<script>
												opener.document.idfindform.mName.value = "";
												opener.document.idfindform.mPassword.value = "";
											</script>
											<label>일치하는 정보가 존재하지 않습니다.</label>
										</c:if>								
										<!-- 이름과 비밀번호가 일치하지 않을 때 -->
										<c:if test="${check == 0 }">
										<label>찾으시는 아이디는' ${id}' 입니다.</label>									
										</c:if>
                                       
                                    </form>
                                     
                                     <!-- end form 영역 end-->
                                    </div>
                                  
                                </div>
                            </div>
                        
                    </div>
                  
                    <!--end item-->
                    <div class="col-sm-12 masonry__item" data-masonry-filter="비밀번호 찾기">
                        
                            <div class="card card--horizontal card-3">
                                <div class="card__image col-sm-3 col-md-4">
                                    <div class="background-image-holder">
                                        <img alt="Pic" src="img/pch_img_4.jpg" />
                                    </div>
                                </div>
                                <div class="card__body col-sm-9 col-md-8 boxed boxed--lg bg--white">
                                    <div class="card__title">

                                       

                                     <!-- form 영역-->   
                                     <form action="findPWD.do" method="post" name="pwdfindform">
                                        <div class="row">

                                            <div class="col-sm-12" style="margin-bottom: 80px; text-align: center;">                                                                                                   
                                                <h2 style="color: rgba(130, 127, 123, 0.8) ;">비밀번호 찾기</h2>
                                            </div>

                                            <div class="col-sm-12" style="margin-bottom: 40px;">
                                                <div class="input-with-icon">                                                    
                                                    <i class="icon icon-Male-2"></i>
                                                    <input type="text" name="mId" placeholder="아이디를 입력하세요." />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="input-with-icon" style="margin-bottom: 40px;">                                                    
                                                    <i class="icon icon-Security-Check"></i>
                                                    <input type="text" name="mName" placeholder="이름을 입력하세요." />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="input-with-icon" style="margin-bottom: 40px;">                                                    
                                                    <i class="icon icon-Security-Check"></i>
                                                    <input type="text" name="mEmail" placeholder="이메일을 입력하세요." />
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            
                                            <div class="col-sm-6">
                                                <button type="submit" id="findPwd" class="btn" onclick="tmpConsole()" style="background-color: rgba(166, 208, 205, 0.8); border-style: none;"><span style="color: white; font-size: 20px;">비밀번호 찾기</span></button>
                                            </div>
                                            
                                        </div>
                                        
                                        <!-- 아이디 이름과 이메일 이 같지 않을때-->
										<c:if test="${check == 3}">
											<!--  <script>
												opener.document.pwdfindform.mId.value = "";
												opener.document.pwdfindform.mName.value = "";
												opener.document.pwdfindform.mEmail.value = "";
											</script>-->
											<label>일치하는 정보가 존재하지 않습니다.</label>
										</c:if>								
										<!-- 이름과 비밀번호가 일치하지 않을 때 -->
										<c:if test="${check == 4 }">										
										<!-- <label>입력하신 email로 비밀번호가 전송 되었습니다.</label>	-->							
										</c:if>
                                        
                                    </form>
                                     
                                     <!-- end form 영역 end-->
                                    </div>
                                    
                                </div>
                            </div>
                        
                    </div>
                    <!--end item-->
                </div>
                <!--end masonry container-->
            </div>
        </div>
        <!--end of row-->
    </div>
    <!--end of container-->
</section>

<!-- <<<<< footer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-->
	<jsp:include page="tail.jsp" />

<!-- <<<<< end footer end >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-->

<!-- <<<<< end 아이디 / 비밀번호 찾기 end >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  -->             
            
<!-- <<<<< footer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-->

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