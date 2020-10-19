<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>List User</h1>

<div class="container">

	<a	href='<c:url value="/export"></c:url>'><i class="glyphicon glyphicon-plus"> Xuất</i></a>
	<a	href='<c:url value="/import"></c:url>'><i class="glyphicon glyphicon-plus"> Import</i></a>
	<a	href='<c:url value="/add"></c:url>'><i class="glyphicon glyphicon-plus"> Add</i></a>
	<table class="table"	id="tb">
	  <thead class="thead-dark">
	    <tr>	      
	      <th scope="col">Id</th>
	      <th scope="col">Hình ảnh</th>
	      <th scope="col">Tên tài khoản</th>
	      <th scope="col">Mật khẩu </th>
	      <th scope="col">Tên</th>
	      <th scope="col">Email</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${list}" var="item"> 
	  		<tr>
	  			<td>${item.id}</td>
	  			<td><img alt="" width="70px" height="70px" src='<spring:url value="${item.img}"></spring:url>'></td>
	  			<td>${item.username}</td>
	  			<td>${item.password}</td>
	  			<td>${item.name}</td>
	  			<td>${item.email}</td>
	  		</tr>
	  	</c:forEach>
	  </tbody>
</table>
</div>

<script type="text/javascript">
	//$(document).ready(function(){
		//loadTable();
		//search();
	//});
	function loadTable(){
		$.ajax({
			url : '<c:url value="/rest/users"/>',
			beforeSend : function(xhr){
				xhr.setRequestHeader('Accept','application/json');
				xhr.setRequestHeader('Content-Type','application/json');
			},
			success : function(data){
				var table = $("#tb");
				var content = "";
				for(var i = 0 ; i  < data.length ; i++){
					content +=	"<tr>"
							+		"<td>"+data[i].id+"</td>"
							+		"<td>"+data[i].username+"</td>"
							+		"<td>"+data[i].password+"</td>"	
							+		"<td>"+data[i].name+"</td>"	
							+		"<td>"+data[i].email+"</td>"	
							+	"</tr>"
				}
				table.append(content);
			}
		});
	}
	function search(){
		$("#search").change(function(){
			var name = $("#search").val();
			loadTable(name);
		});
	}

</script>

</body>
</html>