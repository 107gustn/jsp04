<%@page import="student.StudentDTO"%>
<%@page import="student.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인적 사항</h1>
	<%
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = dao.stInfo( request.getParameter("name")); 
	%>
	학번 : <%= dto.getId() %><br>
	이름 : <%= dto.getName() %><br>
	국,영,수 : <%= dto.getKor() %>, <%= dto.getEng() %>, <%= dto.getMath() %>
	

</body>
</html>