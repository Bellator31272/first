<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ page trimDirectiveWhitespaces="true" %>

<style type="text/css">
 			#pwdChk{visibility:hidden;}
			#boardPwdBut{margin-bottom: 8px;}
			.table-height{height: 200px;}
			.table-height .text-vertical{vertical-align: middle;}
</style>

<script type="text/javascript">
let buttonCheck = ""; // buttonCheck는 수정버튼과 삭제버튼을 구별하기 위한 변수
$(function(){				
	/* 수정 버튼 클릭 시 처리 이벤트 */
	$("#updateBtn").click(function(){
		/*$("#f_data").attr({
			"method":"post",
			"action":"/board/updateForm.do"
		});
		$("#f_data").submit();*/
		
		// 비밀번호 확인 후 처리
		$("#pwdChk").css("visibility","visible");
		$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color","#000099");
		buttonCheck = "updateButton";
		
	});
	
	/* 삭제 버튼 클릭 시 처리 이벤트 */
	$("#deleteBtn").click(function(){
		/*$("#f_data").attr({
			"method":"post",
			"action":"/board/deleteBoard.do"
		});
		$("#f_data").submit();*/
		
		// 비밀번호 확인 후 처리
		$("#pwdChk").css("visibility","visible");
		$("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color","#000099");
		buttonCheck = "deleteButton";
	});
	
	$("#passwd").bind("keydown", function (event) {
		if(event.keycode == 13){
			event.preventDefault();
			//$("#pwdBut").click();
		}
	});
	
	/* 비밀번호 확인 버튼 클릭 시 처리 이벤트 */
	$("#pwdBut").click(function(event){
		boardPwdConfirm();
	});

	/* 비밀번호 취소 버튼 클릭 시 처리 이벤트 */
	$("#pwdButCancel").click(function(){
		$("#passwd").val("");
		$("#pwdChk").css("visibility","hidden");
		buttonCheck = "";
	});
	
	/* 목록 버튼 클릭 시 처리 이벤트 */
	$("#listBtn").click(function(){
		location.href="/board/getBoardList.do";
	});
});

/* 비밀번호 클릭시 실질적인 처리 함수 */
function boardPwdConfirm(){
	if (!chkData('#passwd',"비밀번호를"))	return;
	else {	
		$.ajax({
			url : "/board/passwdCheck.do",  //전송 url
			type : "post",                // 전송 시 method 방식
			data : $("#f_pwd").serialize(),   //폼전체 데이터 전송
			dataType : "text",
			error : function(){             //실행시 오류가 발생하였을 경우
				alert('시스템 오류 입니다. 관리자에게 문의 하세요');
			},                            //정상적으로 실행이 되었을 경우
			success : function(result){ 
				let goUrl="";         // 이동할 경로를 저장할 변수
				if(result==0){     // 일치하지 않는 경우
					$("#msg").text("작성시 입력한 비밀번호가 일치하지 않습니다.").css("color","red");
					$("#passwd").select();
				}else if(result==1){ // 일치할 경우
					$("#msg").text("");
					//console.log("비밀번호 일치");
					
					if(buttonCheck=="updateButton"){ // 수정버튼 클릭
						goUrl = "/board/updateForm.do";
						$("#f_data").attr("action",goUrl);
						$("#f_data").submit();
					} else if(buttonCheck=="deleteButton"){ // 삭제버튼 클릭
						if(confirm("정말 삭제하시겠습니까?")){
							goUrl = "/board/deleteBoard.do";
							$("#f_data").attr("action",goUrl);
							$("#f_data").submit();
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
			<h3>게시판 상세화면 ${detail.num} / ${detail.passwd}</h3>
		</div>
		<form name="f_data" id="f_data" method="post">
			<input type="hidden" name="num" value="${detail.num}">
		</form>

		<div id="boardPwdBut" class="row text-center">
		<div id="pwdChk" class="col-md-9 text-left">
		<form name="f_pwd" id="f_pwd" class="form-inline">
			<input type="hidden" name="num" value="${detail.num}">
			<label for="passwd" id="1_fwd">비밀번호 : </label>
			<input type="password" name="passwd" id="passwd" class="form-control"/>
			
			<button type="button" id="pwdBut" class="btn btn-default btn-sm">확인</button>
			<button type="button" id="pwdButCancel" class="btn btn-default btn-sm">취소</button>
			<span id="msg"></span>	
			
		</form>
		</div>
			<div class="col-md-3 text-right">
				<button type="button" id="updateBtn" class="btn btn-primary btn-sm">수정</button>
				<button type="button" id="deleteBtn" class="btn btn-primary btn-sm">삭제</button>
				<button type="button" id="boardReply" class="btn btn-primary btn-sm">답변</button>
				<button type="button" id="listBtn" class="btn btn-primary btn-sm">목록</button>
			</div>
		
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td class="col-md-3">글번호</td>
						<td class="col-md-3 text-left">${detail.num}<label>(조회수
								: ${detail.readcnt})</label></td>
						<td class="col-md-3">작성일</td>
						<td class="col-md-3 text-left">${detail.writeday}</td>
					</tr>
					<tr>
						<td class="col-md-3">작성자</td>
						<td colspan="3" class="col-md-9 text-left">${detail.author}</td>
					</tr>
					<tr>
						<td class="col-md-3">글제목</td>
						<td colspan="3" class="col-md-9 text-left">${detail.title}</td>
					</tr>
					<tr class="table-height">
						<td class="text-valign">글내용</td>
						<td colspan="3" class="text-left">${detail.content}</td>
					</tr>
				</tbody>
			</table>
		
		</div>
	</div>
</body>
</html>