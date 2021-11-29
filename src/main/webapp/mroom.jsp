<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- spring:message="메시지 키값" -->
<!doctype html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>Random Jeju | Create Room</title>
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
        <script src="js/datepicker-ko.js"></script>
    </head>

    <style>
        .btn_count {
            box-sizing: border-box;
            border-style: none;
            width: 30px;
            height: 30px;
            background-color: rgba(266, 88, 61, 0.9);
            border-radius: 10px;
        }
        

		@import
			url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap')
			;
		
		P, h1, h2, h3, h4, h5, h6, div, a, i {
			font-family: 'Noto Sans KR', sans-serif;
		}

    </style>
    <body class="scroll-assist">
        <a id="top"></a>
        <div class="loader"></div>    
        
        <!--  Header 인클루드  -->
		<jsp:include page="Header.jsp" />   

        <!--end of modal-container-->
        <div class="main-container transition--fade" style="height: auto;">
            <section class="cover cover-12 form--dark imagebg height-100 parallax" data-overlay="4" style="height: auto;">
                <div class="background-image-holder">
                    <img alt="image" src="img/제주028.jpg" />
                </div>
                <div class="container pos-vertical-center text-center-xs" style="top: 500px; grid-row-gap: 20px ;">
                    <div class="row pos-vertical-align-columns" >
             
                        <div class="col-md-10 col-sm-10" >
                            <div class="form-subscribe-1 boxed boxed--lg bg--white text-center box-shadow-wide" style="border-radius: 10px; background-color: rgba(193, 225, 197, 0.5);">
                                <h4 style="color: white;">제주의 온도º</h4>
                                
                               
                                <form class="createform" action="insertTrip.do" method="post" id="subForm" enctype="multipart/form-data" >
                                   	
                                   	<div class="row">
                                   		<div class="col-sm-6">                                        
                                         	<input type="text" class="" name="name" placeholder="여행 제목을 지정해 주세요.">
                                   		</div>  
                                   		<div class="col-sm-6">
                                   			<input type="file" name="uploadFiles">                                   		
                                   		</div>                              
                                   	</div>
                                   	
                                   	
                        
                                <div class="row">
                                
                                	  <div class="col-sm-6">                                        
                                            <select name="dateSet" id="date">
                                             <option value="">일정</option>
                                             <option value="0">당일</option>
                                             <option value="1">1박</option>
                                             <option value="2">2박</option>
                                             <option value="3">3박</option>                  
                                            </select>
                                    </div>

                                    <div class="col-sm-6">                                        
                                        <select name="mode" id="mode-select">
                                            <option value="">모드</option>
                                            <option value="일반모드">일반모드</option>
                                            <option value="게임모드">게임모드</option>
                                            <option value="랜덤추천모드">랜덤모드</option>                                       
                                        </select>
                                    </div>

                              
                                </div> 

                                <div class="row">
                                	
                                	<div class="col-sm-4">                                        
                                            <select name="areaSet" id="areaSet">
                                             <option value="">지역</option>
                                             <option value="동">동</option>
                                             <option value="서">서</option>
                                             <option value="남">남</option>                                       
                                             <option value="북">북</option>                                       
                                            </select>
                                    </div>
                                
                                    <div class="col-sm-6" style="display: inline-block;">
                                        
                                        <input type="text" name="personnelSet" id="personal" value="0" readonly="readonly" style="text-align:left;"/>                                        
					                    <button type ="button" class="btn_count" onclick="fnCalCount('p',this);">+</button>
					                    <button type ="button" class="btn_count" onclick="fnCalCount('m', this);">-</button>
                                    
                                    </div>

                                    
                                </div>
								
								<div class="row">
                                    <div class="col-sm-6">                                        
                                            <select name="licenseSet" id="d_license">
                                             <option value="">운전면허</option>
                                             <option value="Y">유</option>
                                             <option value="N">무</option>
                                             <option value="X">무관</option>                                       
                                            </select>
                                    </div>
                                    
                                    <div class="col-sm-6">
                                        
                                            <select name="genderSet" id="sex-select">
                                             <option value="">성별</option>
                                             <option value="F">여성</option>
                                             <option value="M">남성</option>
                                             <option value="X">무관</option>                                       
                                            </select>
                                    </div>
                                    
                                </div>    

                                    <div class="input-with-icon">                                        
                                        <textarea name="intro" id="rtext" cols="15" rows="4" style="border-style: none; border-radius: 20px;" placeholder="여행을 소개해 주세요."></textarea>
                                    </div>

                                    <button type="submit" class="btn"  onclick="javascript:btn();" style="background-color:rgba(140, 164, 179, 0.267);color: white; border: none; font-weight: bold;font-size: 1.2em!important;">여행 시작하기!</button>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
                <!--end container-->
            </section>
            
     
        </div>
            <!-- <<<<< footer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-->
			<jsp:include page="tail.jsp" />
        
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
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/datepicker-ko.js"></script>
        
       
        <script>

        function fnCalCount(type, ths){
            var $input = $(ths).parents("div").find("input[name='personnelSet']");
            var tCount = Number($input.val());
            var maxNum = 10;    
            if(type=='p'){
                if(tCount < maxNum) {
                    $input.val(Number(tCount)+1);                
                }
                else if(tCount >= maxNum) {
                    alert("여행 인원은 최대" + maxNum + " 명 을 초과 할 수 없습니다.");
                }
                else {
                    $input.val(Number(tCount)-maxNum);
                }        
            }else{
                if(tCount > 0) $input.val(Number(tCount)-1);    
            }
        }

        
        $(function(){
		$("#date").datepicker({
		showOn: "button",
        buttonImage: "img/calendar.gif",
	    buttonImageOnly: false,
		buttonText: "Select date"
	});
});
        
        </script>
        
    </body>
    
    
</html>