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
	
</style>
</head>
<body>
	<c:choose>
		<c:when test=""> <!-- 관리자가 로그인 하면 관리자용 카테고리가 옆에 뜨고 일반 사용자가 로그인하면 사용자에 맞춘 카테고리뜸 
											우선 관리자용으로 되있는데 login == admin 아거 지우면 일반 사용자용-->
			<c:import url="../adminCategory/category.jsp"/>
		</c:when>
		<c:otherwise>
			<aside>
				<h3>마이페이지</h3>
				<ul>
					<li><a href="${ contextPath }/mypage/myCart">장바구니</a></li>
					<li><a href="#">개인정보 수정</a></li>
					<li><a href="${ contextPath }/mypage/myRental">주문 내역</a></li>
					<li><a href="${ contextPath }/mypage/myReview">내 리뷰</a></li>
					<li><a href="${ contextPath }/mypage/myEnquiry">내 질문</a></li>
				</ul>
				<h3>고객센터</h3>
				<ul>
					<li><a href="${ contextPath }/board/faq">자주하는 질문</a></li>
					<li><a href="${ contextPath }/board/notice">공지사항</a></li>
					<li><a href="${ contextPath }/board/qna">Q&A</a></li>
				</ul>
			</aside>
		</c:otherwise>
	</c:choose>
</body>
</html>