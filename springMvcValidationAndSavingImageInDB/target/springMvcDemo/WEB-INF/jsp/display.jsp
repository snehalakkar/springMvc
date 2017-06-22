<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Country details</title>
</head>
<body>
	<h2>List Countries</h2>
	<h3>
		<a href="addCountry">Add More Countries</a>
	</h3>

	<c:if test="${!empty result}">
		<table align="left" border="1" style="background-color: honeydew">
			<tr>
				<th>Country ID</th>
				<th>Country Name</th>
				<th>Country Speciality</th>
				<th>Country Corrency</th>
				<th>Country population</th>
				<th>Country Flag</th>
				<th>Show Uploads</th>
				<th>delete Uploads</th>
			</tr>

			<c:forEach items="${result}" var="country_var">
				<tr>
					<td><c:out value="${country_var.id}" /></td>
					<td><c:out value="${country_var.name}" /></td>
					<td><c:out value="${country_var.speciality}" /></td>
					<td><c:out value="${country_var.corrency}" /></td>
					<td><c:out value="${country_var.population}" /></td>
					<td><c:out value="${country_var.file}" /></td>
					<td ><a
						href="getImage?id=${country_var.id}">View</a></td>
						<td ><a
						href="deleteImage?id=${country_var.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

