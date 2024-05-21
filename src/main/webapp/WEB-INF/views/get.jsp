<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

	<my:navBar2 current="add"></my:navBar2>
	
	<my:alert></my:alert>
	
	<div class="container-lg">
		<h1>${board.id}번 게시물</h1>
		<div class="mb-3">
			<label for="" class="form-label">제목</label>
			<input type="text" class="form-control" value="${board.title}" readonly />
		</div>
		<div class="mb-3">
			<label for="" class="form-label">본문</label>
			<textarea class="form-control" readonly rows="10">${board.body}</textarea>
		</div>
		<div class="mb-3">
			<label for="" class="form-label">작성자</label>
			<input type="text" class="form-control" value="${board.writer}" readonly/>
		</div>
		<div class="mb-3">
			작성일시 : ${board.inserted}
		</div>
		<div>
			<a class="btn btn-secondary" href="/abc/${board.id}">수정</a>
			<button id="removeButton" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteConfirmModal">삭제</button>
		</div>
	</div>	
		<div class="d-none">
			<form action="/remove" method="post" id="removeForm">
				<input type="text" name="id" value="${board.id}" />
			</form>
		</div>

	<!-- Modal -->
	<div class="modal fade" id="deleteConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">삭제 확인</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">정말 삭제 하시겠습니까?</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger" form="removeForm">삭제</button>
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  	

</body>
</html>