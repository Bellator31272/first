<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<title>회원 로그인</title>
<script type="text/javascript">
		$(function() {
			$("#joinBtn").click(function() {
				location.href="/member/insertForm.do";
			})
			
			$("#loginBtn").click(function(event){
				memberPwdConfirm();
			});
		})
		
		function memberPwdConfirm(){
			if (!chkData('#id','아이디를'))	return;
			else if (!chkData('#passwd','비밀번호를'))	return;
			else {	
				$.ajax({
					url : "/member/passCheck.do",  //전송 url
					type : "post",                // 전송 시 method 방식
					data : $("#loginForm").serialize(),   //폼전체 데이터 전송
					dataType : "text",
					error : function(){             //실행시 오류가 발생하였을 경우
						$("#msg").text("시스템 오류 입니다. 관리자에게 문의 하세요").css("color","red");
					},                            //정상적으로 실행이 되었을 경우
					success : function(result1){ 
						if(result1==0){     // 일치하지 않는 경우
							$("#msg").text("비밀번호가 일치하지 않습니다.").css("color","red");
							$("#passwd").select();
						}else if(result1==1){ // 일치할 경우
							$("#msg").text("");
							//console.log("비밀번호 일치");
							$("#loginForm").attr("action","/member/loginBoard.do");
							$("#loginForm").attr("method", "post");
							$("#loginForm").submit();
								
						}	
					}
				});
			}
		}
	</script>

	</head>
	<body>
	<body>
		<form class="form-horizontal" id="loginForm">
		<div class="container">
			<div class="text-center"><h3>로그인</h3></div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="id" name="id" placeholder="아이디 입력" maxlength="20">
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력">
					<span id="msg"></span>
				</div>
			</div>
			<div class="contentBtn text-right">
				<button type="button" id="loginBtn" name="loginBtn" class="btn btn-primary btn-sm">로그인</button>
				<button type="button" id="joinBtn" name="joinBtn" class="btn btn-primary btn-sm">회원가입</button>
			</div>
		</div>
		</form>
	</body>
	</body>
</html>