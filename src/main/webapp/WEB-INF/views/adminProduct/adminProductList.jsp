<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">



<style type="text/css">
	.wrap{width: 1200px;height: 400px; margin: -490px 0 0 240px;}
	.button{margin: 0 0 0 900px;}
	.container{margin-top: 20px;}
	#b3{margin-top: 10px; margin-left: 10px;}
	.t{width: 1500px; height: 1000px;  margin: auto;}
</style>

</head>
<body>
<jsp:include page="../header.jsp" />
<div class="t">
<jsp:include page="../adminCategory/category.jsp" />
<div class="wrap">
	<h1>상품관리</h1>
	<div class="button">
		<%-- <button type="button" class="btn btn-outline-primary" id="b1" onclick="${contextPath }/adminProduct/adminProductDelete?productNum=${dto.productNum}">선택삭제</button>
		<button type="button" class="btn btn-outline-primary" id="b2" onclick="">전체삭제</button> --%>
	</div>
	
	<div class="container">    
		
	 	 <table class="table table-striped">
	   	 <thead>
	      <tr>
	      	<th><input type="checkbox" name="allCheck" id="allCheck"></th>
	        <th>상품번호</th>
	        <th>상품명</th>
	        <th>상품가격</th>
	        <th>등록일자</th>
	      </tr>
	      <c:if test="${adminProductList.size() ==0 }">
	      	<tr><td colspan="5">등록된 글이 없습니다</td></tr>
	      </c:if>
	    </thead>
	    <tbody>
	    <c:forEach var="dto" items="${adminProductList }">
	      <tr>
	      	<td><input type="checkbox" class="choice" name="choice" id="choice" value="${dto.productNum}"></td>
	        <td>${dto.productNum }</td>
	        <td><a href="${contextPath }/adminProduct/adminProductView?productNum=${dto.productNum}">${dto.productTitle }</a></td>
	        <td>${dto.productPee }</td>
	        <td>${dto.productDate }</td>
	      </tr>
	     </c:forEach>
	    </tbody>
	  </table>
	  	<div class="button">
		  	<input type="button" class="btn btn-outline-primary" id="b1" onclick="" value="선택삭제"/>
			<button type="button" class="btn btn-outline-primary" id="b2" onclick="">전체삭제</button>
		</div>
	  
	</div>
	<button type="button" class="btn btn-outline-primary" id="b3" onclick="input()">상품등록</button>
	
	
	
	
	
	
</div>
</div>
<jsp:include page="../footer.jsp" />
<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>


<script type="text/javascript">
	function input() {
		location.href='adminProductInput'
	}
	
	
    // 체크박스 전체해제 전체클릭
    $("#allCheck").click(function(){
   
    if($("#allCheck").prop("checked")){
      
        $("input[name=choice]").prop("checked",true);
    }else{
        $("input[name=choice]").prop("checked",false);
    }

    });

/* //체크박스 하나 해제시 전체체크박스 해제
$(document).on("click", "input[name=optionCheckBox]", function(){

var checkbox =$("input[name=optionCheckBox]:checked");

if($("input[name=optionCheckBox]").length==checkbox.length){ 
  
    $("#optionCheckAll").prop("checked",true); 
}else{ 
   $('#optionCheckAll').prop("checked",false); 
} 

});	 */
	
	
	
	

	
	
</script>
</html>


























