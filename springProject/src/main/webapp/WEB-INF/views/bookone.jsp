<%@page import="com.hi.mvcProject.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/project.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#del').click(function(){
			if(confirm("정말로 삭제하시겠습니까?")){
				/* location="delete?id="+${one.id}; */
				$.ajax({
					url: "delete",
					data: {
						id: "${one.id}"
					},
					success: function(){
						alert('글이 삭제되었습니다.')
						location.href="bbs.jsp"
					}
				})
			}
		})
	})
</script>
</head>
<body>
	<div id="total">
		<div id="top">
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="top2">
			<jsp:include page="../../top2.jsp"></jsp:include>
		</div>
		<div id="center">
			<table border="1">
				<tr>
					<td class="left">번호</td>
					<td class="right">${one.id}</td>
					<!-- one.getId() -->
				</tr>
				<tr>
					<td class="left">제목</td>
					<td class="right">${one.title}</td>
				</tr>
				<tr>
					<td class="left">내용</td>
					<td class="right">${one.content}</td>
				</tr>
				<tr>
					<td class="left">작성자</td>
					<td class="right">${one.writer}</td>
				</tr>
			</table>
			<a href="bbs.jsp"><button class='btn-success'>목록</button></a> 
			
			<!--로그인한 사람과 작성자가 동일하면 수정, 삭제버튼을 나타나게 해주자.
				세션값과 on.getWriter()가 동일하면!-->
			<c:if test="${userId eq one.writer}">
			
			</c:if>
				
				
			<%
			if(session.getAttribute("userName")!=null)
			{
				BbsVO one= (BbsVO)request.getAttribute("one");
				
				if(session.getAttribute("userName").equals(one.getWriter())){ %>
			<a href="update?id=<%=one.getId()%>&content=<%=one.getContent()%>&writer=<%=one.getWriter()%>"><button class='btn-success'>수정</button></a> 
			<button id=del class='btn-success'>삭제</button>
			<%}
			}
			%>
		</div>
	<div id="d1">
	<h3>댓글 들어가는 부분</h3>
	</div>
	</div>
</body>
</html>