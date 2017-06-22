<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function goBack() {
		window.history.back();
	}
</script>

</head>
<body>

	<form:errors path="country.*"></form:errors>
	<h2>Add Country Details</h2>
	<table style="background-color: honeydew">
		<form action="add" method="POST" enctype="multipart/form-data">
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" /></td>
				</td>
			</tr>
			<tr>
				<td>Speciality :</td>
				<td><input type="text" name="speciality" /></td>
			</tr>
			<tr>
				<td>Corrency :</td>
				<td><input type="text" name="corrency" /></td>
			</tr>
			<tr>
				<td>population :</td>
				<td><input type="text" name="population" /></td>
			</tr>
			<tr>
				<td>Add Flag :</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td>File Name :</td>
				<td><input type="text" name="fileName" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</form>
	</table>
	${message}
	<div>
		<c:if test="${!empty result}">
			<h2>List Countries</h2>
			<table align="left" border="1" style="background-color: honeydew;">
				<tr>
					<th>Country ID</th>
					<th>Country Name</th>
					<th>Country Speciality</th>
					<th>Country Corrency</th>
					<th>Country population</th>
					<th>Country Flag</th>
					<th>Show Uploads</th>
					<th>delete Uploads</th>
					<th>Actions on Row</th>
				</tr>

				<c:forEach items="${result}" var="country_var">
					<tr>
						<td><c:out value="${country_var.id}" /></td>
						<td><c:out value="${country_var.name}" /></td>
						<td><c:out value="${country_var.speciality}" /></td>
						<td><c:out value="${country_var.corrency}" /></td>
						<td><c:out value="${country_var.population}" /></td>
						<td><c:out value="${country_var.fileName}" /></td>
						<td><a href="getImage?id=${country_var.id}">View</a></td>
						<td><a href="deleteImage?id=${country_var.id}" onclick="return confirm('Are you sure U want to delete uploaded file?')">Delete</a></td>
						<td align="center"><a href="edit?id=${country_var.id}">Edit</a>
							| <a href="delete?id=${country_var.id}" onclick="return confirm('Are you sure')">Delete</a></td>
					</tr>
				</c:forEach>
				<td>
					<button name="back">
						<a  style="text-decoration:none"href="wel">Go Back</a>
					</button>
				</td>
			</table>
	</div>
	</c:if>

</body>
</html>