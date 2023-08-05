<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/common.jsp"%>

<script type="text/javascript">
		$(function() {
			$("#btn").click(function() {
				if(!chkData("#passwdCheck", "비밀번호를")) return;
				else if($("#passwdCheck").val() != ${check.passwd }) {
					alert("비밀번호가 다름");
				} else if(${hd }== 1){
					$("#passwdForm").attr({
						"method":"post",
						"action":"/board/updateForm.do"
					});
					$("#passwdForm").submit();
				}else{
					$("#passwdForm").attr({
						"method":"post",
						"action":"/board/deleteBoard.do"
					});
					$("#passwdForm").submit();
				}
			})
			
			$("#listBtn").click(function() {
				location.href="/board/getBoardList.do";
			})
		})
</script>
	
	</head>
	<body>
		
		<form class="form-horizontal" id="passwdForm">
			<input type="hidden" name="num" id="num" value=${check.num } />
			<input type="hidden" name="author" id="author" value="${check.author }" />
			<input type="hidden" name="pass" id="pass" value="${check.passwd }" />
			<input type="hidden" name="content" id="content" value="${check.content }" />
		<div class="container">
			<div class="text-center"><h3>${wd } 비밀번호 입력</h3></div>

			<div class="form-group">
<!-- 				<label for="passwd" class="col-sm-2 control-label">비밀번호</label> -->
				<div class="col-sm-10">
				<input type="password" class="form-control" id="passwdCheck" name="passwdCheck" placeholder="비밀번호 입력">
				</div>
			</div>
			<div class="contentBtn text-right">
			<button type="button" id="btn" name="btn" class="btn btn-primary btn-sm">확인</button>
			<button type="button" id="listBtn" name="listBtn" class="btn btn-primary btn-sm">목록</button>
		</div>
		</div>
		</form>
		
	</body>
</html>