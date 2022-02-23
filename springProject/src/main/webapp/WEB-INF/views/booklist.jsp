<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
   <tr>
      <td class="left">번호</td>
      <td class="left">제목</td>
      <td class="left">작성자</td>
   </tr>
   <c:forEach items="${list}" var="one">
   <tr>
      <td class="right">${one.id}</td>
      <td class="right"><a href="bookone?id=${one.id}">${one.title}</a></td>
      <td class="right">${one.writer}</td>     
   </tr>
   </c:forEach>
</table>