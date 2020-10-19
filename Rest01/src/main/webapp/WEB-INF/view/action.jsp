<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<form:form modelAttribute="submitForm" action="save" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username" cssClass="form-control"	placeholder="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" cssClass="form-control"	placeholder="password"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" cssClass="form-control"	placeholder="name"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" cssClass="form-control"	placeholder="email"/></td>
			</tr>
			<tr>
				<td>Upload : </td>
				<td><form:input path="multipartFile" cssClass="form-control" type="file"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>Add</button> 
				</td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>