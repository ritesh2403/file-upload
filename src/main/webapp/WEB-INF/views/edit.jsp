<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<br> <br>
		<table>
			<tr>
				<th>CreditLimit</th>

			</tr>


			<c:forEach var="tempCustomers" items="${Customers}">

				<tr>
					<td>${tempCustomers.credit}</td>


				</tr>


			</c:forEach>

		</table>
	</form>


</body>
</html>