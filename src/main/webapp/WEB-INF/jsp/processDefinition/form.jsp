<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Process Definition Form</title>
	</head>
	<body>
		<form action="${linkTo[ProcessDefinitionController].start[id]}" method="POST">
			<table>
				<tr>
					<th>Nome</th>
					<td>
						<input type="hidden" name="properties[0].id" value="employeeName" />
						<input type="text" name="properties[0].value" value="" />
					</td>
				</tr>
				<c:forEach var="property" items="${formData.formProperties}" varStatus="count">
					<tr>
						<th>${property.name}</th>
						<td>
							<input type="hidden" name="properties[${count.index + 1}].id" value="${property.id}" />
							<input type="text" name="properties[${count.index + 1}].value" value="${property.value}" />
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<button type="submit">Iniciar</button>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>