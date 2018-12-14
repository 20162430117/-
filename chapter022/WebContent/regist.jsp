<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册</title>
</head>
<body>

	<form action="FormResquestServlet" method="post">
		<P>
			用户名: <input type="text" name="username">
		</P>
		<P>
			密&nbsp;码: <input type="password" name="password">
		</P>
		<P>
			信息来源 <input type="checkbox" name="channel" value="web">网络 <input
				type="checkbox" name="channel" value="Newspaper">报纸 <input
				type="checkbox" name="channel" value="Friend">亲友
		</P>
		<p>
			<input type="submit" value="提交" /> <input type="submit" value="重置" />
		</p>
	</form>
</body>
</html>
