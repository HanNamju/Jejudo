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

			<h2>±Û ¼öÁ¤</h2>

			<form method="post" action="insertBoard.do" >


					
				<div class="mb-3">

					<label for="title"><h6>Á¦¸ñ</h6></label>

					<input type="text" class="form-control" name="title" value="${board.title}">

				</div>

				
<!-- 
				<div class="mb-3">

					<label for="reg_id">ÀÛ¼ºÀÚ</label>

					<input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä">

				</div> -->

				
      <div class="row">
				<div class="col-md-6 mb-3">

					<label for="content"><h6>³»¿ë</h6></label>

					<textarea style="height: 400px;"class="form-control" rows="8" name="content" id="content" value="${board.content}"></textarea>

				</div>


        <div class="col-md-6 mb-3" >
        	<label for="content"><h6>»çÁø</h6></label>
          <div class="image-container" >
              <img style="width: 100%; height: 100%; " id="preview-image" src="upload/${fileList.originalFileName}">
              <input style="display: block;" type="file" id="input-image" >
          </div>
      </div>
      </div>
				

				<div class="mb-3">

					<label for="tag">TAG</label>

					<input type="text" class="form-control"  id="tag" placeholder="ÅÂ±×¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä">

				</div>



			
        <div style="text-align: center; margin-top: 30px;" >
  
          <button style="padding: 10px;" type="submit" class="btn btn-dark" id="btnSave">&nbspÀúÀå&nbsp</button>
         
			</form>
          <button style="padding: 10px;" type="submit" class="btn btn-dark" id="btnList">&nbsp¸ñ·Ï&nbsp</button>
  
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
			<div><h2>ê¸€ ìˆ˜ì •í•˜ê¸°</h2></div>
			<div><button class="btn btn-dark">ë‚˜ê°€ê¸°</button></div>
			</div>
			<form method="post" action="updateBoard.do" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="title"><h6>ì œëª©</h6></label> <input type="text"
						class="form-control" name="title" id="title"
						value="${board.title }">
						<input type="hidden"
						class="form-control" name="writer" id="writer"
						value="${member.mId}">
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="content"><h6>ë‚´ìš©</h6></label>
						<textarea style="height: 400px;" class="form-control" rows="8"
							name="content" id="content" >${board.content }</textarea>
					</div>
					<div class="col-md-6 mb-3">
						<label for="content"><h6>ì‚¬ì§„</h6></label>
						<div class="image-container" >
              <img style="width: 100%; height: 100%; " id="preview-image" src="upload/${fileList.originalFileName}">
              <input style="display: block;" type="file" id="input-image" name="uploadfile">
          </div>
					</div>
				</div>
				<div class="mb-3">
					<label for="tag">TAG</label> <input type="text"
						class="form-control" id="tag" placeholder="íƒœê·¸ë¥¼ ì…ë ¥í•´ ì£¼ì„¸ìš”">
				</div>
				<div style="display: flex; justify-content: center;" >
				
				
			
					<div>	
					<button style="padding: 10px;" type="submit" class="btn btn-dark"
							id="btnList">&nbspìˆ˜ì •&nbsp</button>
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
// ÀÎÇ² ÅÂ±×¿¡ ÆÄÀÏÀÌ ÀÖ´Â °æ¿ì
if(input.files && input.files[0]) {
  // ÀÌ¹ÌÁö ÆÄÀÏÀÎÁö °Ë»ç (»ı·«)
  // FileReader ÀÎ½ºÅÏ½º »ı¼º
  const reader = new FileReader()
  // ÀÌ¹ÌÁö°¡ ·Îµå°¡ µÈ °æ¿ì
=======

</script>

	<script>
  function readImage(input) {
// ì¸í’‹ íƒœê·¸ì— íŒŒì¼ì´ ìˆëŠ” ê²½ìš°
if(input.files && input.files[0]) {
  // ì´ë¯¸ì§€ íŒŒì¼ì¸ì§€ ê²€ì‚¬ (ìƒëµ)
  // FileReader ì¸ìŠ¤í„´ìŠ¤ ìƒì„±
  const reader = new FileReader()
  // ì´ë¯¸ì§€ê°€ ë¡œë“œê°€ ëœ ê²½ìš°
>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef
  reader.onload = e => {
      const previewImage = document.getElementById("preview-image")
      previewImage.src = e.target.result
  }
<<<<<<< HEAD
  // reader°¡ ÀÌ¹ÌÁö ÀĞµµ·Ï ÇÏ±â
  reader.readAsDataURL(input.files[0])
}
}
// input file¿¡ change ÀÌº¥Æ® ºÎ¿©
=======
  // readerê°€ ì´ë¯¸ì§€ ì½ë„ë¡ í•˜ê¸°
  reader.readAsDataURL(input.files[0])
}
}
// input fileì— change ì´ë²¤íŠ¸ ë¶€ì—¬
>>>>>>> 6c4030f15d0b31a443071b933a5d38a6661a5eef
const inputImage = document.getElementById("input-image")
inputImage.addEventListener("change", e => {
readImage(e.target)
})

</script>
</body>

</html>