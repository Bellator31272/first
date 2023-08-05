<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>


	<script type="text/javascript">
		$(function() {
			if('${param.keyword}'!=""){
				$("#keyword").val('${param.keyword}');
				$("#search").val('${param.search}');
			}
			
			
			$(".goDetail").click(function() {
				let num = $(this).parents("tr").attr("data-num");
// 				console.log("num = " + num);

				$("#num").val(num);
				
				// post 방식으로 상세 페이지 이동
				$("#detailForm").attr({
					"method":"post",
					"action":"/board/detailBoard.do"
				});
				$("#detailForm").submit();
				
				// get 방식으로 상세 페이지 이동
				// location.href=".board/detailBoard.do?num=" + num;
				
			});
			
			$("#writeForm").click(function() {
				location.href="/board/insertForm.do";
			});
			
			
			$("#searchData").click(function() {
				if($("#search").val()!="all"){
					if(!chkData("#keyword", "검색어를")) return;
				} else if($("#search").val()=="all"){
					$("#keyword").val("");
				}
				$("#f_search").attr({
					"method":"post",
					"action":"/board/getBoardList.do"
				})
				$("#f_search").submit();
			})
			
			$("#myPage").click(function() {
				location.href="/member/memberDetail.do";
			})
		});
	</script>
	
</head>
<body>
	
	<div class="container">
		<div class="text-center"><h3>게시판 리스트</h3></div>
		<div>
			<span id="myPage">${data.name }</span>님 환영합니다.
			
		</div>
		<div id="boardSearch" class="text-right"> 
		<form id="f_search" name="f_search" class="form-inline">
			<div class="form-group">
				 <label>검색조건</label>
				 <select id="search" name="search"  class="form-control">
							<option value="all">전체조회</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="author">작성자</option>
				</select>
				<input type="text" name="keyword" id="keyword" placeholder="검색어를 입력하세요" class="form-control" />
				<button type="button" id="searchData" class="btn btn-primary">검색</button>
			</div>
		</form>
		</div>
		
		<form name="detailForm" id="detailForm">
			<input type="hidden" name="num" id="num" />
		</form>
		
		<div class="boardList">
			<table summary="게시판 리스트" class="table table-borderred">
				<thead>
					<tr>
						<th class="col-md-1 text-center">번호</th>
						<th class="col-md-6 text-center">제목</th>
						<th class="col-md-2 text-center">작성자</th>
						<th class="col-md-2 text-center">날짜</th>
						<th class="col-md-1 text-center">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="vo" items="${list}">
								<tr class="text-center" data-num="${vo.num }">
									<td>${vo.num }</td>
									<td class="text-left"><span class="goDetail">${vo.title }</span></td>
									<td>${vo.author }</td>
									<td>${vo.writeday }</td>
									<td>${vo.readcnt }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center">등록된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>

		<div class="contentBtn text-right">
			<button type="button" id="writeForm" class="btn btn-primary btn-sm">글쓰기</button>
		</div>
	</div>
</body>
</html>