<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	main.jsp
	
	<script type="text/javascript">
		alert( '<%=session.getAttribute("name") %>' + '님 반갑습니다.')
	</script>
</body>
</html>