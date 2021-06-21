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
 	
 	.q{ display: flex; list-style: none; }
</style>
</head>
<body>
	<c:import url="../header.jsp"/>	
	<section id="container">
		<aside>
			<c:choose>
				<c:when test="${login == admin }"> <!-- 관리자 로그인 하면 관리자에 맞게 왼쪽에 카텔고리 바뀜 -->
					<jsp:include page="../adminCategory/category.jsp" />
				</c:when>
				<c:otherwise>
					<c:import url="../aside.jsp"/>
				</c:otherwise>
			</c:choose>					
		</aside>
		<div id="container_box">
		<h3>자주하는 질문</h3>
			<div>
				<nav>
					<ul class ="q">
						<li><a href="#">회원가입/탈퇴</a></li>
						<li><a href="#">주문/결제</a></li>
						<li><a href="#">파손/분실</a></li>
						<li><a href="#">배송</a></li>
						<li><a href="#">반납</a></li>
					</ul>
				</nav>
				<div id="content" class="content">
					본문내용<br>
					script -> function 에서 id -> str+= 통해 내용 지정
				</div>
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