<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ${result} --%>

	<%--  editResult :<%=request.getAttribute("result") %> --%>
	<h2>Edit Country Details</h2>

	<c:forEach items="${result}" var="country_var">
		<form action="update" method="POST" enctype="multipart/form-data">
			<table style="background-color: honeydew">

				<tr>
					<td>Id:</td>
					<td><input type="text" name="population"
						value="${country_var.id}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" value="${country_var.name}"></td>
				</tr>
				<tr>
					<td>Speciality :</td>
					<td><input type="text" name="speciality"
						value="${country_var.speciality}"></td>
				</tr>
				<tr>
					<td>Corrency :</td>
					<td><input type="text" name="corrency"
						value="${country_var.corrency}"></td>
				</tr>
				<tr>
					<td>population :</td>
					<td><input type="text" name="population"
						value="${country_var.population}"></td>
				</tr>
				<tr>
					<td>Add Flag :</td>
					<td><input type="file" name="file" value="${country_var.file}" /></td>
				</tr>
				<tr>
					<td>File Name :</td>
					<td><input type="text" name="fileName" value="${country_var.fileName}"/></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</c:forEach>

</body>
</html>