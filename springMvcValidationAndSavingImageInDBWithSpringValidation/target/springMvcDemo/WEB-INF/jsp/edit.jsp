<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
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
${message}
	<c:forEach items="${result}" var="country_var">
		<form:form action="update" method="POST" enctype="multipart/form-data" commandName="country">
			<table style="background-color: honeydew">

				<tr>
					<td>Id:</td>
					<td><input type="text" name="id" value="${country_var.id}"
						readonly="readonly"/></td>
					
				</tr>
				<tr>
					<td>Name :</td>
					<td><form:input type="text" path="name" value="${country_var.name}"/></td>
					<td id="color"><form:errors path="name" /></td>
				</tr>
				<tr>
					<td>Speciality :</td>
					<td><form:input type="text" path="speciality"
						value="${country_var.speciality}"/></td>
					<td id="color"><form:errors path="speciality" /></td>
				</tr>
				<tr>
					<td>Corrency :</td>
					<td><form:input type="text" path="corrency"
						value="${country_var.corrency}"/></td>
					<td id="color"><form:errors path="corrency" /></td>
				</tr>
				<tr>
					<td>population :</td>
					<td><form:input type="text" path="population"
						value="${country_var.population}"/></td>
					<td id="color"><form:errors path="population" /></td>
				</tr>
				<tr>
					<td>Add Flag :</td>
					<td><form:input type="file" path="file" value="${country_var.file}" /></td>
					<td id="color"><form:errors path="file" /></td>
				</tr>
				<tr>
					<td>File Name :</td>
					<td><form:input type="text" path="fileName"
						value="${country_var.fileName}" /></td>
					<td id="color"><form:errors path="fileName" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form:form>
	</c:forEach>

</body>
</html>