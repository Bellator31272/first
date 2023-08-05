<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

</head>
<body>
	<div class="contentBtn text-right">
		<button type="button" id="delete" class="btn btn-primary btn-sm">삭제</button>
		<form name="deleteForm" id="deleteForm">
			<input type="hidden" name="num" id="num" />
		</form>
	</div>
</body>
</html>