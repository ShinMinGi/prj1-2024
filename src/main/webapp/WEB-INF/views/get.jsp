<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container-lg">
		<h1>${board.id}번 게시물 보기</h1>
		<div>
			제목 :  ${board.title}
		</div>
		<div>
			본문 : <div>${board.body}</div>
		</div>
		<div>
			작성자 : ${board.writer}
		</div>
		<div>
			작성일시 : ${board.inserted}
		</div>
		<div>
			<a class="btn btn-secondary" href="/abc/${board.id}">수정하기</a>
			<button id="removeButton" class="btn btn-danger" form="removeForm" type="submit">삭제하기</button>
		</div>
	</div>	
		<div class="d-none">
			<form action="/remove" method="post" id="removeForm">
				<input type="text" name="id" value="${board.id}" />
			</form>
		</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  	
  	
  	<script>
  		$("#removeButton").click(function(e) {
			// 서브밋 진행 이벤트 막기
  			e.preventDefault();
			
  			const res = confirm("삭제를 진행하시겠습니까?")
  			if (res) {
  				// 서브밋 실행 
  				$("#removeForm").submit();
  			}
  		});
  	</script>
		<c:if test="${not empty param.success }">
		<script>
			alert("게시물 수정완료");
		</script>
	</c:if>

</body>
</html>