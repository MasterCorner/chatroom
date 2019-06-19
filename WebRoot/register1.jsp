<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link href="imgs/favicon.ico" rel="shortcut icon" />
</head>
<body>

	<%
		Object msg = request.getAttribute("message");
		if(msg != null){
	%>
		<br>
		<font color="red"><%= msg %></font>
		<br>
		<br>
	<%
		}
	%>


	<form action="${pageContext.request.contextPath }/register"  onSubmit="return check()" method="post">
		<input type="hidden" name="method" value="register">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"
				value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>"/></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"
				value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"/></td>
			</tr>
		</table>	
	</form>
	

</body>
</html>