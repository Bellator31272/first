<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<title>회원 정보 수정</title>

	<script type="text/javascript">
		$(function() {
			$("#updateBtn").click(function() {
				$("#f_writeForm").attr({
					"method":"post",
					"action":"/member/updateMember.do"
				})
				$("#f_writeForm").submit();
			})
		})
	</script>


	</head>
	<body>
	<form class="form-horizontal" id="f_writeForm">
		<div class="container">
			<div class="text-center"><h3>정보 수정</h3></div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="id" name="id" value="${data.id }" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
				<input type="password" class="form-control" id="nPasswd" name="nPasswd" placeholder="비밀번호 수정">
				</div>
			</div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="nName" name="nName" placeholder="이름 수정" maxlength="20" value="${data.name }">
				</div>
			</div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">이메일</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="nEmail" name="nEmail" placeholder="이메일 수정" maxlength="20" value="${data.email }">
				</div>
			</div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">전화번호</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="nPhone" name="nPhone" placeholder="전화번호 수정" maxlength="20" value="${data.phone }">
				</div>
			</div>
			<div class="contentBtn text-right">
			<button type="button" id="updateBtn" name="updateBtn" class="btn btn-primary btn-sm">정보수정</button>
		</div>
		</div>
		</form>
	</body>
</html>