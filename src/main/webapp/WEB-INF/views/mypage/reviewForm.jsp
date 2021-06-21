<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />

<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<style type="text/css">
	section#container { padding: 20px 0; border-top: 2px solid #eee; border-bottom: 2px solid #eee; }
 	section#container::after { content: ""; display: block; clear: both; }
	aside { float: left; width: 200px; padding: 0 0 0 5px; }
 	div#container_box { float: right; width: calc(100% - 200px - 20px); }
 	aside ul li { margin-bottom: 10px; list-style: none; }
 	.star_rating { font-size:0; letter-spacing:-4px; }
	.star_rating a {
	    font-size:22px;
	    letter-spacing:0;
	    display:inline-block;
	    margin-left:5px;
	    color:#ccc;
	    text-decoration:none;
	}
	.star_rating a:first-child { margin-left:0; }
	.star_rating a.on { color:#777; }
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>
	<c:import url="../header.jsp"/>	
	<section id="container">
		<aside>
			<c:import url="../aside.jsp"/>				
		</aside>
		<div id="container_box">
		<h3>리뷰 작성</h3>
			<form action="${ contextPath }/file/reviewSave" method="post" enctype="multipart/form-data">
				<b>상품명</b><br>
				<img src="" style="width: 50px; height: 50px">
				<a href="#" >상품명</a><hr>
				<b>작성자</b><br>
				<input type="text" name="member_id" value="" readonly><hr>
				<b>내용</b><br>
				<textarea rows="10" cols="50" name="review_content"></textarea><hr>
				<b>별점</b>&nbsp;
				<div class="rating">
					<p class="star_rating">
					    <a href="#" value="1" class="on">★</a>
					    <a href="#" value="2" class="on">★</a>
					    <a href="#" value="3" class="on">★</a>
					    <a href="#" value="4">★</a>
					    <a href="#" value="5">★</a>
					</p>
				</div><hr>
				<script type="text/javascript">
					$( document ).ready(function() {
						$( ".star_rating a" ).click(function() {
						     $(this).parent().children("a").removeClass("on");
						     $(this).addClass("on").prevAll("a").addClass("on");
						     console.log($(this).attr("value")); //.attr()은 요소(element)의 속성(attribute)의 값을 가져오거나 속성을 추가
						     //$("input.rating").bind("click", set_star_rating);
						     
						     $.ajax({
									url : "/file/star_rating",
									type : "POST",
									data : { review_score : $(this).attr("value") },
									contentType : "application/json; charset=utf-8", //서버로 전송할 데이터 타입
									success : function(result) {
										console.log("성공");
									}, error : function() { alert('문제 발생') }
								})
						     return false;
						});
					});
					function set_star_rating(e) {
						console.log("함수");
					}
				</script>
				<input type="file" name="review_file1">
				<input type="file" name="review_file2">
				<input type="file" name="review_file3"><hr>
				<input type="submit" value="글쓰기">
				<input type="button" value="취소" onclick="history.back()">
			</form>
			
		</div>
	</section>
	<c:import url="../footer.jsp"/>
	
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>