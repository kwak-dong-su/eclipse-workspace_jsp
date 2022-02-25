<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
   <tr>
      <td class="left">예매번호</td>
      <td class="left">영화제목</td>
      <td class="left">상영시간</td>
      <td class="left">예매 변경</td>
      <td class="left">예매 취소</td>
   </tr>
   <c:forEach items="${list}" var="one">
   <tr>
      <td class="right">${one.tId}</td>
      <td class="right"><a href="mvOne?id=${one.mvId}">영화제목</a></td>
      <td class="right">${one.tTime+12}:00</td>     
      <td class="right"><a href="tUpdate.jsp?tId=${one.tId}"><button>변경</button></a></td>
      <td class="right"><a href="tDelete.jsp?tId=${one.tId}"><button>취소</button></a></td>
   </tr>
   </c:forEach>
</table>