<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>Pillar Multipurpose HTML Template</title>
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
        <link href="css/data" rel="stylesheet">
        <style> 
        a {
            color: black;
        }
     
        </style>
      
    </head>
    <body> 
            <section>
                <div style="margin-left: 0px;" class="col-md-1 col-md-offset-1 hidden-sm hidden-xs">
                    <div class="sidebar">
                        <div class="sidebar__widget">
                            <h6>Search Site</h6>
                            <hr>
                            <form method="post">
                                <div class="input-with-icon">
                                    <i class="icon-Magnifi-Glass2"></i>
                                    <input type="search" placeholder="Type Here" />
                                </div>
                            </form>
                        </div>
                        <!--end widget-->
                        <div class="sidebar__widget">
                            <h6>Categories</h6>
                            <ul  class="link-list">
                                <li>
                                    <a href="#">
                                        설정
                                    </a>
                                </li>
                                <li>
                                    <a href="admin-MemberList.html">
                                        회원관리
                                    </a>
                                </li>
                            </ul>
                            <hr>
                            <ul class="link-list">
                                <li>
                                    <a href="admin-RoomsList.html">
                                        숙소
                                    </a>
                                </li>
                                <li>
                                    <a href="admin-RestauranList.html">
                                        식당
                                    </a>
                                </li>
                                <li>
                                    <a href="admin-CafeList.html">
                                        카페
                                    </a>
                                </li>
                                <li>
                                    <a href="admin-TourlistList.html">
                                        관광지
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--end widget-->
                        <div class="sidebar__widget">
                            <h6>Tags</h6>
                            <hr>
                            <ul class="tag-cloud">
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Business
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Tourism
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Life
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Startup
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Design
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Tech
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Style
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn btn--sm btn--square">
                                        <span class="btn__text">
                                            Environment
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--end widget-->
                        <div class="sidebar__widget">
                            <h6>About Us</h6>
                            <hr>
                            <p>
                                We're a digital focussed collective working with individuals and businesses to establish rich, engaging online presences.
                            </p>
                        </div>
                        <!--end widget-->
                    </div>
                </div>
                <!-- Content Wrapper -->
        <div id="content-wrapper" style="background-color: rgba(255, 255, 255, .9)"  class="d-flex flex-column">

            <!-- Main Content -->
                <div id="content">
                    <!--nav-->

                    <!--section-->
                    <section>
                   
                            <!--바디 영역-->
                            <div class="container">
                              <div class="input-form-backgroud row">
                                <div class="input-form col-md-12 mx-auto">
                                  <h2 class="mb-3">카페 등록</h2>
                                  <hr style="background-color: rgba(0, 0, 0, 0.2);"> 
                                   <form action="insertplace.do" method="post" enctype="multipart/form-data">
                                    <div class="mb-3">
                                    <input type="hidden" id="category" name="pCategory" value="카페">
                                      <label for="name"><h5 style="color: rgba(0, 0, 0, 0.5);">카페명</h4></label>
                                      <input
                                      	name="pName"
                                        type="text"
                                        class="form-control"
                                        id="customer-id"
                                        placeholder="등록하실 카페명을 입력해주세요"
                                        maxlength="12"
                                        required
                                        style="border: 1px solid rgba(0, 0, 0, 0.2);"
                                      />
                                      <div class="invalid-feedback">이름을 입력해주세요.</div>
                                    </div>
                                    <div class="mb-3">
                                      <label for="area"><h5 style="color: rgba(0, 0, 0, 0.5);">방향</h5></label><br>
                                      <select name="pArea" style="width: 50px; height: 60px; border: 1px solid rgba(0, 0, 0, 0.2); ;">
                                        <option value = "동" selected>동</option>
                                        <option value = "서">서</option>
                                        <option value = "남">남</option>
                                        <option value = "북">북</option>
                                     </select>

                                      <div class="invalid-feedback">위치를입력해주세요.</div>
                                    </div>
                                    
                                    
                                    <div class="mb-3">
                                        <label for="tel"><h5 style="color: rgba(0, 0, 0, 0.5);">카페 전화번호</h5></label>
                                        <input
                                          type="text"
                                          name="pTell"
                                          class="form-control"
                                          id="tel"
                                          placeholder="전화번호를 입력해주세요"
                                          required
                                          style="border: 1px solid rgba(0, 0, 0, 0.2);"
                                        />
                                          
                                        <div class="invalid-feedback">전화번호를 입력해주세요.</div>
                                          </div>
                                          <div class="mb-3">
                                              <label for="email"><h5 style="color: rgba(0, 0, 0, 0.5);">카페 주소</h5></label>
                                              <input
                                                type="text"
                                                name="pAddress"
                                                class="form-control"
                                                id="email"
                                                placeholder="주소를 적어주세요"
                                                required
                                                style="border: 1px solid rgba(0, 0, 0, 0.2);"
                                              />
                                                
                                        <div class="invalid-feedback">카페주소를 입력해주세요</div>
                                                </div>

                                            <label for="email"><h5 style="color: rgba(0, 0, 0, 0.5);" >카페 정보</h5></label>
                                                <div class="mb-3">
                                                <textarea style="border: 1px solid rgba(0, 0, 0, 0.2);"  
                                                placeholder="가게를 소개해주세요"   
                                                name="pInfo" id="info" cols="50" rows="5"></textarea>
                                        
                                            <div class="invalid-feedback">매장정보를 입력해주세요</div>
                                        </div>

                                              
                                            
                                              <div class="row">
                                                <div class="col-md-6 mb-3">
                                                  <label for="name"><h5 style="color: rgba(0, 0, 0, 0.5);" >X좌표</h5></label>
                                                  <input
                                                    type="text"
                                                    name="pXaxis"
                                                    class="form-control"
                                                    id="name"
                                                    placeholder="위도"
                                                    value=""
                                                    style="border: 1px solid rgba(0, 0, 0, 0.2);"
                                                    required
                                                  />
                                                  <div class="invalid-feedback">위도를 입력해주세요.</div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                  <label for="nickname"><h5 style="color: rgba(0, 0, 0, 0.5);">Y좌표</h5></label>
                                                  <input
                                                    type="text"  
                                                    name="pYaxis"
                                                    class="form-control"
                                                    id="nickname"
                                                    style="border: 1px solid rgba(0, 0, 0, 0.2);"
                                                    placeholder="경도"
                                                    value=""
                                                    required
                                                  />
                                                  <div class="invalid-feedback">경도를 입력해주세요.</div>
                                                </div>
                                              </div>
                                    
                                    <!--사진 첨부 미리보기 -->
                                    <div class="row">
                                        <div class="col-md-6 mb-3">
                                            <div id="map" style="width:100%;height:350px;"></div>
                                        </div>
                                        <div class="col-md-6 mb-3" >
                                            <div class="image-container" >
                                                <img style="width: 430px; height: 300px; " id="preview-image" src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image">
                                                <input style="display: block;" type="file" id="input-image" name="uploadfile" >
                                            </div>
                                        </div>
                                    <!--사진 첨부 미리보기 끝-->

                                    </div>
                                    <!--버튼 submit 타입이라 일단 주석 처리함-->
                                    <!-- <button
                                      id="red"
                                      class="btn btn-primary btn-lg btn-block"
                                      type="submit"
                                    >
                                      가입 완료
                                    </button> -->
                                    <div style="margin-top: 20px;"></div>
                                    <!--9.28 회원가입 버튼 영역 일부 수정 및 회원가입 취소 버튼 추가-->
                                    <div class="sign-up-footer">
                                      <div class="sign-up-footer-items">
                                        <a href="index.jsp"
                                        style="font-size: 25px;"
                                          ><button
                                            type="submit"
                                            class="btn btn-success btn-lg btn-block button-custom"
                                            id="red">
                                            등록하기
                                          </button></a>
                                        
                                      </div>
                                      <div class="sign-up-footer-items">
                                        
                                      </div>
                                    </div>
                                  </form>
                                </div>
                              </div>
                              <!-- <footer class="my-3 text-center text-small">
                                <p class="mb-1">&copy; 2021 HS</p>
                              </footer> -->
                            </div>
                    </section>
            </div>
            <!-- End of Main Content -->
                <!--end of container-->
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
                                <li>
                                    <a href="#">
                                        <span>About Us</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Services</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Selected Work</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Get In Touch</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Careers</span>
                                    </a>
                                </li>
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
                            <p>
                                Get monthly updates and free resources.
                            </p>
                            <form class="form--merge form--no-labels" action="http://mrareco.createsend.com/t/d/s/kieth/" method="post" id="subForm" data-error="Please fill all fields correctly." data-success="Thanks for signing up! Please check your inbox for confirmation email.">
                                <p>
                                    <label for="fieldEmail">Email Address</label>
                                    <br />
                                    <input class="col-md-8 col-sm-6 validate-required validate-email" id="fieldEmail" name="cm-kieth-kieth" type="email" required />
                                </p>
                                <p>
                                    <button type="submit">Go</button>
                                </p>
                            </form>
                            <h6>Connect with Us</h6>
                            <ul class="social-list">
                                <li>
                                    <a href="#">
                                        <i class="socicon-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="socicon-dribbble"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="socicon-vimeo"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="socicon-instagram"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="socicon-spotify"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="socicon-behance"></i>
                                    </a>
                                </li>
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
                                <span class="type--fine-print">&copy; Copyright
                                    <span class="update-year">2016</span> Medium Rare - All Rights Reserved</span>
                            </div>
                            <div class="col-sm-6 text-right text-center-xs">
                                <a href="#top" class="inner-link top-link">
                                    <i class="interface-up-open-big"></i>
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

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=3223cceebbc99daf72eb23b373491dd8"></script>
    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=3223cceebbc99daf72eb23b373491dd8"></script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
    var positions = [
        {
            content: '<div>카카오</div>',
            latlng: new kakao.maps.LatLng(33.450705, 126.570677)
        },
        {
            content: '<div>생태연못</div>',
            latlng: new kakao.maps.LatLng(33.450936, 126.569477)
        },
        {
            content: '<div>텃밭</div>',
            latlng: new kakao.maps.LatLng(33.450879, 126.569940)
        },
        {
            content: '<div>근린공원</div>',
            latlng: new kakao.maps.LatLng(33.451393, 126.570738)
        }
    ];

    for (var i = 0; i < positions.length; i++) {
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng // 마커의 위치
        });

        // 마커에 표시할 인포윈도우를 생성합니다 
        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].content // 인포윈도우에 표시할 내용
        });

        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
        // 이벤트 리스너로는 클로저를 만들어 등록합니다 
        // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
    }

    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
    function makeOverListener(map, marker, infowindow) {
        return function () {
            infowindow.open(map, marker);
        };
    }

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
    function makeOutListener(infowindow) {
        return function () {
            infowindow.close();
        };
    }

    /* 아래와 같이도 할 수 있습니다 */
    /*
    for (var i = 0; i < positions.length; i ++) {
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng // 마커의 위치
        });
    
        // 마커에 표시할 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].content // 인포윈도우에 표시할 내용
        });
    
        // 마커에 이벤트를 등록하는 함수 만들고 즉시 호출하여 클로저를 만듭니다
        // 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        (function(marker, infowindow) {
            // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                infowindow.open(map, marker);
            });
    
            // 마커에 mouseout 이벤트를 등록하고 마우스 아웃 시 인포윈도우를 닫습니다
            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });
        })(marker, infowindow);
    }
    */
</script>

<script>
    function readImage(input) {
// 인풋 태그에 파일이 있는 경우
if(input.files && input.files[0]) {
    // 이미지 파일인지 검사 (생략)
    // FileReader 인스턴스 생성
    const reader = new FileReader()
    // 이미지가 로드가 된 경우
    reader.onload = e => {
        const previewImage = document.getElementById("preview-image")
        previewImage.src = e.target.result
    }
    // reader가 이미지 읽도록 하기
    reader.readAsDataURL(input.files[0])
}
}
// input file에 change 이벤트 부여
const inputImage = document.getElementById("input-image")
inputImage.addEventListener("change", e => {
readImage(e.target)
})

</script>
    </body>
</html>