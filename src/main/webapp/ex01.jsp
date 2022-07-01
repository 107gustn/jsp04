<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
<%@page import="DBPKG.DBConnect"%>
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
		//사용자에게 정보를 보여줌
		MemberDAO dao = new MemberDAO(); //객체 생성, 생성자 호출
		ArrayList<MemberDTO> list = dao.getNewSt(); //DB로부터 사용자 정보를 얻어옴
		for(MemberDTO dto : list) {
	%>
			<a href="info.jsp?id=<%= dto.getId() %>">
				<%= dto.getId() %>
			</a>
			<br>
			<%= dto.getName() %><br>
			<%= dto.getAge() %><hr>
	<%	} %>
</body>
</html>