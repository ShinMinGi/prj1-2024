<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container-lg">
	
		<div class="justi fy-content-center">
			<div class="col-12 col-md-8 col-lg-6">


				<h1>${board.id}번 게시물 수정</h1>
				<form method="post">
					<input type="hidden" name="id" value="${board.id}" />
					<div class="mb-3">
						<label for="titleInput" class="form-label">제목</label> 
						<input id="titleInput" type="text" class="form-control" value="${board.title}" name="title" />
					</div>
					<div class="mb-3">
						<label for="bodyInput" class="form-label">본문</label>
						<textarea class="form-control" id="bodyTextarea" rows="10" name="body">${board.body}</textarea>
					</div>
					<div class="mb-3">
						<label for="writerInput" class="form-label">작성자</label> 
						<input class="form-control" id="writerInput" type="text" name="writer" value="${board.writer}" />
					</div>
					<div class="mb-3">
						<label for="insertedInput" class="form-label">날짜</label>
						<input class="form-control" id="insertedInput" type="text" value="${board.inserted}" readonly />
					</div>
					<div class="mb-3">
						<input class="btn btn-secondary" type="submit" value="수정" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>