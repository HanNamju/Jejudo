<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
        
<style>
  h1,h2,h3,h4,h5,h6,p,div{
                font-family: 'Noto Sans KR', sans-serif;
            }
body {

  padding-top: 70px;

  padding-bottom: 30px;

 

}
</style>
</head>

<body>

	<article >

		<div class="container" role="main" style="background-color: white;">

			<h2>글쓰기</h2>

			<form method="post" action="insertBoard.do" >


					
				<div class="mb-3">

					<label for="title"><h6>제목</h6></label>

					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">

				</div>

				
<!-- 
				<div class="mb-3">

					<label for="reg_id">작성자</label>

					<input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">

				</div> -->

				
      <div class="row">
				<div class="col-md-6 mb-3">

					<label for="content"><h6>내용</h6></label>

					<textarea style="height: 400px;"class="form-control" rows="8" name="content" id="content" placeholder="내용을 입력해 주세요" ></textarea>

				</div>


        <div class="col-md-6 mb-3" >
        	<label for="content"><h6>사진</h6></label>
          <div class="image-container" >
              <img style="width: 100%; height: 100%; " id="preview-image" src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image">
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

	$(document).on('click', '#btnSave', function(e){

		e.preventDefault();

		

		$("#form").submit();

	});

	

	$(document).on('click', '#btnList', function(e){

		e.preventDefault();

		

		location.href="${pageContext.request.contextPath}/board/getBoardList";

	});

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