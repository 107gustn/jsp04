<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
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
	<%
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentDTO> list = dao.getStudent();
	%>
		
	<table border="1">
		<tr>
			<th>학번</th><th>이름</th><th>국어</th><th>영어</th><th>수학</th>
		</tr>
		<%
			for(StudentDTO dto : list) {
		%>
				<tr>
					<td><%= dto.getId() %></td>
					<td><a href="quizinfo.jsp?name=<%= dto.getName() %>"><%= dto.getName() %></a></td>
					<td><%= dto.getKor() %></td>
					<td><%= dto.getEng() %></td>
					<td><%= dto.getMath() %></td>
				</tr>
		<%
			}
		%>
	</table>

</body>
</html>