<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<center>

		<form method="POST" action="addProduct">
			<input type="number" name="id"><br>
			<br> <input type="text" name="productName"><br>
			<br> <input type="text" name="productDesc"><br>
			<br> <input type="number" name="productPrice"><br>
			<br> <input type="submit" value="Save">
		</form>
		<br>
		<br>

		<!--  <form  method="put" action="updateById">

<input type="text" name="id">
<input type="submit" value="updateById">
</form>
<br><br>-->

		<form action="getProduct">
			<input type="text" name="id"> <input type="submit"
				value="getById">
		</form>

		<br>
		<br>
		<form action="getAllProduct">
			<input type="submit" value="getAll">
		</form>
		<br>
		<br>


		<form action="deleteById">
			<input type="text" name="id"> <input type="submit"
				value="deleteById">
		</form>

	</center>
</body>
</html>