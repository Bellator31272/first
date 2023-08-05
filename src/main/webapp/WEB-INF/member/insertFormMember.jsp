<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<title>회원가입</title>
<script type="text/javascript">
		$(function() {
			var ck=0;
			$("#idChk").click(function() { 
				if (!chkData('#id','아이디를')){
					$("#idChkMsg").text("");
					return;
				}
				else{
					$.ajax({
					url : "/member/idCheck.do",  //전송 url
					type : "post",                // 전송 시 method 방식
					data : $("#f_writeForm").serialize(),   //폼전체 데이터 전송
					dataType : "text",
					error : function(){             //실행시 오류가 발생하였을 경우
						$("#idChkMsg").text("시스템 오류 입니다. 관리자에게 문의 하세요").css("color","red");
					},                            //정상적으로 실행이 되었을 경우
					success : function(result){ 
						if(result==1){     
							$("#idChkMsg").text("아이디 중복.").css("color","red");
							$("#id").select();
						}else if(result==0){ 
							$("#idChkMsg").text("사용가능한 아이디.").css("color","blue");
							ck=1;
						}	
					}
				});
				}
	        })
			
			$("#joinBtn").click(function() {
				console.log(ck);
				if (!chkData('#id','아이디를'))	return;
				else if (!chkData('#passwd','비밀번호를'))	return;
				else if (!chkData('#name','이름을'))	return;
				else if (!chkData('#email','이메일을'))	return;
				else if (!chkData('#phone','전화번호를'))	return;
				else {
					$("#f_writeForm").attr({
						"method":"post",
						"action":"/member/insertMember.do"
					});
					if(ck!=0){
						$("#f_writeForm").submit();
					} else {
						$("#idChkMsg").text("아이디 중복체크 하라고").css("color","red");
					}
				}
			})
		});
				
	</script>

	</head>
	<body>
	<body>
		<form class="form-horizontal" id="f_writeForm">
		<div class="container">
			<div class="text-center"><h3>정보 입력</h3></div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="id" name="id" placeholder="아이디 입력" maxlength="20">
				<button type="button" id="idChk" name="idChk" class="btn btn-primary btn-sm">중복확인</button>
				<span id="idChkMsg"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
				<input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력">
				</div>
			</div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="name" name="name" placeholder="이름 입력" maxlength="20">
				</div>
			</div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">이메일</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="email" name="email" placeholder="이메일 입력" maxlength="20">
				</div>
			</div>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">전화번호</label>
				<div class="col-sm-10">
				<input type="text"  class="form-control" id="phone" name="phone" placeholder="전화번호 입력" maxlength="20">
				</div>
			</div>
			<div class="contentBtn text-right">
			<button type="button" id="joinBtn" name="joinBtn" class="btn btn-primary btn-sm">회원가입</button>
		</div>
		</div>
		</form>
	</body>
	</body>
</html>