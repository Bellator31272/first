<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
	
	<script type="text/javascript">
		$(function() {
			$("#writeBtn").click(function() {
				if(!chkData("#author", "작성자를")) return;
				else if(!chkData("#title", "제목을")) return;
				else if(!chkData("#content", "내용을")) return;
				else if(!chkData("#passwd", "비밀번호를")) return;
				else{
					$("#f_writeForm").attr({
						"method":"post",
						"action":"/board/insertBoard.do"
					});
					$("#f_writeForm").submit();
				}
			})
			
			$("#listBtn").click(function() {
				location.href="/board/getBoardList.do";
			})
		})
	</script>
	
	</head>
	<body>
		<form class="form-horizontal" id="f_writeForm">
		<div class="container">
			<div class="text-center"><h3>게시판 입력화면</h3></div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">작성자</label>
				<div class="col-sm-10">
				<input type="text" class="form-control" id="author" name="author" placeholder="작성자 입력" maxlength="20">
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">글제목</label>
				<div class="col-sm-10">
				<input type="text" class="form-control" id="title" name="title" placeholder="글제목 입력">
				</div>
			</div>
			<div class="form-group" class="col-sm-2 control-label">
				<label class="col-sm-2 control-label">글내용</label>
				<div class="col-sm-10">
				<textarea rows="10" cols="10" class="form-control" style="resize: none" name="content" id="content"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="passwd" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
				<input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력">
				</div>
			</div>
			<div class="contentBtn text-right">
			<button type="button" id="writeBtn" name="writeBtn" class="btn btn-primary btn-sm">저장</button>
			<button type="button" id="listBtn" name="listBtn" class="btn btn-primary btn-sm">목록</button>
		</div>
		</div>
		</form>
	</body>
</html>