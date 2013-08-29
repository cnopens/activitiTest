<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Process Definitions</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="processDefinition" items="${processDefinitions}">
					<form action="${linkTo[ProcessDefinitionController].start[processDefinition.id]}" method="POST">
					<tr>
						<td>${processDefinition.name}</td>
						<td>
							<button type="submit">Iniciar</button>
						</td>
					</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>