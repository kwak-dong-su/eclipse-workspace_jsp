<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr>
	<td style="text-align: left"><img src="resources/img/re.png"
		width="30" height="30">${one.content} - ${one.writer}</td>
	<td><c:if test="${userId eq one.writer}">
			<button id="deleteBtn">X</button>
		</c:if></td>
</tr>