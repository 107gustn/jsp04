<%@page import="membership.MembershipDTO"%>
<%@page import="membership.MembershipDAO"%>
<%@page import="org.apache.catalina.tribes.membership.Membership"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		let id1 = request.getParameter("id")
		let id2 = dto.getId()
		let pwd1 = request.getParameter("pwd")
		let pwd2 = dto.getName()
		if ( id1.value != id2.value) {
			alert('일치하는 아이디가 없습니다.')
		} else {
			alert('비밀번호가 다릅니다.')
		}
	}
</script>
</head>
<body>
	<%
		MembershipDAO dao = new MembershipDAO();
		MembershipDTO dto = dao.getMembers(request.getParameter("id"));
	
	
		String uid = request.getParameter("id");
		String upwd = request.getParameter("pwd");
		if(dto.getId() != null) {
			if(dto.getId().equals(uid) && dto.getPwd().equals(upwd)) {
			session.setAttribute("name", dto.getName());
			response.sendRedirect("main.jsp");
			} else{
			%>
				<script type="text/javascript">
				alert('비밀번호가 틀립니다.')
				</script>
			<%
				response.sendRedirect("login.jsp");
			}
		}else {
			%>
				<script type="text/javascript">
				alert('일치하는 아이디가 없습니다.')
				</script>
			<%
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>