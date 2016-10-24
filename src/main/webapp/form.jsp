<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Форма ввода</title>
</head>
<body>
	<form action="/saveUser" method="POST">
		<label for="userName">Имя </label><input type="text" name="userName" id = "userName"><br>
		<label for="userAge">Возраст </label><input type="text" name="userAge" id = "userAge"><br>
		<button type="submit">Поехали!</button>
	</form>
</body>
</html>