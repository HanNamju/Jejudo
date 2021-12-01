<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
        
<style>
  h1,h2,h3,h4,h5,h6,p,div{
                font-family: 'Noto Sans KR', sans-serif;
            }
body {

  padding-top: 70px;

  padding-bottom: 30px;

 

}
=======
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

<style>
h1, h2, h3, h4, h5, h6, p, div {
	font-family: 'Noto Sans KR', sans-serif;
}

body {
	padding-top: 70px;
	padding-bottom: 30px;
}


>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef
</style>
</head>

<body>

<<<<<<< HEAD
	<article >

		<div class="container" role="main" style="background-color: white;">

			<h2>글 수정</h2>

			<form method="post" action="insertBoard.do" >


					
				<div class="mb-3">

					<label for="title"><h6>제목</h6></label>

					<input type="text" class="form-control" name="title" value="${board.title}">

				</div>

				
<!-- 
				<div class="mb-3">

					<label for="reg_id">작성자</label>

					<input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">

				</div> -->

				
      <div class="row">
				<div class="col-md-6 mb-3">

					<label for="content"><h6>내용</h6></label>

					<textarea style="height: 400px;"class="form-control" rows="8" name="content" id="content" value="${board.content}"></textarea>

				</div>


        <div class="col-md-6 mb-3" >
        	<label for="content"><h6>사진</h6></label>
          <div class="image-container" >
              <img style="width: 100%; height: 100%; " id="preview-image" src="upload/${fileList.originalFileName}">
              <input style="display: block;" type="file" id="input-image" >
          </div>
      </div>
      </div>
				

				<div class="mb-3">

					<label for="tag">TAG</label>

					<input type="text" class="form-control"  id="tag" placeholder="태그를 입력해 주세요">

				</div>



			
        <div style="text-align: center; margin-top: 30px;" >
  
          <button style="padding: 10px;" type="submit" class="btn btn-dark" id="btnSave">&nbsp저장&nbsp</button>
         
			</form>
          <button style="padding: 10px;" type="submit" class="btn btn-dark" id="btnList">&nbsp목록&nbsp</button>
  
        </div>



		</div>

	</article>
<!-- jQuery -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>



<!-- Bootstrap CSS -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">



<title>board</title>



<script>
=======
	<article>

		<div class="container" role="main" style="background-color: white;">
			<div style="display: flex; justify-content: space-between;">
			<div><h2>湲� �닔�젙�븯湲�</h2></div>
			<div><button class="btn btn-dark">�굹媛�湲�</button></div>
			</div>
			<form method="post" action="updateBoard.do" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="title"><h6>�젣紐�</h6></label> <input type="text"
						class="form-control" name="title" id="title"
						value="${board.title }">
						<input type="hidden"
						class="form-control" name="writer" id="writer"
						value="${member.mId}">
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="content"><h6>�궡�슜</h6></label>
						<textarea style="height: 400px;" class="form-control" rows="8"
							name="content" id="content" >${board.content }</textarea>
					</div>
					<div class="col-md-6 mb-3">
						<label for="content"><h6>�궗吏�</h6></label>
						<div class="image-container" >
              <img style="width: 100%; height: 100%; " id="preview-image" src="upload/${fileList.originalFileName}">
              <input style="display: block;" type="file" id="input-image" name="uploadfile">
          </div>
					</div>
				</div>
				<div class="mb-3">
					<label for="tag">TAG</label> <input type="text"
						class="form-control" id="tag" placeholder="�깭洹몃�� �엯�젰�빐 二쇱꽭�슂">
				</div>
				<div style="display: flex; justify-content: center;" >
				
				
			
					<div>	
					<button style="padding: 10px;" type="submit" class="btn btn-dark"
							id="btnList">&nbsp�닔�젙&nbsp</button>
										</form>
				</div>
				</div>
		</div>
		





	</article>
	<!-- jQuery -->

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>



	<!-- Bootstrap CSS -->

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
		integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
		crossorigin="anonymous">



	<title>board</title>



	<script>
>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef

	$(document).on('click', '#btnSave', function(e){

		e.preventDefault();

		

		$("#form").submit();

	});

	


<<<<<<< HEAD
</script>

<script>
  function readImage(input) {
// 인풋 태그에 파일이 있는 경우
if(input.files && input.files[0]) {
  // 이미지 파일인지 검사 (생략)
  // FileReader 인스턴스 생성
  const reader = new FileReader()
  // 이미지가 로드가 된 경우
=======

</script>

	<script>
  function readImage(input) {
// �씤�뭼 �깭洹몄뿉 �뙆�씪�씠 �엳�뒗 寃쎌슦
if(input.files && input.files[0]) {
  // �씠誘몄�� �뙆�씪�씤吏� 寃��궗 (�깮�왂)
  // FileReader �씤�뒪�꽩�뒪 �깮�꽦
  const reader = new FileReader()
  // �씠誘몄��媛� 濡쒕뱶媛� �맂 寃쎌슦
>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef
  reader.onload = e => {
      const previewImage = document.getElementById("preview-image")
      previewImage.src = e.target.result
  }
<<<<<<< HEAD
  // reader가 이미지 읽도록 하기
  reader.readAsDataURL(input.files[0])
}
}
// input file에 change 이벤트 부여
=======
  // reader媛� �씠誘몄�� �씫�룄濡� �븯湲�
  reader.readAsDataURL(input.files[0])
}
}
// input file�뿉 change �씠踰ㅽ듃 遺��뿬
>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef
const inputImage = document.getElementById("input-image")
inputImage.addEventListener("change", e => {
readImage(e.target)
})

</script>
</body>

</html>