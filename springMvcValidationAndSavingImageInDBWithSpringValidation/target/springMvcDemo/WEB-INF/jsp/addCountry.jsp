<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#color{
color: red;
}
</style>
</head>
<body>

	<%-- <form:errors path="country.*"></form:errors> --%>
	<h2>Add Country Details</h2>
	<table style="background-color: honeydew">
		<form:form action="add" method="POST" enctype="multipart/form-data" commandName="country">
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="name" /></td>
				<td id="color"><form:errors path="name"/></td>
			</tr>
			<tr>
				<td>Speciality :</td>
				<td><form:input type="text" path="speciality" /></td>
				<td id="color"><form:errors path="speciality"/></td>
			</tr>
			<tr>
				<td>Corrency :</td>
				<td><form:input type="text" path="corrency" /></td>
				<td id="color"><form:errors path="corrency"/></td>
			</tr>
			<tr>
				<td>population :</td>
				<td><form:input type="text" path="population" /></td>
				<td id="color"><form:errors path="population"/></td>
			</tr>
			<tr>
				<td>Add Flag :</td>
				<td><form:input type="file" path="file" /></td>
				<td id="color"><form:errors path="file"/></td>
			</tr>
			<tr>
				<td>File Name :</td>
				<td><form:input type="text" path="fileName" /></td>
				<td id="color"><form:errors path="fileName"/></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</form:form>
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
						<td align="center"><a href="edit11?id=${country_var.id}">Edit</a>
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