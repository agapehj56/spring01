<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item.jsp</title>
<!-- code_assist -->
<c:if test="false">
	<link rel="stylesheet" href="../../code_assist/animate.css">
	<link rel="stylesheet" href="../../code_assist/bootstrap.css">
</c:if>
</head>
<body>
${error} <br>

${country.code} ${country.name} ${country.population}<br>
<hr>
<ol>
	<c:forEach var="city" items="${country.citys}">
		<li>${city.id}, ${city.name}, ${city.population}</li>
	</c:forEach>
</ol>
${country}
</body>
</html>