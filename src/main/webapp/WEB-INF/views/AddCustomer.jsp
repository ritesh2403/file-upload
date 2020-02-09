<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<style>
.error {
	color: red
}
</style>

<meta charset="UTF-8">

<title>Save Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/add-customer-style.css">




</head>

<body>

	<div id="wrapper">

		<div id="header">

			<h2>CRM-CUSTOMER RELATIONSHIP MANAGER</h2>

		</div>

	</div>


	<div id="container">

		<h3>SAVE CUSTOMER</h3>


		<form:form id="form" action="savecustomer" modelAttribute="Customers"
			method="post">


			<table>

				<tr>

					<td><label>First name:</label></td>

					<td><form:input path="firstName"></form:input></td>

					<td><form:errors path="firstName" cssClass="error" /></td>

					<br>

					<br>

				</tr>


				<tr>

					<td><label>Last name:</label></td>

					<td><form:input path="lastName" /></td>

					<td><form:errors path="lastName" cssClass="error" /></td>

				</tr>

				<br>

				<br>

				<tr>

					<td><label>Email:</label></td>

					<td><form:input path="email" /></td>

					<td><form:errors path="email" cssClass="error" /></td>

				</tr>

				<br>

				<br>



				<tr>

					<td><label></label></td>

					<td><input type="submit" value="Save" class="save" /></td>

				</tr>


			</table>


		</form:form>


		<div style=""></div>

		<p>

			<a href="${pageContext.request.contextPath}/customer/list">BACK

				TO LIST</a>

		</p>

	</div>

</body>
<script>

$('update').click(function(e){
	$form=$("#form");
	var formdata=$("#form").serialize();
	if($form.valid()){
		$.post('update',formdata,fucntion(data)){
			$('#ajaxload').html(data);
			$('#ajaxload.contain-fluid').addclass('fade-in');
		}).fail function(){
	$('#ajaxload').html(data);
	$('#ajaxload.contain-fluid').addclass('fade-out');
	
});
		
		
});
</script>
</html>