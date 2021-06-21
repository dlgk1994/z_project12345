<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.t{width: 1500px; height: 1000px;  margin: auto;}
	.wrap{width: 900px;height: 800px; margin: -490px 0 0 300px;}
</style>
<script type="text/javascript">
	function removeCheck() {
	 if (confirm("작성을 취소하시겠습니까?") == true){    //확인
		 location.href='${contextPath}/board/notice'
	 }else{   //취소
	     return false;
	 }
	}
	function back() {
		window.history.back();
	}
</script>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="t">
<jsp:include page="../adminCategory/category.jsp" />
	<!-- 공지사항 게시글 보는 페이지 -->
	<div class="wrap">
		<h1>공지사항</h1>
		<c:choose>
			<c:when test="${login == admin }"><!-- ${login == admin }  관리자가 로그인시 -->
			<div style="margin-top: 20px;">
				<select name="notice_group" class="category2">
					<option value="0">공지분류
					<option value="1">[일반공지]
					<option value="2">[당첨발표]
				</select>
			</div>
			<div>
				<label style="margin: 40px 0 0 0px;">글 제목</label><br>
				<input type="text" style=" width: 740px;" name="notice_title" value="db에서 값 가져오기">
			</div>
			
			<div style="margin-top: 20px;">
				<textarea rows="10" cols="100" name="notice_content">db에서 값 가져오기</textarea>
			</div>
				<button type="button" class="btn btn-outline-primary" id="" onclick="#" style="margin: 10px 0 0 280px;">수 정</button>
				<button type="button" class="btn btn-outline-primary" id="" onclick="removeCheck()" style="margin: 10px 0 0 70px;" >취 소</button>
			</c:when>
			<c:otherwise> <!-- 이용자가 클릭 했을때 -->
				<div style="margin-top: 20px;">
					<select name="notice_group" class="category2">
						<option value="0">공지분류
						<option value="1">[일반공지]
						<option value="2">[당첨발표]
					</select>
				</div>
				<div>
					<label style="margin: 40px 0 0 0px;">글 제목</label><br>
					<input type="text" style=" width: 740px;" name="notice_title" value="db에서 값 가져오기" readonly="readonly">
				</div>
				
				<div style="margin-top: 20px;">
					<textarea rows="10" cols="100" name="notice_content" readonly="readonly">db에서 값 가져오기</textarea>
				</div>
					<button type="button" class="btn btn-outline-primary" id="" onclick="back()" style="margin: 10px 0 0 0px;" >뒤로가기</button>
			</c:otherwise>
		</c:choose>
		
		
		
	</div>
</div>
<jsp:include page="../footer.jsp" />

<c:import url="../footer.jsp"/>
	
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
























