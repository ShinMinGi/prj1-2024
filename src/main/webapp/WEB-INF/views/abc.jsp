<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container-lg">
	<h1>${board.id}게시물 수정</h1>
	<form method="post">
		<input type="hidden" name="id" value="${board.id}"/> 
		<div>
			제목 : <input type="text" name="title" value="${board.title}"/>
		</div>
		<div>
			본문 : <textarea name="body">${board.body}</textarea>
		</div>
		<div>
			작성자 : <input type="text" name="writer" value="${board.writer}"/>
		</div>
		<div>
			날짜 : <input type="text" value="${board.inserted}" readonly/>
		</div>
		<div>
			<input type="submit" value="수정" />
		</div>
	</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
	<c:if test="${not empty param.fail}">
		<script>
			alert("수정되지 않았습니다");
		</script>
	</c:if> 
</body>
</html>