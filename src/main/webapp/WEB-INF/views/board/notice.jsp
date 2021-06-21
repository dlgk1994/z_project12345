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
	aside { float: left; width: 200px; padding: 0 0 0 10px; }
 	div#container_box { float: right; width: calc(100% - 200px - 20px); }
 	aside ul li { margin-bottom: 10px; list-style: none; }
</style>
</head>
<body>
	<c:import url="../header.jsp"/>	
	<section id="container">
		<aside>
			<c:choose> 
				<c:when test=""><!-- 관리자 로그인 하면 관리자에 맞게 왼쪽에 카텔고리 바뀜 
					<jsp:include page="../adminCategory/category.jsp" />-->
					
				</c:when>
				<c:otherwise>
					<c:import url="../aside.jsp"/>
				</c:otherwise>
			</c:choose>					
		</aside>
		<div id="container_box">
		<h3>공지사항</h3>
		<c:choose>
			<c:when test=""> <!-- ${login == admin }  관리자가 로그인했을때만 글 쓰기 버튼 보이기 
				<button type="button" class="btn btn-outline-primary" id="b2" onclick="location.href='../boardInput/noticeInput'" style="margin: 0px 0 0 1060px;">글쓰기</button>
			-->
			</c:when>
		</c:choose>
			
		<div style="margin-top: 10px;">
			<table border="1" style="width: 90%; border-bottom: 1px solid #D5D5D5;">
				<tr>
					<th>글번호</th><th>공지분류</th><th>제목</th><th>등록일</th><th>조회수</th>
				</tr>
				<c:if test="${ noticeList.size() == 0 }">
					<tr><th colspan="5">작성된 공지사항이 없습니다</th></tr>
				</c:if>
				<c:forEach var="dto" items="${ noticeList }">					
				<tr><!-- td값 db에서 가져오기 -->
					<td>${ dto.notice_no }</td>
					<td>${ dto.notice_group }</td>
					<td>
						<a href="../boardInput/notice">${ dto.notice_title }</a>
					</td>
					<td>${ dto.notice_writedate }</td>
					<td>${ dto.notice_hit }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
			<div>
				<input type="text" name="search">
				<button type="button">검색</button>
			</div>
		</div>
	</section>
	<c:import url="../footer.jsp"/>
	
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>