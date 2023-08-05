<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>내정보</title>

<style type="text/css">
 			#pwdChk{visibility:hidden;}
/* 			#boardPwdBut{margin-bottom: 8px;} */
/* 			.table-height{height: 200px;} */
/* 			.table-height .text-vertical{vertical-align: middle;} */
</style>

	<script type="text/javascript">
	$(function() {
		$("#boardBtn").click(function() {
			location.href="/board/getBoardList.do";
		})
		$("#logoutBtn").click(function() {
			location.href="/member/logout.do";
		})
		
		$("#updateBtn").click(function(){
			$("#pwdChk").css("visibility","visible");
			$("#msg").text("비밀번호 확인").css("color","#000099");
			buttonCheck = "update";
		});
		
		$("#deleteBtn").click(function(){
			$("#pwdChk").css("visibility","visible");
			$("#msg").text("비밀번호 확인").css("color","#000099");
			buttonCheck = "delete";
		});
		
		$("#pwdBut").click(function(event){
			memberPwdConfirm();
		});

		$("#pwdButCancel").click(function(){
			$("#passwd").val("");
			$("#pwdChk").css("visibility","hidden");
			buttonCheck = "";
		});
	})
	
function memberPwdConfirm(){
	if (!chkData('#passwd',"비밀번호를"))	return;
	else {	
		$.ajax({
			url : "/member/passCheck.do",  //전송 url
			type : "post",                // 전송 시 method 방식
			data : $("#passwdChk").serialize(),   //폼전체 데이터 전송
			dataType : "text",
			error : function(){             //실행시 오류가 발생하였을 경우
				$("#msg").text("시스템 오류 입니다. 관리자에게 문의 하세요").css("color","red");
			},                            //정상적으로 실행이 되었을 경우
			success : function(result1){ 
				let goUrl="";         // 이동할 경로를 저장할 변수
				if(result1==0){     // 일치하지 않는 경우
					$("#msg").text("작성시 입력한 비밀번호가 일치하지 않습니다.").css("color","red");
					$("#passwd").select();
				}else if(result1==1){ // 일치할 경우
					$("#msg").text("");
					//console.log("비밀번호 일치");
					
					if(buttonCheck=="update"){ // 수정버튼 클릭
						goUrl = "/member/updateForm.do";
						$("#form").attr("action",goUrl);
						$("#form").attr("method", "post");
						$("#form").submit();
					} else if(buttonCheck=="delete"){ // 삭제버튼 클릭
						if(confirm("회원탈퇴를 하시겠습니까?")){
							goUrl = "/member/deleteMember.do";
							$("#form").attr("action",goUrl);
							$("#form").attr("method", "post");
							$("#form").submit();
						}
					}
					
				}
			}
		});
	}
}
	</script>

	</head>
	<body>
	<div class="container">
		<div class="text-center">
			<h3>마이페이지</h3>
		
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td class="col-md-3">아이디</td>
						<td class="col-md-9 text-left">${data.id}</td>
					</tr>
					<tr>
						<td class="col-md-3">이름</td>
						<td  class="col-md-9 text-left">${data.name }</td>
					</tr>
					<tr class="table-height">
						<td class="text-valign">이메일주소</td>
						<td class="text-left">${data.email }</td>
					</tr>
					<tr class="table-height">
						<td class="text-valign">전화번호</td>
						<td class="text-left">${data.phone }</td>
					</tr>
					<tr class="table-height">
						<td class="text-valign">가입일</td>
						<td class="text-left">${data.regdate }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<form class="form-horizontal" id="form" name="form">
			<input type="hidden" id="id" name="id" value="${data.id }" />
		<div class="contentBtn text-right">
<!-- 			<a href="/board/getBoardList.do">게시판 이동</a>  -->
			<button type="button" id="boardBtn" name="boardBtn" class="btn btn-primary btn-sm">게시판이동</button>
			<button type="button" id="logoutBtn" name="logoutBtn" class="btn btn-primary btn-sm">로그아웃</button>
			<button type="button" id="updateBtn" name="updateBtn" class="btn btn-primary btn-sm">정보수정</button>
			<button type="button" id="deleteBtn" name="deleteBtn" class="btn btn-primary btn-sm">회원탈퇴</button>
		</div>
		</form>
		<div id="pwdChk" class="col-md-9 text-right">
		<form name="passwdChk" id="passwdChk" class="form-inline">
			<input type="hidden" name="id" id="id" value="${data.id}">
			<label for="passwd" id="1_fwd">비밀번호 : </label>
			<input type="password" name="passwd" id="passwd" class="form-control"/>
			<button type="button" id="pwdBut" class="btn btn-default btn-sm">확인</button>
			<button type="button" id="pwdButCancel" class="btn btn-default btn-sm">취소</button>
			<br /><span id="msg"></span>	
		</form>
		</div>
	</div>
	</body>
</html>