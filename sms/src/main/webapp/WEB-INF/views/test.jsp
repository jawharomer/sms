<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>
	<h1>Spring MVC file upload example</h1>

	<form method="POST" action="/sms/testme" enctype="multipart/form-data">
		<input type="file" name="file" /><br /> <input type="submit"
			value="Submit" />
	</form>

</body>
</html>
